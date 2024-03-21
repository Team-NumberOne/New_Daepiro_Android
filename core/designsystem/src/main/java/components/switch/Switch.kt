package components.switch

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.numberone.daepiro.designsystem.theme.DaepiroTheme
import com.numberone.daepiro.designsystem.theme.G_100
import com.numberone.daepiro.designsystem.theme.G_200
import com.numberone.daepiro.designsystem.theme.O_600
import com.numberone.daepiro.designsystem.theme.Primary
import com.numberone.daepiro.designsystem.theme.White

@Composable
fun ToggleCircle(
    modifier: Modifier = Modifier
){
    Card(
        shape = CircleShape, modifier = modifier.size(14.dp)
    ){
        Box(modifier = Modifier.background(White) )
    }
}


@Composable
fun Switch(
    selected: MutableState<Boolean>,
    modifier : Modifier = Modifier,
    onClick : () -> Unit
){
    val interactionSource = remember{ MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    Card(
        modifier = modifier
            .width(38.dp)
            .clickable {
                onClick()
            },
        shape = RoundedCornerShape(99.dp)
    ){
        Box(
            modifier = Modifier.background(
                if(isPressed){
                    if(selected.value == false){
                        O_600
                    }else{
                        G_100
                    }
                }else{
                    if(selected.value == true) Primary else G_200
                }
            )
                .fillMaxWidth(),
            contentAlignment = if (selected.value == true) Alignment.CenterEnd else Alignment.CenterStart
        ){
            ToggleCircle(modifier = Modifier.padding(4.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SwitchPreview(){
    //Switch(selected = true, onClick = {})
}