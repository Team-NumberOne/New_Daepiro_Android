package com.numberone.daepiro.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.numberone.daepiro.HomeScreen

fun NavGraphBuilder.homeGraph(
    navController: NavController
) {
    navigation(
        route = HomeDestinations.ROUTE,
        startDestination = HomeDestinations.HOME
    ) {
        composable(route = HomeDestinations.HOME) {
            HomeScreen(navController)
        }

    }
}
