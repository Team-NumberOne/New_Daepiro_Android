package components.buttons

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.numberone.daepiro.core.designsystem.R
import com.numberone.daepiro.designsystem.theme.DaepiroTheme
import com.numberone.daepiro.designsystem.theme.G_200
import com.numberone.daepiro.designsystem.theme.G_50
import com.numberone.daepiro.designsystem.theme.G_800
import com.numberone.daepiro.designsystem.theme.G_900
import com.numberone.daepiro.designsystem.theme.On_Secondary
import model.FloatingState
import shadow.FloationShadow


@Composable
fun FloatingButtonState(state: FloatingState, text:String, onClick: () -> Unit){
    when(state){
        FloatingState.DEFAULF -> FloatingButton(text = text, onClick = onClick)
        FloatingState.DISABLED -> FloatingButton(text = text , onClick = {  }, isDisable = true)
    }
}


@Composable
fun FloatingButton(
    modifier: Modifier = Modifier,
    text : String,
    onClick : () -> Unit,
    isDisable : Boolean = false
    ){
    val interactionSource = remember{ MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    Box(
        modifier = Modifier.padding(20.dp)
    ){
        Box(
            modifier = modifier
                .FloationShadow(borderRadius = 20.dp)
                .background(
                    color = if (isPressed) G_50 else On_Secondary,
                    shape = RoundedCornerShape(20.dp)
                )
                .then(
                    if (isDisable == true) {
                        Modifier
                    } else {
                        Modifier.clickable(
                            interactionSource = interactionSource,
                            indication = null
                        ) {
                            onClick()
                        }
                    }
                )

        ){
            Text(
                text = text,
                color = if(isDisable == true) G_200 else G_800,
                style = DaepiroTheme.typography.button,
                modifier = Modifier
                    .padding( top = 9.dp, bottom = 9.dp, start = 24.dp)
            )
            Image(
                modifier = Modifier
                    .padding(start = 72.dp, top = 8.dp, bottom = 8.dp, end = 14.dp),
                painter = painterResource(id = R.drawable.ic_plus),
                colorFilter = ColorFilter.tint(G_900),
                contentDescription = null
            )
        }
    }
}


@Preview(showBackground = false)
@Composable
fun FloatingButtonPreview(){
    Column(
        modifier = Modifier
    ){
        FloatingButtonState(state = FloatingState.DEFAULF, text = "TEXT", onClick = {})
        FloatingButtonState(state = FloatingState.DISABLED, text = "TEXT", onClick = {})
    }
}