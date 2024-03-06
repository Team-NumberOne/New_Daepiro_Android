package com.numberone.daepiro.designsystem.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable

object DaepiroTheme {
    val colors: Colors
    @Composable
    @ReadOnlyComposable
    get() = LocalColors.current

    val typography: Type
    @Composable
    @ReadOnlyComposable
    get() = LocalTypography.current
}