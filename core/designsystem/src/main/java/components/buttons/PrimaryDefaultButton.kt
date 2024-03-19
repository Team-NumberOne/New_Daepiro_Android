package com.numberone.daepiro.designsystem.theme.components.buttons

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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

@Composable
fun DefaultButton(defaultButtonState: PrimaryButtonState, text:String, onClick: () -> Unit){
    when(defaultButtonState){
        PrimaryButtonState.ICONDEFAULT -> PrimaryButtonDefault(text = text, onClick = {}, rightIcon = true, isDisable = false)
        PrimaryButtonState.DEFAULT -> PrimaryButtonDefault(text = text,onClick = {},rightIcon = false, isDisable = false)
        PrimaryButtonState.ICONDISABLED -> PrimaryButtonDefault(text = text,onClick = {},rightIcon = true, isDisable = true)
        PrimaryButtonState.DISABLED -> PrimaryButtonDefault(text = text,onClick = {},rightIcon = false, isDisable = true)
    }
}
@Composable
fun PrimaryButtonDefault(
    modifier: Modifier = Modifier,
    text: String,
    onClick: ()-> Unit,
    rightIcon : Boolean,
    isDisable: Boolean = false
){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent)
            .clickable (
                interactionSource = remember{ MutableInteractionSource() },
                indication = null,
            ){
                onClick()
            }
            .padding(vertical = 13.dp),
        contentAlignment = Alignment.Center
    ){
        if(rightIcon == false){
            if(isDisable == true){
                Text("$text", style = DaepiroTheme.typography.button, color = DaepiroTheme.colors.G_300)
            } else{
                Text("$text", style = DaepiroTheme.typography.button,
                    color = if (remember { MutableInteractionSource() }.collectIsPressedAsState().value)
                        DaepiroTheme.colors.G_600 else DaepiroTheme.colors.G_700
                )
            }
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
                    color = if(isDisable == true) DaepiroTheme.colors.G_300 else DaepiroTheme.colors.G_700
                )
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


@Preview(showBackground = true)
@Composable
fun Default_defaultPreview(){
    DaepiroTheme {
        Column{
            DefaultButton(PrimaryButtonState.ICONDEFAULT, "대피로오", {})
            DefaultButton(PrimaryButtonState.DEFAULT, "대피로오", {})
            DefaultButton(PrimaryButtonState.ICONDISABLED, "대피로오", {})
            DefaultButton(PrimaryButtonState.DISABLED, "대피로오", {})
        }
    }
}