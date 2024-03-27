package com.numberone.daepiro.model.remote.request

import kotlinx.serialization.Serializable

@Serializable
data class LoginRequest(
    val token: String = ""
)