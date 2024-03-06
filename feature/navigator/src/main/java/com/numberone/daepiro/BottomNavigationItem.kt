package com.numberone.daepiro

import androidx.annotation.DrawableRes
import com.numberone.daepiro.feature.navigator.R

sealed class BottomNavigationItem(
    val label: String,
    @DrawableRes val selectOnIcon: Int,
    @DrawableRes val selectOffIcon: Int,
    val route: String
) {
    object Home: BottomNavigationItem(
        label = "홈",
        selectOnIcon = R.drawable.icon_home_select_on,
        selectOffIcon = R.drawable.icon_home_select_off,
        route = HomeDestinations.HOME
    )

    object Community: BottomNavigationItem(
        label = "커뮤니티",
        selectOnIcon = R.drawable.icon_community_select_on,
        selectOffIcon = R.drawable.icon_community_select_off,
        route = CommunityDestinations.COMMUNITY
    )

    object Family: BottomNavigationItem(
        label = "가족",
        selectOnIcon = R.drawable.icon_family_select_on,
        selectOffIcon = R.drawable.icon_family_select_off,
        route = FamilyDestinations.FAMILY
    )

    object Funding: BottomNavigationItem(
        label = "후원",
        selectOnIcon = R.drawable.icon_funding_select_on,
        selectOffIcon = R.drawable.icon_funding_select_off,
        route = FundingDestinations.FUNDING
    )

    object Mypage: BottomNavigationItem(
        label = "마이페이지",
        selectOnIcon = R.drawable.icon_mypage_select_on,
        selectOffIcon = R.drawable.icon_mypage_select_off,
        route = MypageDestinations.MYPAGE
    )
}