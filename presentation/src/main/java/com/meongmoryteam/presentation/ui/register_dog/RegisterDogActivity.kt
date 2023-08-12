package com.meongmoryteam.presentation.ui.register_dog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.meongmoryteam.presentation.R
import com.meongmoryteam.presentation.ui.theme.MeongmoryTheme
import com.meongmoryteam.presentation.ui.theme.White
import dagger.hilt.android.AndroidEntryPoint

object NavArgs {
    const val BREED_ROUTE_PLUS = "/{breed}"
    const val BREED_ARG = "breed"
    const val BREED_EXCEPTION_ARG = "{breed}"
}

sealed class Route(val route: String) {
    object RegisterDog : Route("RegisterDog")
    object SuccessRegister : Route("SuccessRegister")
    object Main : Route("Main")
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
        startDestination = Route.RegisterDog.route.plus(NavArgs.BREED_ROUTE_PLUS),
        modifier = modifier
    ) {
        composable(
            route = Route.RegisterDog.route.plus(NavArgs.BREED_ROUTE_PLUS),
            arguments = listOf(navArgument(NavArgs.BREED_ARG) { type = NavType.StringType })
        ) {
            RegisterDogScreen(
                navController = navController,
                navigateToSearchBreedScreen = { navController.navigate(Route.SearchBreed.route) },
                navigateToMakeScreen = { navController.navigate(Route.SuccessRegister.route) },
                navigateToPreviousScreen = { navController.navigate(Route.Main.route) },
                searchBreed =
                if (it.arguments?.getString(NavArgs.BREED_ARG) == null || it.arguments?.getString(
                        NavArgs.BREED_ARG
                    ) == NavArgs.BREED_EXCEPTION_ARG
                ) stringResource(R.string.blank)
                else "${it.arguments?.getString(NavArgs.BREED_ARG)}"
            )
        }
        composable(route = Route.SuccessRegister.route) {
            //등록 성공 스크린
            SuccessRegisterScreen(
                navController = navController,
                navigateToMainScreen = { navController.navigate(Route.Main.route) }
            )
        }
        composable(route = Route.SearchBreed.route) {
            //품종 검색 스크린
            SearchBreedScreen(
                navController = navController,
                navigateToPreviousScreen = {
                    navController.navigate(
                        Route.RegisterDog.route.plus(
                            NavArgs.BREED_ROUTE_PLUS
                        )
                    )
                },
            )
        }
        composable(route = Route.Main.route) {
            //이전 스크린
        }
    }
}