package com.meongmoryteam.presentation.ui.register_family

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.meongmoryteam.presentation.ui.register_family.invitation.RegisterByCodeScreen
import com.meongmoryteam.presentation.ui.register_family.name.RegisterByNameScreen
import com.meongmoryteam.presentation.ui.theme.MeongmoryTheme
import com.meongmoryteam.presentation.ui.theme.White
import dagger.hilt.android.AndroidEntryPoint

sealed class RouteScreen(val route: String) {
    object Choose : RouteScreen("Choose")
    object Name : RouteScreen("Name")
    object Code : RouteScreen("Code")
}
@AndroidEntryPoint
class RegisterFamilyActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MeongmoryTheme {
                Surface(color = White, modifier = Modifier.fillMaxSize()) {
                    RegisterFamilyNavigation()
                }
            }
        }
    }
}

@Composable
fun RegisterFamilyNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = RouteScreen.Choose.route,
        modifier = modifier
    ) {
        composable(route = RouteScreen.Choose.route) {
            RegisterFamilyScreen(navController)
        }
        composable(route = RouteScreen.Name.route) {
            RegisterByNameScreen(
                navController = navController,
                navigateToRegisterScreen = {navController.navigate(RouteScreen.Choose.route)},
                navigateToMainScreen = {navController.navigate(RouteScreen.Choose.route)} //추후 메인으로 변경
            )
        }
        composable(route = RouteScreen.Code.route) {
            RegisterByCodeScreen(
                navController = navController,
                navigateToRegisterScreen = {navController.navigate(RouteScreen.Choose.route)},
                navigateToMainScreen = {navController.navigate(RouteScreen.Choose.route)} //추후 메인으로 변경
            )
        }
    }
}