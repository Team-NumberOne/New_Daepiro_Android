package com.numberone.daepiro.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.numberone.daepiro.FamilyScreen

fun NavGraphBuilder.familyGraph(
    navController: NavController
) {
    navigation(
        route = FamilyDestinations.ROUTE,
        startDestination = FamilyDestinations.FAMILY
    ) {
        composable(route = FamilyDestinations.FAMILY) {
            FamilyScreen(navController)
        }

    }
}