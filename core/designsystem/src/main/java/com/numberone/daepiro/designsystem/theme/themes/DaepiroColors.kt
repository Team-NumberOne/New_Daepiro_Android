package com.numberone.daepiro.designsystem.theme.themes

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

class DaepiroColors(
    val Black: Color = Color(0xFF000000),
    val White : Color= Color(0xFFFFFFFF),
    val G_50: Color = Color(0xFFEEEEF1),
    val G_75: Color = Color(0xFFE4E5EA),
    val G_100: Color = Color(0xFFC9CCD4),
    val G_200: Color = Color(0xFFAFB3BF),
    val G_300: Color = Color(0xFF8B90A1),
    val G_400: Color = Color(0xFF757A8F),
    val G_500: Color = Color(0xFF525973),
    val G_600: Color = Color(0xFF4B5169),
    val G_700: Color = Color(0xFF3A3F52),
    val G_800: Color = Color(0xFF2D313F),
    val G_900: Color = Color(0xFF222530),

    val O_50: Color = Color(0xFFFff0ea),
    val O_100: Color = Color(0xFFFfd1bd),
    val O_200: Color = Color(0xFFFfba9d),
    val O_300: Color = Color(0xFFFF9B70),
    val O_400: Color = Color(0xFFFF8754),
    val O_500: Color = Color(0xFFFF6929),
    val O_600: Color = Color(0xFFE86025),
    val O_700: Color = Color(0xFFB54B1D),
    val O_800: Color = Color(0xFF8c3a17),
    val O_900: Color = Color(0xFF6B2C11),

    val Gre_50: Color = Color(0xFFE9F8F0),
    val Gre_100: Color = Color(0xFFBAE9D0),
    val Gre_200: Color = Color(0xFF98DEB9),
    val Gre_300: Color = Color(0xFF6ACF98),
    val Gre_400: Color = Color(0xFF4DC585),
    val Gre_500: Color = Color(0xFF20B766),
    val Gre_600: Color = Color(0xFF1DA75D),
    val Gre_700: Color = Color(0xFF178248),
    val Gre_800: Color = Color(0xFF126538),
    val Gre_900: Color = Color(0xFF0D4D2B),

    val R_50: Color = Color(0xFFFFEAE9),
    val R_100: Color = Color(0xFFFDBEBA),
    val R_200: Color = Color(0xFFFD9E98),
    val R_300: Color = Color(0xFFFC7269),
    val R_400: Color = Color(0xFFFB564C),
    val R_500: Color = Color(0xFFFA2C1F),
    val R_600: Color = Color(0xFFE4281C),
    val R_700: Color = Color(0xFFB21F16),
    val R_800: Color = Color(0xFF8A1811),
    val R_900: Color = Color(0xFF69120D),

    val Primary: Color = Color(0xFFFF6929),
    val Primary_Variant: Color = Color(0xFFB54B1D),
    val On_Primary:Color = Color(0xFFFFFFFF),

    val Secondary:Color = Color(0xFF525973),
    val Secondary_Variant: Color = Color(0xFF3A3F52),
    val On_Secondary: Color = Color(0xFFFFFFFF),

    val Background: Color = Color(0xFFFFFFFF),
    val On_Background: Color = Color(0xFF222530),

    val Surface_01: Color = Color(0xFFFFFFFF),
    val Surface_02 : Color = Color(0xFFEEEEF1),
    val Surface_03:Color = Color(0xFFFFF0EA),
    val On_Surface_01: Color = Color(0xFF222530),
    val On_Surface_02: Color = Color(0xFF222530),
    val On_Surface_03: Color = Color(0xFFFF6929),

    val Danger: Color = Color(0xFFFFEAE9),
    val On_Danger:Color = Color(0xFFFA2c1F),
    val Safe: Color = Color(0xFFE9F8F0),
    val On_Safe: Color = Color(0xFF20B766),

    val Outline: Color = Color(0xFFE4E5EA),
    val Dimmed: Color = Color(0x99000000).copy(alpha=0.6F),
    val On_Dmmed: Color = Color(0xFFFFFFFF)
)

val LocalColors = staticCompositionLocalOf { DaepiroColors() }