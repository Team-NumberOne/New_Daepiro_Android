package com.numberone.daepiro.designsystem.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

//fun colors() = DaepiroColors()
//fun fonts() = DaepiroTypography()

//@Composable
//fun DaepiroTheme(
//    colors: DaepiroColors = colors(),
//    typography: DaepiroTypography = fonts(),
//    content: @Composable () -> Unit
//) {
//    val view = LocalView.current
//
//    SideEffect {
//        if (!view.isInEditMode) {
//            val window = (view.context as Activity).window
//            window.statusBarColor = colors.White.toArgb()
//        }
//    }
//
//    CompositionLocalProvider(
//        LocalColors provides colors,
//        LocalTypography provides typography
//    ) {
//        content()
//    }
//
//}
@Composable
fun DaepiroTheme(
    content: @Composable () -> Unit,
){
    val typographyInstance = DaepiroTypography()

    CompositionLocalProvider(
        LocalColorScheme provides LightColorScheme,
        LocalTypography provides typographyInstance
    ) {
        MaterialTheme(
            colorScheme = lightColorScheme(
                background = DaepiroTheme.colorScheme.background
            ),
            content = content
        )
    }
}

object DaepiroTheme{
    val typography: DaepiroTypography
    @Composable
    @ReadOnlyComposable
    get() = LocalTypography.current

    val colorScheme: DaepiroColorScheme
        @Composable
        @ReadOnlyComposable
        get() = LocalColorScheme.current
}