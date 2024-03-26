package com.numberone.daepiro.model.remote.response

import com.numberone.daepiro.model.remote.Login
import kotlinx.serialization.Serializable

@Serializable
data class LoginResponse(
    val accessToken: String = "",
    val refreshToken: String = "",
    val isOnboarding: Boolean = false
)

internal fun LoginResponse.toDomain(): Login = Login(
    accessToken = this.accessToken,
    refreshToken = this.refreshToken,
    isOnboarding = this.isOnboarding
)