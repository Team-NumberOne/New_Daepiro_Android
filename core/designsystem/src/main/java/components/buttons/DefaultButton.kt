package com.numberone.daepiro.designsystem.theme.components.buttons

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.numberone.daepiro.core.designsystem.R
import com.numberone.daepiro.designsystem.theme.DaepiroTheme
import model.PrimaryButtonState
import shadow.BtnPressedShadow

@Composable
fun DefaultButton(defaultButtonState: PrimaryButtonState, text:String, onClick: () -> Unit){
    when(defaultButtonState){
        PrimaryButtonState.ICONDEFAULT -> DefaultButton_default(text = text, onClick = {}, rightIcon = true)
        PrimaryButtonState.DEFAULT -> DefaultButton_default(text = text,onClick = {},rightIcon = false)
        PrimaryButtonState.ICONDISABLED -> DefaultButton_disabled(text = text,onClick = {},rightIcon = true)
        PrimaryButtonState.DISABLED -> DefaultButton_disabled(text = text,onClick = {},rightIcon = false)
    }
}
@Composable
fun DefaultButton_default(
    modifier: Modifier = Modifier,
    text: String,
    onClick: ()-> Unit,
    rightIcon : Boolean
){
    val interactionSource = remember{ MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    var textColor = if(isPressed) DaepiroTheme.colors.G_600 else DaepiroTheme.colors.G_700


    val interactionModifier =
        Modifier.clickable (
        interactionSource = interactionSource,
        indication = null,
    ){
        onClick()
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent)
            .clickable (
                interactionSource = interactionSource,
                indication = null,
            ){
                onClick()
            }
            .padding(vertical = 13.dp),
        contentAlignment = Alignment.Center
    ){
        if(rightIcon == false){
            Text("$text", style = DaepiroTheme.typography.button, color = textColor)
        }
        else{
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(
                    "$text",
                    modifier = Modifier.padding(start = 16.dp),
                    style = DaepiroTheme.typography.button,
                    color = DaepiroTheme.colors.G_700)
                Image(
                    modifier = Modifier.padding(end = 16.dp),
                    painter = painterResource(id = R.drawable.ic_arrow_right),
                    colorFilter = ColorFilter.tint(DaepiroTheme.colors.G_900),
                    contentDescription = null
                )
            }
        }
    }
}

@Composable
fun DefaultButton_disabled(
    modifier: Modifier = Modifier,
    text: String,
    onClick: ()-> Unit,
    rightIcon : Boolean
){
    val interactionSource = remember{ MutableInteractionSource() }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.Transparent)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
            ) {
                onClick()
            }
            .padding(vertical = 13.dp),
        contentAlignment = Alignment.Center
    ){
        if(rightIcon == false){
            Text("$text", style = DaepiroTheme.typography.button, color = DaepiroTheme.colors.G_300)
        }
        else{
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(
                    "$text",
                    modifier = Modifier.padding(start = 16.dp),
                    style = DaepiroTheme.typography.button,
                    color = DaepiroTheme.colors.G_300)
                Image(
                    modifier = Modifier.padding(end = 16.dp),
                    painter = painterResource(id = R.drawable.ic_arrow_right),
                    colorFilter = ColorFilter.tint(DaepiroTheme.colors.G_900),
                    contentDescription = null
                )
            }
        }
    }
}
@Preview(showBackground = false)
@Composable
fun Default_defaultPreview(){
    DaepiroTheme {
        DefaultButton(PrimaryButtonState.ICONDEFAULT, "대피로오", {})
    }
}

@Preview(showBackground = false)
@Composable
fun Default_disabledPreview(){
    DaepiroTheme {
        DefaultButton_disabled(text ="text", onClick = {}, rightIcon = true)
    }
}