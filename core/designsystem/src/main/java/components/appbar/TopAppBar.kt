package components.appbar

import android.graphics.Paint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.numberone.daepiro.core.designsystem.R
import com.numberone.daepiro.designsystem.theme.DaepiroTheme.typography
import com.numberone.daepiro.designsystem.theme.G_300
import com.numberone.daepiro.designsystem.theme.G_800
import com.numberone.daepiro.designsystem.theme.G_900
import com.numberone.daepiro.designsystem.theme.White

enum class TopNavState {
    LOGO_ICON, PAGE_NAME, ICON_PAGE_NAME,ICON_PAGE_NAME_TEXT, DROP_DOWN_ICON, PAGE_NAME_TEXT
}
@Composable
fun TopAppBar(appBarState: TopNavState, leftText: String? = "", centerText: String? = "", rightText:String? = "" ){
    when(appBarState){
        TopNavState.LOGO_ICON -> {
            AppBar(
                leadingIcon = R.drawable.ic_logo,
                trailingIcon = R.drawable.ic_alarm,
                isDropdown = false,
                leftText = null,
                centerText = null,
                rightText = null,
                isLogo = true
            )
        }
        TopNavState.PAGE_NAME -> AppBar(leadingIcon = null, trailingIcon = null, isDropdown = false, leftText = leftText, centerText = null, rightText = null)
        TopNavState.ICON_PAGE_NAME -> AppBar(leadingIcon = R.drawable.ic_arrow_left, trailingIcon = null,  isDropdown = false, leftText = null, centerText = centerText, rightText = null)
        TopNavState.ICON_PAGE_NAME_TEXT -> AppBar(leadingIcon = R.drawable.ic_arrow_left, trailingIcon = null, isDropdown = false, leftText = null, centerText = centerText, rightText = rightText)
        TopNavState.DROP_DOWN_ICON -> AppBar(leadingIcon = null, trailingIcon = R.drawable.ic_alarm, isDropdown = true, leftText = leftText, centerText = null, rightText = null)
        TopNavState.PAGE_NAME_TEXT -> AppBar(leadingIcon = null, trailingIcon = null, isDropdown = false, leftText = leftText, centerText = null, rightText = rightText)
    }
}
@Composable
fun AppBar(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    leadingIcon : Int?,
    isLogo: Boolean = false,
    trailingIcon: Int?,
    isDropdown : Boolean,
    leftText: String?,
    centerText: String?,
    rightText : String?

){//맨앞은 (로고,icon)/ text/dropdown
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(White),
    ){
        Row(
           modifier = Modifier.align(Alignment.CenterStart)
        ){
            if(leadingIcon != null){//icon이 앞에 올경우
                Image(
                    painter = painterResource(leadingIcon),
                    colorFilter = ColorFilter.tint(if(isLogo) G_300 else  G_900),
                    contentDescription = null,
                    modifier = Modifier.padding(start=20.dp, top = 16.dp, bottom = 16.dp)
                )
            }else if(leftText != null && isDropdown == false){//lefttext가 있을경우
                Text(
                    modifier = Modifier.padding(start = 16.dp,top = 16.dp, bottom = 16.dp),
                    text = leftText,
                    style = typography.h6,
                    color = G_800
                )
            }
            else if(isDropdown == true) {//dropdown일 경우
                Row(
                    modifier = Modifier
                        .padding(start = 16.dp, top = 4.dp, bottom = 4.dp)
                        .clickable { },
                    //verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier.padding(top = 12.dp, bottom = 12.dp),
                        text = "${leftText}",
                        style = typography.h6,
                        color = G_800
                    )
                    Image(
                        painter = painterResource(R.drawable.ic_arrow_down),
                        colorFilter = ColorFilter.tint(G_900),
                        contentDescription = null,
                        modifier = Modifier.padding(start = 8.dp,top = 12.dp, bottom = 12.dp )
                    )

                }
            }
        }

        //가운데 영역
        if(centerText != null) {
           Row(
               modifier = Modifier.align(Alignment.Center)
           ){
               Text(
                   modifier = Modifier
                       .padding(top = 16.dp, bottom = 16.dp),
                   text = "${centerText}",
                   style = typography.h6,
                   color = G_800
               )
           }
        }

        if(trailingIcon != null || rightText != null){
            Row(
                modifier = Modifier.align(Alignment.CenterEnd)
            ){
                if(trailingIcon != null){
                    Image(
                        painter = painterResource(trailingIcon),
                        colorFilter = ColorFilter.tint(G_300),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(end = 20.dp)
                            .clickable { onClick },
                    )
                }
                if(rightText != null){
                    Text(
                        modifier = Modifier.padding(top = 17.dp, bottom = 17.dp, end = 16.dp),
                        text = "${rightText}",
                        style = typography.button,
                        color = G_300
                    )
                }else{
                    Spacer(Modifier.width(0.dp))
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun AppBarPreview(){
    Column{
        TopAppBar(TopNavState.LOGO_ICON)
        Spacer(modifier = Modifier.height(10.dp))
        TopAppBar(TopNavState.PAGE_NAME, leftText = "대피로")
        TopAppBar(TopNavState.ICON_PAGE_NAME, centerText = "페이지이름")
        TopAppBar(TopNavState.ICON_PAGE_NAME_TEXT, centerText = "페이지이름", rightText = "아무거나")
        TopAppBar(TopNavState.DROP_DOWN_ICON, leftText = "대피로")
        TopAppBar(TopNavState.PAGE_NAME_TEXT , leftText = "대피로", rightText = "대피로")
    }
}
