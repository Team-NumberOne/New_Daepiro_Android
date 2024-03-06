package com.numberone.daepiro

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DaepiroNavHost(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier,
    startDestination: String = HomeDestinations.HOME
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
            startDestination = startDestination
        ) {
//            composable(route = HomeDestinations.ROUTE) {
//
//            }
//            feedGraph(
//                navController = navController
//            )
//
//            favoriteGraph(
//                navController = navController
//            )
        }
    }
}
