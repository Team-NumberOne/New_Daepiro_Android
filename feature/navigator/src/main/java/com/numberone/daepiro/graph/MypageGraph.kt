package com.numberone.daepiro.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.numberone.daepiro.MypageScreen
import com.numberone.daepiro.MypageDestinations

fun NavGraphBuilder.mypageGraph(
    navController: NavController
) {
    navigation(
        route = MypageDestinations.ROUTE,
        startDestination = MypageDestinations.MYPAGE
    ) {
        composable(route = MypageDestinations.MYPAGE) {
            MypageScreen(navController)
        }

    }
}
