package components.switch

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.numberone.daepiro.designsystem.theme.DaepiroTheme
import components.buttons.DefaultFloatingButton
import components.buttons.DisableFloatingButton
import model.DisableState
//수정 가능성
enum class SwitchState{
    DEFAULT, PRESSED
}

@Composable
fun Switch(state: SwitchState, onClick: () -> Unit){
    when(state){
        SwitchState.DEFAULT -> Switch(selected = false, onClick = onClick)
        SwitchState.PRESSED -> Switch(selected = true, onClick = onClick)

    }
}

@Composable
fun ToggleCircle(
    modifier: Modifier = Modifier
){
    Card(
        shape = CircleShape, modifier = modifier.size(14.dp)
    ){
        Box(modifier = Modifier.background(Color.White) )
    }
}


@Composable
fun Switch(
    selected: Boolean,
    modifier : Modifier = Modifier,
    onClick : () -> Unit
){
    Card(
        modifier = modifier
            .width(38.dp)
            .clickable {
                !selected
                onClick()
            },
        shape = RoundedCornerShape(99.dp)
    ){
        Box(
            modifier = Modifier.background(
                if(selected) DaepiroTheme.colors.Primary else DaepiroTheme.colors.G_200
            )
                .fillMaxWidth(),
            contentAlignment = if (selected) Alignment.CenterEnd else Alignment.CenterStart
        ){
            ToggleCircle(modifier = Modifier.padding(4.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SwitchPreview(){
    Switch(selected = true, onClick = {})
}