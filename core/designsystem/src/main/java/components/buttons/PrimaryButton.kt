package com.numberone.daepiro.designsystem.theme.components.buttons

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.unit.dp
import com.numberone.daepiro.core.designsystem.R
import com.numberone.daepiro.designsystem.theme.DaepiroTheme
import com.numberone.daepiro.designsystem.theme.DaepiroTheme.typography
import com.numberone.daepiro.designsystem.theme.G_400
import com.numberone.daepiro.designsystem.theme.G_50
import com.numberone.daepiro.designsystem.theme.O_200
import com.numberone.daepiro.designsystem.theme.O_50
import com.numberone.daepiro.designsystem.theme.O_600
import com.numberone.daepiro.designsystem.theme.On_Primary
import com.numberone.daepiro.designsystem.theme.Primary
import model.PrimaryButtonState
import shadow.BtnPressedShadow
//linebutton 코너 확정
@Composable
fun FilledButton(filledButtonState: PrimaryButtonState, text:String, onClick: () -> Unit){
    when(filledButtonState){
        PrimaryButtonState.ICONDEFAULT -> PrimaryButton(text = text, onClick = onClick, leftIcon = true)
        PrimaryButtonState.DEFAULT -> PrimaryButton(text = text, onClick = onClick, leftIcon = false)
        PrimaryButtonState.ICONDISABLED -> PrimaryButton(text = text, onClick = onClick, leftIcon = true, isDisable = true)
        PrimaryButtonState.DISABLED ->PrimaryButton(text = text, onClick = onClick, leftIcon = false, isDisable = true)
    }
}

@Composable
fun LinedButton(linedButtonState: PrimaryButtonState, text:String, onClick: () -> Unit){
    when(linedButtonState){
        PrimaryButtonState.ICONDEFAULT -> PrimaryButton(text = text, onClick = onClick, leftIcon = true, isLine = true)
        PrimaryButtonState.DEFAULT -> PrimaryButton(text = text, onClick = onClick, leftIcon = false, isLine = true)
        PrimaryButtonState.ICONDISABLED -> PrimaryButton(text = text, onClick = onClick, leftIcon = true, isDisable = true, isLine = true)
        PrimaryButtonState.DISABLED ->PrimaryButton(text = text, onClick = onClick, leftIcon = false, isDisable = true, isLine = true)
    }
}

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    leftIcon: Boolean,
    isDisable: Boolean = false,
    isLine : Boolean = false
){
    val interactionSource = remember{ MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    Box(
        modifier = Modifier
            .padding(2.dp)
    ){
        Box(
            modifier = modifier
                .then(
                    if(isPressed) Modifier.BtnPressedShadow(borderRadius = 4.dp) else Modifier,
                )
                .background(
                    shape = RoundedCornerShape(4.dp),
                    color =
                    if(isLine == true){
                        if(isDisable == true){
                            On_Primary
                        }else{
                            if(isPressed){
                                O_50
                            }else{
                                On_Primary
                            }
                        }
                    }else{
                        if(isDisable == true){G_50}
                        else{if(isPressed) O_600 else Primary}
                    },
                    )
                .fillMaxWidth()
                .then(
                    if(isLine == true){
                        if(isDisable == true) Modifier.border(width = 1.dp, color = O_200, shape = RoundedCornerShape(4.dp)) else Modifier.border(width = 1.dp, color = Primary, shape = RoundedCornerShape(4.dp))
                    }else{
                        Modifier
                    }
                )
                .then(
                    if(isDisable == false){
                        Modifier.clickable (
                            interactionSource = interactionSource,
                            indication = null,
                        ){
                            onClick()
                        }
                    }else Modifier
                )
                .padding(vertical = 13.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "$text",
                //if(isDisable == false) DaepiroTheme.colors.On_Primary else DaepiroTheme.colors.G_400,
                color = if(isLine == true){
                    if(isDisable == true){
                        O_200
                    }else{
                        Primary
                    }
                }else{//line없을때
                    if(isDisable == true){G_400}
                    else On_Primary
                },
                style = typography.button,
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
                        colorFilter = ColorFilter.tint(
                            if(isLine == true){
                                if(isDisable == true) O_200 else Primary
                            }else{//line 없을때
                                if(isDisable == false) On_Primary else G_400
                            },

                    ),
                        contentDescription = null,
                    )
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun PrimaryButtonPreview(){
    Column(
        modifier = Modifier
    ){
        FilledButton(PrimaryButtonState.ICONDEFAULT, text = "TEXT", onClick = {})
        Spacer(modifier= Modifier.height(8.dp))
        FilledButton(PrimaryButtonState.DEFAULT, text = "TEXT", onClick = {})
        Spacer(modifier= Modifier.height(8.dp))
        FilledButton(PrimaryButtonState.ICONDISABLED, text = "TEXT", onClick = {})
        Spacer(modifier= Modifier.height(8.dp))
        FilledButton(PrimaryButtonState.DISABLED, text = "TEXT", onClick = {})
        Spacer(modifier= Modifier.height(8.dp))
        LinedButton(PrimaryButtonState.ICONDEFAULT, text = "TEXT", onClick = {})
        Spacer(modifier= Modifier.height(8.dp))
        LinedButton(PrimaryButtonState.DEFAULT, text = "TEXT", onClick = {})
        Spacer(modifier= Modifier.height(8.dp))
        LinedButton(PrimaryButtonState.ICONDISABLED, text = "TEXT", onClick = {})
        Spacer(modifier= Modifier.height(8.dp))
        LinedButton(PrimaryButtonState.DISABLED, text = "TEXT", onClick = {})
    }
}



