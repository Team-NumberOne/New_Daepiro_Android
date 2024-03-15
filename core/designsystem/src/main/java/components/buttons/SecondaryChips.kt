package com.numberone.daepiro.designsystem.theme.components.buttons

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.numberone.daepiro.core.designsystem.R
import com.numberone.daepiro.designsystem.theme.DaepiroTheme
import model.PrimaryChipsState
import shadow.BtnPressedShadow

@Composable
fun SecondaryDefaultChips(filledChipState: PrimaryChipsState, text:String, onClick:()-> Unit, isCategory: Boolean){
    when(filledChipState){
        PrimaryChipsState.ICON_LEFT_DEFAULT -> SecondaryDefaultChip(text = text, onClick = onClick, rightIcon = false, leftIcon = true, isCategory = isCategory)
        PrimaryChipsState.ICON_RIGHT_DEFAULT ->SecondaryDefaultChip(text = text, onClick = onClick, rightIcon = true, leftIcon = false, isCategory = isCategory)
        PrimaryChipsState.DEFAULT ->SecondaryDefaultChip(text = text, onClick = onClick, rightIcon = false, leftIcon = false, isCategory = isCategory)
        PrimaryChipsState.ICON_LEFT_DISABLED -> SecondaryDisabledChip(text = text, rightIcon = false, leftIcon = true, isCategory = isCategory, backgroundColor = DaepiroTheme.colors.On_Secondary, textColor = DaepiroTheme.colors.G_200)
        PrimaryChipsState.ICON_RIGHT_DISABLED -> SecondaryDisabledChip(text = text, rightIcon = true, leftIcon = false, isCategory = isCategory, backgroundColor = DaepiroTheme.colors.On_Secondary, textColor = DaepiroTheme.colors.G_200)
        PrimaryChipsState.DISABLED -> SecondaryDisabledChip(text = text, rightIcon = false, leftIcon = false, isCategory = isCategory, backgroundColor = DaepiroTheme.colors.On_Secondary, textColor = DaepiroTheme.colors.G_200)
    }
}

@Composable
fun SecondaryFilledChips(filledChipState: PrimaryChipsState, text:String, onClick:()-> Unit, isCategory: Boolean){
    when(filledChipState){
        PrimaryChipsState.ICON_LEFT_DEFAULT -> SecondaryFilledChip(text = text, onClick = onClick, rightIcon = false, leftIcon = true, isCategory = isCategory)
        PrimaryChipsState.ICON_RIGHT_DEFAULT ->SecondaryFilledChip(text = text, onClick = onClick, rightIcon = true, leftIcon = false, isCategory = isCategory)
        PrimaryChipsState.DEFAULT ->SecondaryFilledChip(text = text, onClick = onClick, rightIcon = false, leftIcon = false, isCategory = isCategory)
        PrimaryChipsState.ICON_LEFT_DISABLED -> SecondaryDisabledChip(text = text, rightIcon = false, leftIcon = true, isCategory = isCategory, backgroundColor = DaepiroTheme.colors.G_200, textColor = DaepiroTheme.colors.On_Secondary)
        PrimaryChipsState.ICON_RIGHT_DISABLED -> SecondaryDisabledChip(text = text,  rightIcon = true, leftIcon = false, isCategory = isCategory, backgroundColor = DaepiroTheme.colors.G_200, textColor = DaepiroTheme.colors.On_Secondary)
        PrimaryChipsState.DISABLED -> SecondaryDisabledChip(text = text,  rightIcon = false, leftIcon = false, isCategory = isCategory, backgroundColor = DaepiroTheme.colors.G_200, textColor = DaepiroTheme.colors.On_Secondary)
    }
}

@Composable
fun SecondaryLightChips(filledChipState: PrimaryChipsState, text:String, onClick:()-> Unit, isCategory: Boolean){
    when(filledChipState){
        PrimaryChipsState.ICON_LEFT_DEFAULT -> SecondaryLightChip(text = text, onClick = onClick, rightIcon = false, leftIcon = true, isCategory = isCategory)
        PrimaryChipsState.ICON_RIGHT_DEFAULT ->SecondaryLightChip(text = text, onClick = onClick, rightIcon = true, leftIcon = false, isCategory = isCategory)
        PrimaryChipsState.DEFAULT ->SecondaryLightChip(text = text, onClick = onClick, rightIcon = false, leftIcon = false, isCategory = isCategory)
        PrimaryChipsState.ICON_LEFT_DISABLED -> SecondaryDisabledChip(text = text, rightIcon = false, leftIcon = true, isCategory = isCategory, backgroundColor = DaepiroTheme.colors.G_50, textColor = DaepiroTheme.colors.G_200)
        PrimaryChipsState.ICON_RIGHT_DISABLED -> SecondaryDisabledChip(text = text, rightIcon = true, leftIcon = false, isCategory = isCategory, backgroundColor = DaepiroTheme.colors.G_50, textColor = DaepiroTheme.colors.G_200)
        PrimaryChipsState.DISABLED -> SecondaryDisabledChip(text = text,  rightIcon = false, leftIcon = false, isCategory = isCategory, backgroundColor = DaepiroTheme.colors.G_50, textColor = DaepiroTheme.colors.G_200)
    }
}



@Composable
fun SecondaryDefaultChip(
    modifier: Modifier = Modifier,
    text: String,
    onClick: ()-> Unit,
    rightIcon : Boolean,
    leftIcon: Boolean,
    isCategory: Boolean
){
    val round = if (isCategory) RoundedCornerShape(4.dp) else RoundedCornerShape(14.dp)
    val interactionSource = remember{ MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val backgroundColor = if(isPressed) DaepiroTheme.colors.G_50 else DaepiroTheme.colors.On_Secondary
    var shadowColor = if(isPressed) Modifier.BtnPressedShadow(borderRadius = if(isCategory) 4.dp else 14.dp) else Modifier
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
                .background(color = backgroundColor, shape = round)
                .padding(horizontal = 12.dp, vertical = 8.dp)
                .clickable(
                    interactionSource = interactionSource,
                    indication = null,
                ) { onClick },
        ){
            Row(
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                if(leftIcon){
                    Image(
                        modifier = Modifier.padding(start =0.dp),
                        painter = painterResource(id = R.drawable.ic_delete),
                        colorFilter = ColorFilter.tint(DaepiroTheme.colors.G_900),
                        contentDescription = null
                    )
                }
                Text(
                    modifier = Modifier.padding(start =4.dp),
                    text = text,
                    style = DaepiroTheme.typography.caption,
                    color = DaepiroTheme.colors.Secondary,
                )
                if(rightIcon){
                    Image(
                        modifier = Modifier.padding(end =0.dp),
                        painter = painterResource(id = R.drawable.ic_delete),
                        colorFilter = ColorFilter.tint(DaepiroTheme.colors.G_900),
                        contentDescription = null
                    )
                }
            }

        }
    }
}
@Composable
fun SecondaryFilledChip(
    modifier: Modifier = Modifier,
    text: String,
    onClick: ()-> Unit,
    rightIcon : Boolean,
    leftIcon: Boolean,
    isCategory: Boolean
){
    val round = if (isCategory) RoundedCornerShape(4.dp) else RoundedCornerShape(14.dp)
    val interactionSource = remember{ MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val backgroundColor = if(isPressed) DaepiroTheme.colors.G_600 else DaepiroTheme.colors.Secondary
    var shadowColor = if(isPressed) Modifier.BtnPressedShadow(borderRadius = if(isCategory) 4.dp else 14.dp) else Modifier
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
                .background(color = backgroundColor, shape = round)
                .padding(horizontal = 12.dp, vertical = 8.dp)
                .clickable(
                    interactionSource = interactionSource,
                    indication = null,
                ) { onClick },
        ){
            Row(
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                if(leftIcon){
                    Image(
                        modifier = Modifier.padding(start =0.dp),
                        painter = painterResource(id = R.drawable.ic_delete),
                        colorFilter = ColorFilter.tint(DaepiroTheme.colors.G_900),
                        contentDescription = null
                    )
                }
                Text(
                    modifier = Modifier.padding(start =4.dp),
                    text = text,
                    style = DaepiroTheme.typography.caption,
                    color = DaepiroTheme.colors.On_Secondary,
                )
                if(rightIcon){
                    Image(
                        modifier = Modifier.padding(end =0.dp),
                        painter = painterResource(id = R.drawable.ic_delete),
                        colorFilter = ColorFilter.tint(DaepiroTheme.colors.G_900),
                        contentDescription = null
                    )
                }
            }

        }
    }
}

@Composable
fun SecondaryLightChip(
    modifier: Modifier = Modifier,
    text: String,
    onClick: ()-> Unit,
    rightIcon : Boolean,
    leftIcon: Boolean,
    isCategory: Boolean
){
    val round = if (isCategory) RoundedCornerShape(4.dp) else RoundedCornerShape(14.dp)
    val interactionSource = remember{ MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val backgroundColor = if(isPressed) DaepiroTheme.colors.G_75 else DaepiroTheme.colors.G_50
    var shadowColor = if(isPressed) Modifier.BtnPressedShadow(borderRadius = if(isCategory) 4.dp else 14.dp) else Modifier
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
                .background(color = backgroundColor, shape = round)
                .padding(horizontal = 12.dp, vertical = 8.dp)
                .clickable(
                    interactionSource = interactionSource,
                    indication = null,
                ) { onClick },
        ){
            Row(
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                if(leftIcon){
                    Image(
                        modifier = Modifier.padding(start =0.dp),
                        painter = painterResource(id = R.drawable.ic_delete),
                        colorFilter = ColorFilter.tint(DaepiroTheme.colors.G_900),
                        contentDescription = null
                    )
                }
                Text(
                    modifier = Modifier.padding(start =4.dp),
                    text = text,
                    style = DaepiroTheme.typography.caption,
                    color = DaepiroTheme.colors.Secondary,
                )
                if(rightIcon){
                    Image(
                        modifier = Modifier.padding(end =0.dp),
                        painter = painterResource(id = R.drawable.ic_delete),
                        colorFilter = ColorFilter.tint(DaepiroTheme.colors.G_900),
                        contentDescription = null
                    )
                }
            }

        }
    }
}


@Composable
fun SecondaryDisabledChip(
    modifier: Modifier = Modifier,
    text: String,
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
                    modifier = Modifier.padding(start =0.dp),
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
                    modifier = Modifier.padding(end =0.dp),
                    painter = painterResource(id = R.drawable.ic_delete),
                    colorFilter = ColorFilter.tint(DaepiroTheme.colors.G_900),
                    contentDescription = null
                )
            }
        }

    }
}