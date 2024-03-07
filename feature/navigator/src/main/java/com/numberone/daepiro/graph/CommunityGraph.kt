package com.numberone.daepiro.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.numberone.daepiro.CommunityScreen
import com.numberone.daepiro.CommunityDestinations

fun NavGraphBuilder.communityGraph(
    navController: NavController
) {
    navigation(
        route = CommunityDestinations.ROUTE,
        startDestination = CommunityDestinations.COMMUNITY
    ) {
        composable(route = CommunityDestinations.COMMUNITY) {
            CommunityScreen(navController)
        }

    }
}
