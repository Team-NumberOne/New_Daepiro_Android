package com.numberone.daepiro.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import com.numberone.daepiro.model.remote.Login
import com.numberone.daepiro.model.remote.request.LoginRequest
import com.numberone.daepiro.model.remote.response.toDomain
import com.numberone.daepiro.network.NetworkService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataStoreRepositoryImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>
): DataStoreRepository {
    override suspend fun setUserToken(accessToken: String, refreshToken: String) {
        dataStore.edit {
            it[ACCESS_TOKEN] = accessToken
            it[REFRESH_TOKEN] = refreshToken
        }
    }

    override suspend fun getUserToken(): Flow<String> {
        return dataStore.data
            .catch {
                emit(emptyPreferences())
            }
            .map {
                it[ACCESS_TOKEN] ?: ""
            }
    }

    companion object {
        val ACCESS_TOKEN = stringPreferencesKey("access_token")
        val REFRESH_TOKEN = stringPreferencesKey("refresh_token")
    }
}