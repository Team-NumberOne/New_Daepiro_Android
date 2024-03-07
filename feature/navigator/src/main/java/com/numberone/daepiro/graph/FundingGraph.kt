package com.numberone.daepiro.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.numberone.daepiro.FundingDestinations
import com.numberone.daepiro.FundingScreen

fun NavGraphBuilder.fundingGraph(
    navController: NavController
) {
    navigation(
        route = FundingDestinations.ROUTE,
        startDestination = FundingDestinations.FUNDING
    ) {
        composable(route = FundingDestinations.FUNDING) {
            FundingScreen(navController)
        }

    }
}
