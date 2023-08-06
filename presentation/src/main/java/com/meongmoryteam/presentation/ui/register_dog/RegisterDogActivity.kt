package com.meongmoryteam.presentation.ui.register_dog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.meongmoryteam.presentation.ui.theme.MeongmoryTheme
import com.meongmoryteam.presentation.ui.theme.White
import dagger.hilt.android.AndroidEntryPoint

sealed class Route(val route: String) {
    object RegisterDog : Route("RegisterDog")
    object SuccessRegister : Route("SuccessRegister")
    object Previous : Route("Previous")
    object SearchBreed : Route("SearchBreed")
}

@AndroidEntryPoint
class RegisterDogActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            MeongmoryTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = White) {
                    RegisterDogNavigation()
                }
            }
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content)) { view, insets ->
            val bottom = insets.getInsets(WindowInsetsCompat.Type.ime()).bottom
            view.updatePadding(bottom = bottom)
            insets
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
            RegisterDogScreen(
                navController = navController,
                navigateToSearchBreedScreen = { navController.navigate(Route.SearchBreed.route) },
                navigateToMakeScreen = { navController.navigate(Route.SuccessRegister.route) },
                navigateToPreviousScreen = { navController.navigate(Route.Previous.route) }
            )
        }
        composable(route = Route.SuccessRegister.route) {
            //등록 성공 스크린
        }
        composable(route = Route.SearchBreed.route) {
            //품종 검색 스크린
        }
        composable(route = Route.Previous.route) {
            //이전 스크린
        }
    }
}