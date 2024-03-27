package com.numberone.daepiro.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.numberone.daepiro.LoginDestinations
import com.numberone.daepiro.login.LoginScreen

fun NavGraphBuilder.loginGraph(
    navController: NavController
) {
    navigation(
        route = LoginDestinations.ROUTE,
        startDestination = LoginDestinations.LOGIN
    ) {
        composable(route = LoginDestinations.LOGIN) {
            LoginScreen(navController)
        }

    }
}
