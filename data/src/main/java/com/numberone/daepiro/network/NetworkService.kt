package com.numberone.daepiro.network

import com.numberone.daepiro.model.remote.request.LoginRequest
import com.numberone.daepiro.model.remote.response.LoginResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface NetworkService {

    // 카카오 로그인
    @POST("/token/kakao")
    suspend fun loginWithKakao(
        @Body body: LoginRequest
    ): LoginResponse

}