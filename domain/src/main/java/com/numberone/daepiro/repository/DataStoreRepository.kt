package com.numberone.daepiro.repository

import kotlinx.coroutines.flow.Flow

interface DataStoreRepository {
    suspend fun setUserToken(
        accessToken: String,
        refreshToken: String
    )

    suspend fun getUserToken(): Flow<String>
}
