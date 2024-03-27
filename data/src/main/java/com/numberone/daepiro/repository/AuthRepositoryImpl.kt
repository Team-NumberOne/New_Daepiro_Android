package com.numberone.daepiro.repository

import com.numberone.daepiro.model.remote.Login
import com.numberone.daepiro.model.remote.request.LoginRequest
import com.numberone.daepiro.model.remote.response.toDomain
import com.numberone.daepiro.network.NetworkService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepositoryImpl @Inject constructor(
    private val networkService: NetworkService,
): AuthRepository {
    override suspend fun loginWithKakao(token: String): Flow<Login> = flow {
        emit(
            networkService.loginWithKakao(
                LoginRequest(
                    token = token
                )
            ).toDomain()
        )
    }

}