package shadow

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

fun Modifier.FloationShadow(
    color: Color = Color(0XFF000000),
    borderRadius: Dp,
    offsetY1: Dp = 0.dp,
    offsetX1: Dp = 0.dp,
    offsetY2: Dp = 2.dp,
    offsetX2: Dp = 2.dp,
): Modifier = this
    .CustomShadow(
        color = color,
        alpha = 0.15f,
        borderRadius = borderRadius,
        shadowRadius = 4.dp,
        offsetY = offsetY1,
        offsetX = offsetX1
    )
    .CustomShadow(
        color = color,
        alpha = 0.1f,
        borderRadius = borderRadius,
        shadowRadius = 4.dp,
        offsetY = offsetY2,
        offsetX = offsetX2
    )