package com.meongmoryteam.presentation.ui.register_family

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.activity
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.meongmoryteam.presentation.ui.register_family.invitation.RegisterByCodeScreen
import com.meongmoryteam.presentation.ui.register_family.name.RegisterByNameScreen
import com.meongmoryteam.presentation.ui.theme.MeongmoryTheme
import com.meongmoryteam.presentation.ui.theme.White

sealed class RouteScreen(val route: String){
    object Choose : RouteScreen("Choose")
    object Name : RouteScreen("Name")
    object Code : RouteScreen("Code")
}
class RegisterFamilyActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MeongmoryTheme {
                Surface(color = White, modifier = Modifier.fillMaxSize()) {
                    navigation()
//                    RegisterFamilyScreen()
//                    RegisterByNameScreen()
//                    RegisterByCodeScreen()
                }
            }
        }
    }
}

@Composable
fun navigation(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
){
    val context = LocalContext.current
    NavHost(navController = navController, startDestination = RouteScreen.Choose.route, modifier = modifier){
        composable(route = RouteScreen.Choose.route){
            RegisterFamilyScreen(navController)
        }
        composable(route = RouteScreen.Name.route){
            RegisterByNameScreen (navController)
        }
        composable(route = RouteScreen.Code.route){
            RegisterByCodeScreen (navController)
        }
    }
}