package com.numberone.daepiro

import androidx.annotation.DrawableRes
import com.numberone.daepiro.feature.navigator.R
import com.numberone.daepiro.navigation.CommunityDestinations
import com.numberone.daepiro.navigation.FamilyDestinations
import com.numberone.daepiro.navigation.FundingDestinations
import com.numberone.daepiro.navigation.HomeDestinations
import com.numberone.daepiro.navigation.MypageDestinations

sealed class BottomNavigationItem(
    val route: String,
    @DrawableRes val icon: Int,
    val label: String
) {
    data object Home: BottomNavigationItem(
        route = HomeDestinations.HOME,
        icon = R.drawable.icon_home,
        label = "홈"
    )

    data object Community: BottomNavigationItem(
        route = CommunityDestinations.COMMUNITY,
        icon = R.drawable.icon_community,
        label = "커뮤니티"
    )

    data object Family: BottomNavigationItem(
        route = FamilyDestinations.FAMILY,
        icon = R.drawable.icon_family,
        label = "가족"
    )

    data object Funding: BottomNavigationItem(
        route = FundingDestinations.FUNDING,
        icon = R.drawable.icon_funding,
        label = "후원"
    )

    data object Mypage: BottomNavigationItem(
        route = MypageDestinations.MYPAGE,
        icon = R.drawable.icon_mypage,
        label = "마이페이지"
    )
}