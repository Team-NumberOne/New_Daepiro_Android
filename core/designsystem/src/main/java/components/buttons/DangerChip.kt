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
import com.numberone.daepiro.designsystem.theme.Danger
import com.numberone.daepiro.designsystem.theme.On_Danger
import com.numberone.daepiro.designsystem.theme.On_Safe
import com.numberone.daepiro.designsystem.theme.Safe

enum class RiskColor(
    val backgroundColor : Color,
    val textColor : Color,
    val iconColor : Color
){
    DangerColor(
        backgroundColor = Danger,
        textColor = On_Danger,
        iconColor = On_Danger
    ),
    SaftyColor(
        backgroundColor = Safe,
        textColor = On_Safe,
        iconColor = On_Safe
    )
}
enum class RiskState{
    DANGER, SAFE
}
@Composable
fun DangerStateChip(state : RiskState){
    when(state){
        RiskState.DANGER -> DangerChip(text = "text", color = RiskColor.DangerColor)
        RiskState.SAFE -> DangerChip(text = "text", color = RiskColor.SaftyColor)
    }
}
@Composable
fun DangerChip(
    modifier: Modifier = Modifier,
    text : String,
    color: RiskColor
    ) {
    Box(
        modifier = modifier
            .background(color.backgroundColor, shape = RoundedCornerShape(4.dp))
            .padding(horizontal = 4.dp, vertical = 4.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = modifier.align(Alignment.CenterStart),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_warning),
                colorFilter = ColorFilter.tint(color.iconColor),
                contentDescription = null
            )
            Text(
                text = text,
                modifier = Modifier
                    .padding(start = 4.dp),
                style = DaepiroTheme.typography.caption,
                color = color.textColor
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun DangerChipPreview(){
    DangerStateChip(RiskState.DANGER)
}

@Composable
@Preview(showBackground = true)
fun SafeChipPreview(){
    DangerStateChip(RiskState.SAFE)
}