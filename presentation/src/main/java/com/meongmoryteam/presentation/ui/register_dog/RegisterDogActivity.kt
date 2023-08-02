package com.meongmoryteam.presentation.ui.register_dog

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
import com.meongmoryteam.presentation.ui.theme.MeongmoryTheme
import com.meongmoryteam.presentation.ui.theme.White
import dagger.hilt.android.AndroidEntryPoint

sealed class Route(val route: String) {
    object RegisterDog : Route("RegisterDog")
}

@AndroidEntryPoint
class RegisterDogActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MeongmoryTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = White) {
                    RegisterDogNavigation()
                }
            }
        }
    }
}

@Composable
fun RegisterDogNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Route.RegisterDog.route,
        modifier = modifier
    ) {
        composable(route = Route.RegisterDog.route) {
            RegisterDogScreen(navController)
        }
    }
}