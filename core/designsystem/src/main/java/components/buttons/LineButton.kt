package com.numberone.daepiro.designsystem.theme.components.buttons

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.numberone.daepiro.core.designsystem.R
import com.numberone.daepiro.designsystem.theme.DaepiroTheme
import model.PrimaryButtonState
import shadow.BtnPressedShadow

@Composable
fun LineButton(filledButtonState: PrimaryButtonState, text:String, onClick: () -> Unit){
    when(filledButtonState){
        PrimaryButtonState.ICONDEFAULT -> LineButton_default(text = text, onClick = onClick, leftIcon = true)
        PrimaryButtonState.DEFAULT -> LineButton_default(text = text, onClick = onClick, leftIcon = false)
        PrimaryButtonState.ICONDISABLED -> LineButton_disabled(text = text, leftIcon = true)
        PrimaryButtonState.DISABLED ->LineButton_disabled(text = text, leftIcon = false)
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun LineButton_default(
    modifier: Modifier = Modifier,
    text: String,
    buttonRadius: Dp = 4.dp,
    onClick: () -> Unit,
    leftIcon: Boolean,
){
    val interactionSource = remember{ MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val backgroundColor = if(isPressed) DaepiroTheme.colors.O_50 else DaepiroTheme.colors.On_Primary
    var shadowColor = if(isPressed) Modifier.BtnPressedShadow(borderRadius = buttonRadius) else Modifier
    var shadowPadding = if(isPressed) {Modifier.padding(2.dp)} else Modifier

    Box(
        modifier = Modifier
            .then(
                shadowPadding
            )
    ){
        Box(
            modifier = modifier
                .then(shadowColor)
                .background(backgroundColor, shape = RoundedCornerShape(buttonRadius))
                .fillMaxWidth()
                .border(width = 1.dp, color =DaepiroTheme.colors.Primary)
                .clickable (
                    interactionSource = interactionSource,
                    indication = null,
                ){
                    onClick()
                }
                .padding(vertical = 13.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "$text",
                color = DaepiroTheme.colors.Primary,
                style = DaepiroTheme.typography.button,
                modifier = Modifier.align(Alignment.Center)
            )

            if (leftIcon) {
                Row(
                    modifier = Modifier.align(Alignment.CenterStart),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        modifier = Modifier.padding(start = 16.dp),
                        painter = painterResource(id = R.drawable.ic_alarm),
                        colorFilter = ColorFilter.tint(DaepiroTheme.colors.Primary),
                        contentDescription = null
                    )
                }
            }
        }
    }

}


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun LineButton_disabled(
    modifier: Modifier = Modifier,
    text: String,
    buttonRadius: Dp = 4.dp,
    leftIcon: Boolean,
) {

    Box(
        modifier = modifier
            .background(DaepiroTheme.colors.On_Primary, shape = RoundedCornerShape(buttonRadius))
            .fillMaxWidth()
            .border(width = 1.dp, color = DaepiroTheme.colors.O_200)
            .padding(vertical = 13.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "$text",
            color = DaepiroTheme.colors.O_200,
            style = DaepiroTheme.typography.button,
        )
        if (leftIcon) {
            Row(
                modifier = Modifier.align(Alignment.CenterStart),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    modifier = Modifier.padding(start = 16.dp),
                    painter = painterResource(id = R.drawable.ic_alarm),
                    colorFilter = ColorFilter.tint(DaepiroTheme.colors.O_200),
                    contentDescription = null
                )
            }
        }


    }
}


@Preview(showBackground = true)
@Composable
fun LineButtonDefault_icon_preview() {
    LineButton(PrimaryButtonState.ICONDEFAULT, text = "String", onClick = {})
}

@Preview(showBackground = true)
@Composable
fun LineButtonDefault_preview() {
    LineButton(PrimaryButtonState.DEFAULT, text = "String", onClick = {})
}


@Preview(showBackground = true)
@Composable
fun LineButtonDisabled_icon_preview() {
    LineButton(PrimaryButtonState.ICONDISABLED, text = "String", onClick = {})
}

@Preview(showBackground = true)
@Composable
fun LineButtonDisabled_preview() {
    LineButton(PrimaryButtonState.DISABLED, text = "String", onClick = {})
}
