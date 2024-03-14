package com.numberone.daepiro.designsystem.theme.components.buttons

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.ui.unit.dp
import com.numberone.daepiro.core.designsystem.R
import com.numberone.daepiro.designsystem.theme.DaepiroTheme

enum class DangerState{
    DANGER, SAFE
}
@Composable
fun DangerStateChip(state : DangerState){
    when(state){
        DangerState.DANGER -> DangerChip(text = "text", backgroundColor = DaepiroTheme.colors.Danger, textColor = DaepiroTheme.colors.On_Danger, iconColor = DaepiroTheme.colors.On_Danger)
        DangerState.SAFE -> DangerChip(text = "text", backgroundColor = DaepiroTheme.colors.Safe, textColor = DaepiroTheme.colors.On_Safe, iconColor = DaepiroTheme.colors.On_Safe)
    }
}
@Composable
fun DangerChip(
    modifier: Modifier = Modifier,
    text : String,
    backgroundColor : Color,
    textColor : Color,
    iconColor : Color
    ) {
    Box(
        modifier = modifier
            .background(backgroundColor, shape = RoundedCornerShape(4.dp))
            .padding(horizontal = 4.dp, vertical = 4.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = modifier.align(Alignment.CenterStart),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_warning),
                colorFilter = ColorFilter.tint(iconColor),
                contentDescription = null
            )
            Text(
                text = text,
                modifier = Modifier
                    .padding(start = 4.dp),
                style = DaepiroTheme.typography.caption,
                color = textColor
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun DangerChipPreview(){
    DangerStateChip(DangerState.DANGER)
}

@Composable
@Preview(showBackground = true)
fun SafeChipPreview(){
    DangerStateChip(DangerState.SAFE)
}