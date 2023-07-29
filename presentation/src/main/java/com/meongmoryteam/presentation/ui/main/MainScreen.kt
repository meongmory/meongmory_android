package com.meongmoryteam.presentation.ui.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.meongmoryteam.presentation.ui.bottom.BottomNavigation
import com.meongmoryteam.presentation.ui.bottom.MeongMoryBottomNavigation
import com.meongmoryteam.presentation.ui.bottom.navigateBottomNavigationScreen
import com.meongmoryteam.presentation.ui.home.HomeScreen
import com.meongmoryteam.presentation.ui.map.MapScreen

@Composable
fun MainScreen(
    navController: NavHostController = rememberNavController(),
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Scaffold(
        bottomBar = {
            MeongMoryBottomNavigation(
                currentDestination = currentDestination,
                navigateToScreen = { navigationItem ->
                    navigateBottomNavigationScreen(
                        navController = navController,
                        navigationItem = navigationItem,
                    )
                }
            )
        }
    ) { padding ->
        NavHost(
            modifier = Modifier.padding(padding),
            navController = navController,
            startDestination = BottomNavigation.HOME.route,
        ) {
            composable(route = BottomNavigation.HOME.route) {
                HomeScreen()
            }
            composable(route = BottomNavigation.MAP.route) {
                MapScreen()
            }
            composable(route = BottomNavigation.MY_PAGE.route) {

            }
        }
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}