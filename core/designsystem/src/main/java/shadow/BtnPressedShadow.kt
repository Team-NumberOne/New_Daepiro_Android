package shadow

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
//shadowradius = blur효과에 해당
fun Modifier.BtnPressedShadow(
    color: Color = Color(0xFF222530),
    alpha: Float = 0.15f,
    borderRadius: Dp,
    offsetY1: Dp = 1.dp,
    offsetX1: Dp = 1.dp,
    offsetY2: Dp = 0.dp,
    offsetX2: Dp = 0.dp,
): Modifier = this
    .CustomShadow(
        color = color,
        alpha = alpha,
        borderRadius = borderRadius,
        shadowRadius = 2.dp,
        offsetY = offsetY1,
        offsetX = offsetX1
    )
    .CustomShadow(
        color = color,
        alpha = alpha,
        borderRadius = borderRadius,
        shadowRadius = 2.dp,
        offsetY = offsetY2,
        offsetX = offsetX2
    )