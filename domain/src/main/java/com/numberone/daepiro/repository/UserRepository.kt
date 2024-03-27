package com.numberone.daepiro.repository

import com.numberone.daepiro.model.remote.Login
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun loginWithKakao(
        token: String
    ): Flow<Login>

}
