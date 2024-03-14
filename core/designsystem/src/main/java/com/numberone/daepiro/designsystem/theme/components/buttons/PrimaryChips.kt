package com.numberone.daepiro.designsystem.theme.components.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.numberone.daepiro.core.designsystem.R
import com.numberone.daepiro.designsystem.theme.themes.DaepiroTheme
import model.PrimaryButtonState
import model.PrimaryChipsState

@Composable
fun PrimaryFilledChips(filledChipState: PrimaryChipsState, text:String, onClick:()-> Unit,isCategory: Boolean){
    when(filledChipState){
        PrimaryChipsState.ICON_LEFT_DEFAULT -> DefaultChip(text = text, onClick = onClick, rightIcon = false, leftIcon = true, isCategory = isCategory, backgroundColor = DaepiroTheme.colors.Primary, textColor = DaepiroTheme.colors.On_Primary)
        PrimaryChipsState.ICON_RIGHT_DEFAULT ->DefaultChip(text = text, onClick = onClick, rightIcon = true, leftIcon = false, isCategory = isCategory, backgroundColor = DaepiroTheme.colors.Primary, textColor = DaepiroTheme.colors.On_Primary)
        PrimaryChipsState.DEFAULT ->DefaultChip(text = text, onClick = onClick, rightIcon = false, leftIcon = false, isCategory = isCategory, backgroundColor = DaepiroTheme.colors.Primary, textColor = DaepiroTheme.colors.On_Primary)
        PrimaryChipsState.ICON_LEFT_PRESSED -> PressedChip(text = text, onClick = onClick, rightIcon = false, leftIcon = true, isCategory = isCategory, backgroundColor = DaepiroTheme.colors.O_600, textColor = DaepiroTheme.colors.On_Primary)
        PrimaryChipsState.ICON_RIGHT_PRESSED -> PressedChip(text = text, onClick = onClick, rightIcon = true, leftIcon = false, isCategory = isCategory, backgroundColor = DaepiroTheme.colors.O_600, textColor = DaepiroTheme.colors.On_Primary)
        PrimaryChipsState.PRESSED -> PressedChip(text = text, onClick = onClick, rightIcon = false, leftIcon = false, isCategory = isCategory, backgroundColor = DaepiroTheme.colors.O_600, textColor = DaepiroTheme.colors.On_Primary)
        PrimaryChipsState.ICON_LEFT_DISABLED -> DisabledChip(text = text, onClick = onClick, rightIcon = false, leftIcon = true, isCategory = isCategory, backgroundColor = DaepiroTheme.colors.O_200, textColor = DaepiroTheme.colors.On_Primary)
        PrimaryChipsState.ICON_RIGHT_DISABLED -> DisabledChip(text = text, onClick = onClick, rightIcon = true, leftIcon = false, isCategory = isCategory, backgroundColor = DaepiroTheme.colors.O_200, textColor = DaepiroTheme.colors.On_Primary)
        PrimaryChipsState.DISABLED -> DisabledChip(text = text, onClick = onClick, rightIcon = false, leftIcon = false, isCategory = isCategory, backgroundColor = DaepiroTheme.colors.O_200, textColor = DaepiroTheme.colors.On_Primary)
    }
}

@Composable
fun PrimaryLightChips(filledChipState: PrimaryChipsState, text:String, onClick:()-> Unit,isCategory: Boolean){
    when(filledChipState){
        PrimaryChipsState.ICON_LEFT_DEFAULT -> DefaultChip(text = text, onClick = onClick, rightIcon = false, leftIcon = true, isCategory = isCategory, backgroundColor = DaepiroTheme.colors.O_50, textColor = DaepiroTheme.colors.Primary)
        PrimaryChipsState.ICON_RIGHT_DEFAULT ->DefaultChip(text = text, onClick = onClick, rightIcon = true, leftIcon = false, isCategory = isCategory, backgroundColor = DaepiroTheme.colors.O_50, textColor = DaepiroTheme.colors.Primary)
        PrimaryChipsState.DEFAULT ->DefaultChip(text = text, onClick = onClick, rightIcon = false, leftIcon = false, isCategory = isCategory,backgroundColor = DaepiroTheme.colors.O_50, textColor = DaepiroTheme.colors.Primary)
        PrimaryChipsState.ICON_LEFT_PRESSED -> PressedChip(text = text, onClick = onClick, rightIcon = false, leftIcon = true, isCategory = isCategory, backgroundColor = DaepiroTheme.colors.O_100, textColor = DaepiroTheme.colors.Primary)
        PrimaryChipsState.ICON_RIGHT_PRESSED -> PressedChip(text = text, onClick = onClick, rightIcon = true, leftIcon = false, isCategory = isCategory, backgroundColor = DaepiroTheme.colors.O_100, textColor = DaepiroTheme.colors.Primary)
        PrimaryChipsState.PRESSED -> PressedChip(text = text, onClick = onClick, rightIcon = false, leftIcon = false, isCategory = isCategory, backgroundColor = DaepiroTheme.colors.O_100, textColor = DaepiroTheme.colors.Primary)
        PrimaryChipsState.ICON_LEFT_DISABLED -> DisabledChip(text = text, onClick = onClick, rightIcon = false, leftIcon = true, isCategory = isCategory, backgroundColor = DaepiroTheme.colors.On_Primary, textColor = DaepiroTheme.colors.O_200)
        PrimaryChipsState.ICON_RIGHT_DISABLED -> DisabledChip(text = text, onClick = onClick, rightIcon = true, leftIcon = false, isCategory = isCategory, backgroundColor = DaepiroTheme.colors.On_Primary, textColor = DaepiroTheme.colors.O_200)
        PrimaryChipsState.DISABLED -> DisabledChip(text = text, onClick = onClick, rightIcon = false, leftIcon = false, isCategory = isCategory, backgroundColor = DaepiroTheme.colors.On_Primary, textColor = DaepiroTheme.colors.O_200)
    }
}



@Composable
fun DefaultChip(
    modifier: Modifier = Modifier,
    text: String,
    onClick: ()-> Unit,
    rightIcon : Boolean,
    leftIcon: Boolean,
    isCategory: Boolean,
    backgroundColor: Color,
    textColor: Color
){
    val round = if (isCategory) RoundedCornerShape(4.dp) else RoundedCornerShape(14.dp)
    Box(
        modifier = modifier
            .background(color = backgroundColor, shape = round)
            .padding(horizontal = 12.dp, vertical = 8.dp)
    ){
        Row(
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            if(leftIcon){
                Image(
                    modifier = Modifier.padding(start =0.dp)
                        .clickable { onClick },
                    painter = painterResource(id = R.drawable.ic_delete),
                    contentDescription = null
                )
            }
            Text(
                modifier = Modifier.padding(start =4.dp),
                text = text,
                style = DaepiroTheme.typography.caption,
                color = textColor,
            )
            if(rightIcon){
                Image(
                    modifier = Modifier.padding(end =0.dp)
                        .clickable { onClick },
                    painter = painterResource(id = R.drawable.ic_delete),
                    contentDescription = null
                )
            }
        }

    }
}

//shadow 들어가야함
@Composable
fun PressedChip(
    modifier: Modifier = Modifier,
    text: String,
    onClick: ()-> Unit,
    rightIcon : Boolean,
    leftIcon: Boolean,
    isCategory: Boolean,
    backgroundColor:Color,
    textColor : Color
){
    val round = if (isCategory) RoundedCornerShape(4.dp) else RoundedCornerShape(14.dp)
    Box(
        modifier = modifier
            .background(color = backgroundColor, shape = round)
            .padding(horizontal = 12.dp, vertical = 8.dp)
    ){
        Row(
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            if(leftIcon){
                Image(
                    modifier = Modifier.padding(start =0.dp)
                        .clickable { onClick },
                    painter = painterResource(id = R.drawable.ic_delete),
                    contentDescription = null
                )
            }
            Text(
                modifier = Modifier.padding(start =4.dp),
                text = text,
                style = DaepiroTheme.typography.caption,
                color = textColor,
            )
            if(rightIcon){
                Image(
                    modifier = Modifier.padding(end =0.dp)
                        .clickable { onClick },
                    painter = painterResource(id = R.drawable.ic_delete),
                    contentDescription = null
                )
            }
        }

    }
}

@Composable
fun DisabledChip(
    modifier: Modifier = Modifier,
    text: String,
    onClick: ()-> Unit,
    rightIcon : Boolean,
    leftIcon: Boolean,
    isCategory: Boolean,
    backgroundColor: Color,
    textColor: Color
){
    val round = if (isCategory) RoundedCornerShape(4.dp) else RoundedCornerShape(14.dp)
    Box(
        modifier = modifier
            .background(color = backgroundColor, shape = round)
            .padding(horizontal = 12.dp, vertical = 8.dp)
    ){
        Row(
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            if(leftIcon){
                Image(
                    modifier = Modifier.padding(start =0.dp)
                        .clickable { onClick },
                    painter = painterResource(id = R.drawable.ic_delete),
                    contentDescription = null
                )
            }
            Text(
                modifier = Modifier.padding(start =4.dp),
                text = text,
                style = DaepiroTheme.typography.caption,
                color = textColor,
            )
            if(rightIcon){
                Image(
                    modifier = Modifier.padding(end =0.dp)
                        .clickable { onClick },
                    painter = painterResource(id = R.drawable.ic_delete),
                    contentDescription = null
                )
            }
        }

    }
}

@Preview(showBackground = false)
@Composable
fun PrimaryFilledChipsPreview(){
    DaepiroTheme {
        PrimaryLightChips(filledChipState = PrimaryChipsState.DEFAULT,text = "Text", onClick = {}, isCategory = false)
    }
}


@Preview(showBackground = false)
@Composable
fun PrimaryPressedChipsPreview(){
    DaepiroTheme {
        PrimaryLightChips(filledChipState = PrimaryChipsState.ICON_LEFT_PRESSED, text = "Text", onClick = {}, isCategory = true)
    }
}

@Preview(showBackground = false)
@Composable
fun PrimaryDisabledChipsPreview(){
    DaepiroTheme {
        PrimaryLightChips(filledChipState = PrimaryChipsState.DISABLED, text = "Text", onClick = {}, isCategory = false)
    }
}