package com.numberone.daepiro.model.remote

data class Login(
    val accessToken: String,
    val refreshToken: String,
    val isOnboarding: Boolean
)