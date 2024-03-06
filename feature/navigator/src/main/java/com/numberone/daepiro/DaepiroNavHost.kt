package com.numberone.daepiro

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.numberone.daepiro.navigation.HomeDestinations
import com.numberone.daepiro.navigation.communityGraph
import com.numberone.daepiro.navigation.familyGraph
import com.numberone.daepiro.navigation.fundingGraph
import com.numberone.daepiro.navigation.homeGraph
import com.numberone.daepiro.navigation.mypageGraph

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DaepiroNavHost(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier,
) {
    Scaffold(
        bottomBar = {
            Divider(thickness = 2.dp, color = Color(0xFFE4E5EA))
            BottomNavigationBar(
                navController = navController
            )
        }
    ) { paddingValues ->
        NavHost(
            modifier = modifier.padding(paddingValues),
            navController = navController,
            startDestination = HomeDestinations.ROUTE
        ) {
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
