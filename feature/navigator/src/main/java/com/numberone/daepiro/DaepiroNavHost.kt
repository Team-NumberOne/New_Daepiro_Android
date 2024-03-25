package com.numberone.daepiro

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.numberone.daepiro.graph.communityGraph
import com.numberone.daepiro.graph.familyGraph
import com.numberone.daepiro.graph.fundingGraph
import com.numberone.daepiro.graph.homeGraph
import com.numberone.daepiro.graph.loginGraph
import com.numberone.daepiro.graph.mypageGraph

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DaepiroNavHost(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier,
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val bottomNavigationItemList = listOf(
        HomeDestinations.HOME,
        CommunityDestinations.COMMUNITY,
        FundingDestinations.FUNDING,
        FamilyDestinations.FAMILY,
        MypageDestinations.MYPAGE
    )

    Scaffold(
        bottomBar = {
            if (currentDestination?.route in bottomNavigationItemList) {
                Divider(thickness = 2.dp, color = Color(0xFFE4E5EA))
                BottomNavigationBar(
                    navController = navController
                )
            }
        }
    ) { paddingValues ->
        NavHost(
            modifier = modifier.padding(paddingValues),
            navController = navController,
            startDestination = LoginDestinations.ROUTE
        ) {
            loginGraph(
                navController = navController
            )

            homeGraph(
                navController = navController
            )

            communityGraph(
                navController = navController
            )

            familyGraph(
                navController = navController
            )

            fundingGraph(
                navController = navController
            )

            mypageGraph(
                navController = navController
            )

        }
    }
}
