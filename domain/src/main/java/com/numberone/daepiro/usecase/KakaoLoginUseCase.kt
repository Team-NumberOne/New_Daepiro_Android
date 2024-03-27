package com.numberone.daepiro.usecase

import com.numberone.daepiro.model.remote.Login
import com.numberone.daepiro.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class KakaoLoginUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(
        token: String
    ) : Flow<Login> = authRepository.loginWithKakao(token = token)
}
