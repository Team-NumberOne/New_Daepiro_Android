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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.numberone.daepiro.designsystem.theme.DaepiroTheme.typography
import com.numberone.daepiro.designsystem.theme.G_200
import com.numberone.daepiro.designsystem.theme.G_50
import com.numberone.daepiro.designsystem.theme.G_600
import com.numberone.daepiro.designsystem.theme.G_75
import com.numberone.daepiro.designsystem.theme.G_900
import com.numberone.daepiro.designsystem.theme.O_100
import com.numberone.daepiro.designsystem.theme.O_200
import com.numberone.daepiro.designsystem.theme.O_50
import com.numberone.daepiro.designsystem.theme.O_600
import com.numberone.daepiro.designsystem.theme.On_Primary
import com.numberone.daepiro.designsystem.theme.On_Secondary
import com.numberone.daepiro.designsystem.theme.Primary
import com.numberone.daepiro.designsystem.theme.Secondary
import model.ChipsState
import shadow.BtnPressedShadow

enum class ChipsButtonColor(
    val backgroundColor: Color,
    val disabledColor: Color,
    val pressedColor: Color,
    val textColor: Color,
    val disabledTextColor: Color,
    val pressedTextColor: Color
){
    PrimaryFilled(
        backgroundColor = Primary,
        disabledColor = O_200,
        pressedColor = O_600,
        textColor = On_Primary,
        disabledTextColor = On_Primary,
        pressedTextColor= On_Primary
    ),
    PrimaryLight(
        backgroundColor = O_50,
        disabledColor = On_Primary,
        pressedColor = O_100,
        textColor = Primary,
        disabledTextColor = O_200,
        pressedTextColor= Primary
    ),
    SecondaryDefault(
        backgroundColor = On_Secondary,
        disabledColor = On_Secondary,
        pressedColor = G_50,
        textColor = Secondary,
        disabledTextColor = G_200,
        pressedTextColor= Secondary
    ),
    SecondaryFilled(
        backgroundColor = Secondary,
        disabledColor = G_200,
        pressedColor = G_600,
        textColor = On_Secondary,
        disabledTextColor = On_Secondary,
        pressedTextColor= On_Secondary
    ),
    SecondaryLight(
        backgroundColor = G_50,
        disabledColor = G_50,
        pressedColor = G_75,
        textColor = Secondary,
        disabledTextColor = G_200,
        pressedTextColor= Secondary
    )
}
@Composable
fun PrimaryFilledChips(filledChipState: ChipsState, text:String, onClick:()-> Unit, isCategory: Boolean){
    when(filledChipState){
        ChipsState.ICON_LEFT_DEFAULT -> Chip(text = text, onClick = onClick, rightIcon = false, leftIcon = true, isCategory = isCategory, color = ChipsButtonColor.PrimaryFilled)
        ChipsState.ICON_RIGHT_DEFAULT ->Chip(text = text, onClick = onClick, rightIcon = true, leftIcon = false, isCategory = isCategory, color = ChipsButtonColor.PrimaryFilled)
        ChipsState.DEFAULT ->Chip(text = text, onClick = onClick, rightIcon = false, leftIcon = false, isCategory = isCategory, color = ChipsButtonColor.PrimaryFilled)
        ChipsState.ICON_LEFT_DISABLED -> Chip(text = text, onClick = onClick, rightIcon = false, leftIcon = true, isCategory = isCategory, color = ChipsButtonColor.PrimaryFilled, isDisabled = true)
        ChipsState.ICON_RIGHT_DISABLED -> Chip(text = text, onClick = onClick, rightIcon = true, leftIcon = false, isCategory = isCategory, color = ChipsButtonColor.PrimaryFilled, isDisabled = true)
        ChipsState.DISABLED -> Chip(text = text, onClick = onClick, rightIcon = false, leftIcon = false, isCategory = isCategory, color = ChipsButtonColor.PrimaryFilled, isDisabled = true)
    }
}

@Composable
fun PrimaryLightChips(filledChipState: ChipsState, text:String, onClick:()-> Unit, isCategory: Boolean){
    when(filledChipState){
        ChipsState.ICON_LEFT_DEFAULT -> Chip(text = text, onClick = onClick, rightIcon = false, leftIcon = true, isCategory = isCategory,color = ChipsButtonColor.PrimaryLight)
        ChipsState.ICON_RIGHT_DEFAULT ->Chip(text = text, onClick = onClick, rightIcon = true, leftIcon = false, isCategory = isCategory,color = ChipsButtonColor.PrimaryLight )
        ChipsState.DEFAULT ->Chip(text = text, onClick = onClick, rightIcon = false, leftIcon = false, isCategory = isCategory,color = ChipsButtonColor.PrimaryLight)
        ChipsState.ICON_LEFT_DISABLED -> Chip(text = text, onClick = onClick, rightIcon = false, leftIcon = true, isCategory = isCategory,color = ChipsButtonColor.PrimaryLight, isDisabled = true )
        ChipsState.ICON_RIGHT_DISABLED -> Chip(text = text, onClick = onClick, rightIcon = true, leftIcon = false, isCategory = isCategory,color = ChipsButtonColor.PrimaryLight, isDisabled = true  )
        ChipsState.DISABLED -> Chip(text = text, onClick = onClick, rightIcon = false, leftIcon = false, isCategory = isCategory, color = ChipsButtonColor.PrimaryLight, isDisabled = true )
    }
}

@Composable
fun SecondaryDefaultChip(filledChipState: ChipsState, text:String, onClick:()-> Unit, isCategory: Boolean) {
    when(filledChipState){
        ChipsState.ICON_LEFT_DEFAULT -> Chip(text = text, onClick = onClick, rightIcon = false, leftIcon = true, isCategory = isCategory,color = ChipsButtonColor.SecondaryDefault,isSecondary = true)
        ChipsState.ICON_RIGHT_DEFAULT ->Chip(text = text, onClick = onClick, rightIcon = true, leftIcon = false, isCategory = isCategory,color = ChipsButtonColor.SecondaryDefault,isSecondary = true)
        ChipsState.DEFAULT ->Chip(text = text, onClick = onClick, rightIcon = false, leftIcon = false, isCategory = isCategory,color = ChipsButtonColor.SecondaryDefault,isSecondary = true)
        ChipsState.ICON_LEFT_DISABLED -> Chip(text = text, onClick = onClick, rightIcon = false, leftIcon = true, isCategory = isCategory,color = ChipsButtonColor.SecondaryDefault, isDisabled = true ,isSecondary = true)
        ChipsState.ICON_RIGHT_DISABLED -> Chip(text = text, onClick = onClick, rightIcon = true, leftIcon = false, isCategory = isCategory,color = ChipsButtonColor.SecondaryDefault, isDisabled = true ,isSecondary = true )
        ChipsState.DISABLED -> Chip(text = text, onClick = onClick, rightIcon = false, leftIcon = false, isCategory = isCategory, color = ChipsButtonColor.SecondaryDefault, isDisabled = true ,isSecondary = true)
    }
}

@Composable
fun SecondaryFilledChip(filledChipState: ChipsState, text:String, onClick:()-> Unit, isCategory: Boolean) {
    when(filledChipState){
        ChipsState.ICON_LEFT_DEFAULT -> Chip(text = text, onClick = onClick, rightIcon = false, leftIcon = true, isCategory = isCategory,color = ChipsButtonColor.SecondaryFilled,isSecondary = true)
        ChipsState.ICON_RIGHT_DEFAULT ->Chip(text = text, onClick = onClick, rightIcon = true, leftIcon = false, isCategory = isCategory,color = ChipsButtonColor.SecondaryFilled ,isSecondary = true)
        ChipsState.DEFAULT ->Chip(text = text, onClick = onClick, rightIcon = false, leftIcon = false, isCategory = isCategory,color = ChipsButtonColor.SecondaryFilled,isSecondary = true)
        ChipsState.ICON_LEFT_DISABLED -> Chip(text = text, onClick = onClick, rightIcon = false, leftIcon = true, isCategory = isCategory,color = ChipsButtonColor.SecondaryFilled, isDisabled = true ,isSecondary = true)
        ChipsState.ICON_RIGHT_DISABLED -> Chip(text = text, onClick = onClick, rightIcon = true, leftIcon = false, isCategory = isCategory,color = ChipsButtonColor.SecondaryFilled, isDisabled = true ,isSecondary = true )
        ChipsState.DISABLED -> Chip(text = text, onClick = onClick, rightIcon = false, leftIcon = false, isCategory = isCategory, color = ChipsButtonColor.SecondaryFilled, isDisabled = true ,isSecondary = true)
    }
}

@Composable
fun SecondaryLightChip(filledChipState: ChipsState, text:String, onClick:()-> Unit, isCategory: Boolean) {
    when(filledChipState){
        ChipsState.ICON_LEFT_DEFAULT -> Chip(text = text, onClick = onClick, rightIcon = false, leftIcon = true, isCategory = isCategory,color = ChipsButtonColor.SecondaryLight,isSecondary = true)
        ChipsState.ICON_RIGHT_DEFAULT ->Chip(text = text, onClick = onClick, rightIcon = true, leftIcon = false, isCategory = isCategory,color = ChipsButtonColor.SecondaryLight ,isSecondary = true)
        ChipsState.DEFAULT ->Chip(text = text, onClick = onClick, rightIcon = false, leftIcon = false, isCategory = isCategory,color = ChipsButtonColor.SecondaryLight,isSecondary = true)
        ChipsState.ICON_LEFT_DISABLED -> Chip(text = text, onClick = onClick, rightIcon = false, leftIcon = true, isCategory = isCategory,color = ChipsButtonColor.SecondaryLight, isDisabled = true,isSecondary = true )
        ChipsState.ICON_RIGHT_DISABLED -> Chip(text = text, onClick = onClick, rightIcon = true, leftIcon = false, isCategory = isCategory,color = ChipsButtonColor.SecondaryLight, isDisabled = true ,isSecondary = true )
        ChipsState.DISABLED -> Chip(text = text, onClick = onClick, rightIcon = false, leftIcon = false, isCategory = isCategory, color = ChipsButtonColor.SecondaryLight, isDisabled = true,isSecondary = true )
    }
}




@Composable
fun Chip(
    modifier: Modifier = Modifier,
    text: String,
    onClick: ()-> Unit,
    rightIcon : Boolean,
    leftIcon: Boolean,
    isCategory: Boolean,
    color: ChipsButtonColor,
    isDisabled : Boolean = false,
    isSecondary:Boolean = false
){
    val interactionSource = remember{ MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()


    Box(
        modifier = modifier
            .then(
                if (isPressed && isDisabled == false) Modifier.BtnPressedShadow(borderRadius = if (isCategory) 4.dp else 14.dp) else Modifier
            )
            .background(
                color = if (isDisabled == true) {
                    color.disabledColor
                } else {
                    if (isPressed) color.pressedColor else color.backgroundColor
                },
                shape = if (isCategory) RoundedCornerShape(4.dp) else RoundedCornerShape(14.dp)
            )
            .padding(horizontal = 10.dp, vertical = 8.dp)
    ){
        Row(
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            if(leftIcon){
                Image(
                    modifier = Modifier
                        .clickable(
                            interactionSource = interactionSource,
                            indication = null
                        ) {
                            onClick
                        },
                    painter = painterResource(id = R.drawable.ic_delete),
                    contentDescription = null
                )
            }
            Text(
                modifier = Modifier
                    .padding(start =4.dp)
                    .align(Alignment.CenterVertically),
                text = text,
                style = typography.caption,
                color = if(isDisabled == true){
                    color.disabledTextColor
                }else{
                    if(isPressed) color.pressedTextColor else color.textColor
                },
            )
            if(rightIcon){
                if(isSecondary == true){
                    Image(
                        modifier = Modifier
                            .width(18.dp)
                            .height(18.dp)
                            .clickable(
                                interactionSource = interactionSource,
                                indication = null
                            ) { onClick },
                        painter = painterResource(id = R.drawable.ic_arrow_right),
                        colorFilter = ColorFilter.tint(G_900),
                        contentDescription = null
                    )
                }else{
                    Image(
                        modifier = Modifier
                            .clickable(
                                interactionSource = interactionSource,
                                indication = null
                            ) { onClick },
                        painter = painterResource(id = R.drawable.ic_delete),
                        contentDescription = null
                    )
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun ChipFilledPreview(){
    DaepiroTheme {
        Column(
        ){
            PrimaryFilledChips(ChipsState.ICON_LEFT_DEFAULT, "TEXT", onClick = {}, false)
            Spacer(modifier = Modifier.height(10.dp))
            PrimaryFilledChips(ChipsState.ICON_RIGHT_DEFAULT, "TEXT", onClick = {}, false)
            Spacer(modifier = Modifier.height(10.dp))
            PrimaryFilledChips(ChipsState.DEFAULT, "TEXT", onClick = {}, false)
            Spacer(modifier = Modifier.height(10.dp))
            PrimaryFilledChips(ChipsState.ICON_LEFT_DISABLED, "TEXT", onClick = {}, false)
            Spacer(modifier = Modifier.height(10.dp))
            PrimaryFilledChips(ChipsState.ICON_RIGHT_DISABLED, "TEXT", onClick = {}, false)
            Spacer(modifier = Modifier.height(10.dp))
            PrimaryFilledChips(ChipsState.DISABLED, "TEXT", onClick = {}, false)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChipLightPreview(){
    DaepiroTheme {
        Column(
        ){
            PrimaryLightChips(ChipsState.ICON_LEFT_DEFAULT, "TEXT", onClick = {}, false)
            Spacer(modifier = Modifier.height(10.dp))
            PrimaryLightChips(ChipsState.ICON_RIGHT_DEFAULT, "TEXT", onClick = {}, false)
            Spacer(modifier = Modifier.height(10.dp))
            PrimaryLightChips(ChipsState.DEFAULT, "TEXT", onClick = {}, false)
            Spacer(modifier = Modifier.height(10.dp))
            PrimaryLightChips(ChipsState.ICON_LEFT_DISABLED, "TEXT", onClick = {}, false)
            Spacer(modifier = Modifier.height(10.dp))
            PrimaryLightChips(ChipsState.ICON_RIGHT_DISABLED, "TEXT", onClick = {}, false)
            Spacer(modifier = Modifier.height(10.dp))
            PrimaryLightChips(ChipsState.DISABLED, "TEXT", onClick = {}, false)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SecondaryDefaultPreview(){
    DaepiroTheme {
        Column(
        ){
            SecondaryDefaultChip(ChipsState.ICON_LEFT_DEFAULT, "TEXT", onClick = {}, false)
            Spacer(modifier = Modifier.height(10.dp))
            SecondaryDefaultChip(ChipsState.ICON_RIGHT_DEFAULT, "TEXT", onClick = {}, false)
            Spacer(modifier = Modifier.height(10.dp))
            SecondaryDefaultChip(ChipsState.DEFAULT, "TEXT", onClick = {}, false)
            Spacer(modifier = Modifier.height(10.dp))
            SecondaryDefaultChip(ChipsState.ICON_LEFT_DISABLED, "TEXT", onClick = {}, false)
            Spacer(modifier = Modifier.height(10.dp))
            SecondaryDefaultChip(ChipsState.ICON_RIGHT_DISABLED, "TEXT", onClick = {}, false)
            Spacer(modifier = Modifier.height(10.dp))
            SecondaryDefaultChip(ChipsState.DISABLED, "TEXT", onClick = {}, false)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SecondaryFilledPreview(){
    DaepiroTheme {
        Column(
        ){
            SecondaryFilledChip(ChipsState.ICON_LEFT_DEFAULT, "TEXT", onClick = {}, false)
            Spacer(modifier = Modifier.height(10.dp))
            SecondaryFilledChip(ChipsState.ICON_RIGHT_DEFAULT, "TEXT", onClick = {}, false)
            Spacer(modifier = Modifier.height(10.dp))
            SecondaryFilledChip(ChipsState.DEFAULT, "TEXT", onClick = {}, false)
            Spacer(modifier = Modifier.height(10.dp))
            SecondaryFilledChip(ChipsState.ICON_LEFT_DISABLED, "TEXT", onClick = {}, false)
            Spacer(modifier = Modifier.height(10.dp))
            SecondaryFilledChip(ChipsState.ICON_RIGHT_DISABLED, "TEXT", onClick = {}, false)
            Spacer(modifier = Modifier.height(10.dp))
            SecondaryFilledChip(ChipsState.DISABLED, "TEXT", onClick = {}, false)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SecondaryLightPreview(){
    DaepiroTheme {
        Column(
        ){
            SecondaryLightChip(ChipsState.ICON_LEFT_DEFAULT, "TEXT", onClick = {}, false)
            Spacer(modifier = Modifier.height(10.dp))
            SecondaryLightChip(ChipsState.ICON_RIGHT_DEFAULT, "TEXT", onClick = {}, false)
            Spacer(modifier = Modifier.height(10.dp))
            SecondaryLightChip(ChipsState.DEFAULT, "TEXT", onClick = {}, false)
            Spacer(modifier = Modifier.height(10.dp))
            SecondaryLightChip(ChipsState.ICON_LEFT_DISABLED, "TEXT", onClick = {}, false)
            Spacer(modifier = Modifier.height(10.dp))
            SecondaryLightChip(ChipsState.ICON_RIGHT_DISABLED, "TEXT", onClick = {}, false)
            Spacer(modifier = Modifier.height(10.dp))
            SecondaryLightChip(ChipsState.DISABLED, "TEXT", onClick = {}, false)
        }
    }
}



