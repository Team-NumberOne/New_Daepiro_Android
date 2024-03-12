package com.numberone.daepiro.designsystem.theme.themes

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView


fun colors() = DaepiroColors()
fun fonts() = DaepiroTypography()

@Composable
fun DaepiroTheme(
    colors: DaepiroColors = colors(),
    typography: DaepiroTypography = fonts(),
    content: @Composable () -> Unit
) {
    val view = LocalView.current

    SideEffect {
        if (!view.isInEditMode) {
            val window = (view.context as Activity).window
            window.statusBarColor = colors.White.toArgb()
        }
    }

    CompositionLocalProvider(
        LocalColors provides colors,
        LocalTypography provides typography
    ) {
        content()
    }

}