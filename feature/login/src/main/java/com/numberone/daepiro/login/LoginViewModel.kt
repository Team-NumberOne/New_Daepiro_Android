package com.numberone.daepiro.login

import android.content.Context
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresExtension
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.model.ClientError
import com.kakao.sdk.common.model.ClientErrorCause
import com.kakao.sdk.user.UserApiClient
import com.numberone.daepiro.repository.DataStoreRepository
import com.numberone.daepiro.repository.UserRepository
import com.numberone.daepiro.usecase.KakaoLoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val kakaoLoginUseCase: KakaoLoginUseCase,
    private val dataStoreRepository: DataStoreRepository
): ViewModel() {

    fun loginWithKakao(context: Context) {
        // 카카오계정으로 로그인 공통 callback 구성
        // 카카오톡으로 로그인 할 수 없어 카카오계정으로 로그인할 경우 사용됨
        val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
            if (error != null) {
                Log.e("taag", "카카오계정으로 로그인 실패", error)
            } else if (token != null) {
                Log.i("taag", "카카오계정으로 로그인 성공 ${token.accessToken}")
                loginWithKakao(token.accessToken)
            }
        }

        // 카카오톡이 설치되어 있으면 카카오톡으로 로그인, 아니면 카카오계정으로 로그인
        if (UserApiClient.instance.isKakaoTalkLoginAvailable(context)) {
            UserApiClient.instance.loginWithKakaoTalk(context) { token, error ->
                if (error != null) {
                    Log.e("taag", "카카오톡으로 로그인 실패", error)

                    // 사용자가 카카오톡 설치 후 디바이스 권한 요청 화면에서 로그인을 취소한 경우,
                    // 의도적인 로그인 취소로 보고 카카오계정으로 로그인 시도 없이 로그인 취소로 처리 (예: 뒤로 가기)
                    if (error is ClientError && error.reason == ClientErrorCause.Cancelled) {
                        return@loginWithKakaoTalk
                    }

                    // 카카오톡에 연결된 카카오계정이 없는 경우, 카카오계정으로 로그인 시도
                    UserApiClient.instance.loginWithKakaoAccount(context, callback = callback)
                } else if (token != null) {
                    Log.i("taag", "카카오톡으로 로그인 성공 ${token.accessToken}")
                    loginWithKakao(token.accessToken)
                }
            }
        } else {
            UserApiClient.instance.loginWithKakaoAccount(context, callback = callback)
        }
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    private fun loginWithKakao(token: String) {
        viewModelScope.launch {
            kakaoLoginUseCase(
//                token = token
                token = "token99jdjd"
            ).onStart {
                Log.d("taag", "카톡로그인 시작")
            }.onCompletion {
                Log.d("taag", "카톡로그인 완료")
            }.catch { e ->
                Log.d("taag", "카톡로그인 에러")
                when (e) {
                    is HttpException -> {
                        Log.d("taag", e.code().toString())
                    }
                    else -> {}
                }
            }.collectLatest {
                dataStoreRepository.setUserToken(
                    accessToken = it.accessToken,
                    refreshToken = it.refreshToken
                )

                Log.d("taag", dataStoreRepository.getUserToken().first())
            }

        }
    }
}