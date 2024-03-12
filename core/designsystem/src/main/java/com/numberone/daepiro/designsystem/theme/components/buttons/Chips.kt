package com.numberone.daepiro.designsystem.theme.components.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.numberone.daepiro.designsystem.theme.themes.DaepiroTheme

@Composable
fun Chips(
    text:String,
    backgroundColor: Color,
    //style: TextStyle,
    textcolor: Color,
    borderColor: Color,
    isBorder : Boolean
){
    Box(
        modifier = Modifier
            .then(
                if (isBorder) Modifier.border(
                    BorderStroke(1.dp, borderColor),
                    shape = RoundedCornerShape(4.dp)
                )
                else Modifier
            )
            .background(backgroundColor, shape = RoundedCornerShape(4.dp))
            .padding(horizontal = 16.dp, vertical = 4.dp)
    ){
        Text(
            text = text,
            color = textcolor,
        )
    }
}


@Preview(showBackground = false)
@Composable
fun ChipsPreview(){
    DaepiroTheme {
        Chips("안녕", Color.Gray, Color.Black, Color.Yellow, false)
    }
}