package com.numberone.daepiro.designsystem.theme.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.numberone.daepiro.core.designsystem.R
import com.numberone.daepiro.designsystem.theme.themes.DaepiroTheme
import model.TopNavState
@Composable
fun TopAppBar(appBarState: TopNavState ){
    when(appBarState){
        TopNavState.LOGO_ICON -> LogoAppBar()
        TopNavState.PAGE_NAME -> pageNameAppBar()
        TopNavState.ICON_PAGE_NAME -> icon_pageNameappBar()
        TopNavState.ICON_PAGE_NAME_TEXT -> icon_pageNameTextAppBar()
        TopNavState.PAGE_NAME_TEXT -> PageName_textAppBar()
        TopNavState.DROP_DOWN_ICON -> Dropdown_Icon_AppBar()
    }
}
@Composable
fun LogoAppBar(modifier: Modifier = Modifier, onClick: () -> Unit = {}){
    Row(
        modifier= Modifier
            .fillMaxWidth()
            .background(DaepiroTheme.colors.White),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Image(
            painter = painterResource(R.drawable.ic_logo),
            colorFilter = ColorFilter.tint(DaepiroTheme.colors.G_300),
            contentDescription = null,
            modifier = Modifier.padding(start=16.dp, top = 18.dp, bottom = 18.dp)
        )
        Image(
            painter = painterResource(R.drawable.ic_alarm),
            colorFilter = ColorFilter.tint(DaepiroTheme.colors.G_300),
            contentDescription = null,
            modifier = Modifier
                .padding(end = 20.dp)
                .clickable { onClick },
        )
    }
}


@Composable
fun pageNameAppBar(
    modifier: Modifier = Modifier,
    pageName:String = ""
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(DaepiroTheme.colors.White)
            .padding(vertical = 16.dp)
    ){
        Text(
            modifier = Modifier.padding(start = 16.dp),
            text = "$pageName",
            style = DaepiroTheme.typography.H6,
            color = DaepiroTheme.colors.G_800
        )
    }
}

@Composable
fun icon_pageNameappBar(
    modifier: Modifier = Modifier,
    pageName:String = ""
){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(DaepiroTheme.colors.White)
            .padding(vertical = 16.dp),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = "$pageName",
            style = DaepiroTheme.typography.H6,
            color = DaepiroTheme.colors.G_800
        )
        Row(
            modifier = Modifier.align(Alignment.CenterStart),
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(
                modifier = Modifier.padding(start = 20.dp),
                painter = painterResource(id = R.drawable.ic_arrow_left),
                colorFilter = ColorFilter.tint(
                    DaepiroTheme.colors.G_900
                ),
                contentDescription = null
            )
        }
    }
}

@Composable
fun icon_pageNameTextAppBar(
    modifier: Modifier = Modifier,
    pageName:String = "",
    text:String = ""
){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(DaepiroTheme.colors.White)
            .padding(vertical = 16.dp),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = "$pageName",
            style = DaepiroTheme.typography.H6,
            color = DaepiroTheme.colors.G_800
        )
        Row(
            modifier = Modifier.align(Alignment.CenterStart),
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(
                modifier = Modifier.padding(start = 20.dp),
                painter = painterResource(id = R.drawable.ic_arrow_left),
                colorFilter = ColorFilter.tint(
                    DaepiroTheme.colors.G_900
                ),
                contentDescription = null
            )
        }
        Row(
            modifier = Modifier.align(Alignment.CenterEnd),
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                modifier = Modifier.padding(end = 18.dp),
                text = "$text",
                style = DaepiroTheme.typography.button,
                color = DaepiroTheme.colors.G_300
            )
        }
    }
}

@Composable
fun Icon_pageName_AppBar(
    modifier: Modifier = Modifier,
    pageName: String = "",
    text: String = ""
){
    Row(
        modifier= Modifier
            .fillMaxWidth()
            .background(DaepiroTheme.colors.White)
            .padding(vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Text(
            modifier = Modifier.padding(start = 16.dp),
            text = "$pageName",
            style = DaepiroTheme.typography.H6,
            color = DaepiroTheme.colors.G_800
        )
        Text(
            modifier = Modifier.padding(end = 18.dp),
            text = "$text",
            style = DaepiroTheme.typography.button,
            color = DaepiroTheme.colors.G_300
        )
    }
}

//논의후 추가하기
//@Composable
//fun Dropdown_iconAppBar(
//    modifier: Modifier = Modifier,
//    text: String = "",
//    textClick: () -> Unit = {},
//    onClick: () -> Unit = {}
//){
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .background(DaepiroTheme.colors.White)
//            .padding(vertical = 16.dp),
//        verticalAlignment = Alignment.CenterVertically,
//        horizontalArrangement = Arrangement.SpaceBetween
//    ){
//        Row(
//            modifier = Modifier
//                .background(DaepiroTheme.colors.White)
//                .padding(start = 16.dp, bottom = 16.dp, top = 16.dp)
//        ){
//            Text(
//                text = "$text",
//                style = DaepiroTheme.typography.H6,
//                color = DaepiroTheme.colors.G_800
//            )
//
//            Image(
//                modifier = Modifier.padding(start = 8.dp),
//                painter = painterResource(id = R.drawable.ic_arrow_down),
//                colorFilter = ColorFilter.tint(
//                    DaepiroTheme.colors.G_900
//                ),
//                contentDescription = null
//            )
//        }
//        Image(
//            modifier = Modifier.padding(end = 20.dp),
//            painter = painterResource(id = R.drawable.ic_alarm),
//            colorFilter = ColorFilter.tint(DaepiroTheme.colors.G_300),
//            contentDescription = null
//        )
//    }
//}

@Composable
fun PageName_textAppBar(
    modifier: Modifier = Modifier,
    pageName: String = "",
    text: String = ""
){
    Row(
        modifier= Modifier
            .fillMaxWidth()
            .background(DaepiroTheme.colors.White)
            .padding(vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Text(
            modifier = Modifier.padding(start = 16.dp),
            text = "$pageName",
            style = DaepiroTheme.typography.H6,
            color = DaepiroTheme.colors.G_800
        )
        Text(
            modifier = Modifier.padding(end = 18.dp),
            text = "$text",
            style = DaepiroTheme.typography.button,
            color = DaepiroTheme.colors.G_300
        )
    }
}

@Preview(showBackground = false)
@Composable
fun AppBarPreview(){
    TopAppBar(TopNavState.LOGO_ICON)
}

@Preview(showBackground = false)
@Composable
fun PageNameAppBarPreview(){
    pageNameAppBar(pageName= "커뮤니티")
}
@Preview(showBackground = false)
@Composable
fun IconPageNamePreview(){
    Icon_pageName_AppBar(pageName = "대피로", text = "안녕")
}
@Preview(showBackground = false)
@Composable
fun IconPageNameTextAppBar(){
    icon_pageNameTextAppBar(pageName = "대피로", text = "대피로")
}

@Preview(showBackground = false)
@Composable
fun Dropdown_Icon_AppBar(){
    //Dropdown_iconAppBar(text = "대피로")
}

@Preview(showBackground = false)
@Composable
fun IconPageNameAppBar(){
    icon_pageNameappBar(pageName = "대피로")
}
