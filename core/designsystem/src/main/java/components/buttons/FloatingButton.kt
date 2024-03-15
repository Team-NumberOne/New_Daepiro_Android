package components.buttons

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.numberone.daepiro.core.designsystem.R
import com.numberone.daepiro.designsystem.theme.DaepiroTheme
import shadow.FloationShadow

enum class FloatingState{
    DEFAULF, PRESSED, DISABLED
}

@Composable
fun FloatingButton(state: FloatingState, text:String, onClick: () -> Unit){
    when(state){
        FloatingState.DEFAULF -> DefaultFloatingButton(text = text, onClick = {})
        FloatingState.PRESSED -> PressedFloatingButton(text =text, onClick = {} )
        FloatingState.DISABLED -> DisableFloatingButton(text = text)
    }
}

@Composable
fun DefaultFloatingButton(
    modifier: Modifier = Modifier,
    text : String,
    borderRadius : Dp = 20.dp,
    onClick : () -> Unit
    ){
    val interactionSource = remember{ MutableInteractionSource() }
    Box(
        modifier = Modifier.padding(borderRadius)
    ){
        Box(
            modifier = modifier
                .FloationShadow(borderRadius = borderRadius)
                .background(
                    color = DaepiroTheme.colors.On_Secondary,
                    shape = RoundedCornerShape(20.dp)
                )
                .clickable(
                    interactionSource = interactionSource,
                    indication = null
                ) {
                    onClick()
                },
        ){
            Text(
                text = text,
                color = DaepiroTheme.colors.G_800,
                style = DaepiroTheme.typography.button,
                modifier = Modifier
                    .padding( top = 9.dp, bottom = 9.dp, start = 24.dp)
            )
            Image(
                modifier = Modifier
                    .padding(start = 72.dp, top = 8.dp, bottom = 8.dp, end = 14.dp),
                painter = painterResource(id = R.drawable.ic_plus),
                colorFilter = ColorFilter.tint(DaepiroTheme.colors.G_900),
                contentDescription = null
            )
        }
    }
}

@Composable
fun PressedFloatingButton(
    modifier: Modifier = Modifier,
    text : String,
    borderRadius : Dp = 20.dp,
    onClick : () -> Unit
){
    val interactionSource = remember{ MutableInteractionSource() }
    Box(
        modifier = Modifier.padding(borderRadius)
    ){
        Box(
            modifier = modifier
                .FloationShadow(borderRadius = borderRadius)
                .background(color = DaepiroTheme.colors.G_50, shape = RoundedCornerShape(20.dp))
                .clickable(
                    interactionSource = interactionSource,
                    indication = null
                ) {
                    onClick()
                },
        ){
            Text(
                text = text,
                color = DaepiroTheme.colors.G_800,
                style = DaepiroTheme.typography.button,
                modifier = Modifier
                    .padding( top = 9.dp, bottom = 9.dp, start = 24.dp)
            )
            Image(
                modifier = Modifier
                    .padding(start = 72.dp, top = 8.dp, bottom = 8.dp, end = 14.dp),
                painter = painterResource(id = R.drawable.ic_plus),
                colorFilter = ColorFilter.tint(DaepiroTheme.colors.G_900),
                contentDescription = null
            )
        }
    }
}

@Composable
fun DisableFloatingButton(
    modifier: Modifier = Modifier,
    text : String,
    borderRadius : Dp = 20.dp,
){
    val interactionSource = remember{ MutableInteractionSource() }
    Box(
        modifier = Modifier.padding(borderRadius)
    ){
        Box(
            modifier = modifier
                .FloationShadow(borderRadius = borderRadius)
                .background(color = DaepiroTheme.colors.G_200, shape = RoundedCornerShape(20.dp))
        ){
            Text(
                text = text,
                color = DaepiroTheme.colors.G_800,
                style = DaepiroTheme.typography.button,
                modifier = Modifier
                    .padding( top = 9.dp, bottom = 9.dp, start = 24.dp)
            )
            Image(
                modifier = Modifier
                    .padding(start = 72.dp, top = 8.dp, bottom = 8.dp, end = 14.dp),
                painter = painterResource(id = R.drawable.ic_plus),
                colorFilter = ColorFilter.tint(DaepiroTheme.colors.G_900),
                contentDescription = null
            )
        }
    }
}


@Preview(showBackground = false)
@Composable
fun DefaultFloatingButtonPreview(){
    FloatingButton(state = FloatingState.DEFAULF , text = "TEXT" , onClick = {} )
}

@Preview(showBackground = false)
@Composable
fun PressedFloatingButtonPreview(){
    FloatingButton(state = FloatingState.PRESSED , text = "TEXT" ,onClick = {}  )
}

@Preview(showBackground = false)
@Composable
fun PressedDisableButtonPreview(){
    FloatingButton(state = FloatingState.DISABLED , text = "TEXT" ,onClick = {}  )
}

