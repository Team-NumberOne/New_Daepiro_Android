package com.numberone.daepiro

import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalAbsoluteTonalElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

@Composable
fun BottomNavigationBar(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val bottomNavigationItemList = listOf(
        BottomNavigationItem.Home,
        BottomNavigationItem.Community,
        BottomNavigationItem.Family,
        BottomNavigationItem.Funding,
        BottomNavigationItem.Mypage
    )

    NavigationBar(
        modifier = modifier
            .fillMaxWidth()
            .height(66.dp)
            .padding(horizontal = 12.dp),
        containerColor = Color.Transparent,
        tonalElevation = 0.dp
    ) {
        bottomNavigationItemList.forEach { navItem ->
            NavigationBarItem(
                interactionSource = NoRippleTheme,
                icon = {
                    Icon(
                        imageVector = if (navItem.route == currentDestination?.route) {
                            ImageVector.vectorResource(navItem.selectOnIcon)
                        } else ImageVector.vectorResource(navItem.selectOffIcon),
                        contentDescription = "BottomNavigationBar Icon",
                    )
                },
                label = { navItem.label },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = MaterialTheme.colorScheme.surfaceColorAtElevation(
                        LocalAbsoluteTonalElevation.current),
                ),
                selected = currentDestination?.hierarchy?.any { it.route == navItem.route } == true,
                onClick = {
                    navController.navigate(navItem.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
            )
        }
    }
}

object NoRippleTheme : MutableInteractionSource {
    override val interactions: Flow<Interaction> = emptyFlow()
    override suspend fun emit(interaction: Interaction) {}
    override fun tryEmit(interaction: Interaction) = true
}


@Preview(showBackground = true)
@Composable
fun BottomNavigationBarPreview() {
    BottomNavigationBar(
        navController = rememberNavController()
    )
}