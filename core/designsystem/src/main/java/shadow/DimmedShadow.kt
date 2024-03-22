package shadow

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

fun Modifier.DimmedShadow(
    color: Color = Color(0XFF000000),
    alpha: Float = 0.1f,
    borderRadius: Dp,
    offsetY1: Dp = 0.dp,
    offsetX1: Dp = 0.dp,
    offsetY2: Dp = 0.dp,
    offsetX2: Dp = 0.dp,
): Modifier = this
    .CustomShadow(
        color = color,
        alpha = alpha,
        borderRadius = borderRadius,
        shadowRadius = 20.dp,
        offsetY = offsetY1,
        offsetX = offsetX1
    )
    .CustomShadow(
        color = color,
        alpha = alpha,
        borderRadius = borderRadius,
        shadowRadius = 8.dp,
        offsetY = offsetY2,
        offsetX = offsetX2
    )