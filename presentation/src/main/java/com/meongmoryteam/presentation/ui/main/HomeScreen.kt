package com.meongmoryteam.presentation.ui.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.meongmoryteam.presentation.ui.bottom.MeongMoryBottomNavigation
import com.meongmoryteam.presentation.ui.bottom.MeongMoryRoute
import com.meongmoryteam.presentation.ui.bottom.navigateBottomNavigationScreen
import com.meongmoryteam.presentation.ui.home.HomeScreen
import com.meongmoryteam.presentation.ui.map.MapScreen
import com.meongmoryteam.presentation.ui.myPage.MyPageScreen
import com.meongmoryteam.presentation.ui.myPage.profile.MyPageProfileScreen
import com.meongmoryteam.presentation.ui.myPage.question.MyPageQuestionScreen

@Composable
fun MainScreen(
    navController: NavHostController = rememberNavController(),
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    var bottomBarState by rememberSaveable { mutableStateOf(true) }

    Scaffold(
        bottomBar = {
            if (bottomBarState) {
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
        }
    ) { padding ->
        NavHost(
            modifier = Modifier.padding(padding),
            navController = navController,
            startDestination = MeongMoryRoute.HOME.route,
        ) {
            composable(route = MeongMoryRoute.HOME.route) {
                HomeScreen()
            }
            composable(route = MeongMoryRoute.MAP.route) {
                MapScreen()
            }
            composable(route = MeongMoryRoute.MY_PAGE.route) {
                MyPageScreen(
                    navigateToEditNickNameScreen = { navController.navigate(MeongMoryRoute.EDIT_NICKNAME.route) },
                    navigateToQuestionScreen = { navController.navigate(MeongMoryRoute.QUESTION.route) },
                )
            }
            composable(route = MeongMoryRoute.EDIT_NICKNAME.route) {
                MyPageProfileScreen(
                    navigateToPrevious = { navController.navigate(MeongMoryRoute.MY_PAGE.route) }
                )
            }
            composable(route = MeongMoryRoute.QUESTION.route) {
                MyPageQuestionScreen(
                    navigateToPrevious = { navController.navigate(MeongMoryRoute.MY_PAGE.route)}
                )
            }
        }
    }

    // 바텀 네비게이션 보이기, 숨기기
    bottomBarState = when (currentDestination?.route) {
        MeongMoryRoute.HOME.route -> true
        MeongMoryRoute.MAP.route -> true
        MeongMoryRoute.MY_PAGE.route -> true
        else -> false
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}
