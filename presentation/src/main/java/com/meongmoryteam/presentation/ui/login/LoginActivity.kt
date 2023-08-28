package com.meongmoryteam.presentation.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.meongmoryteam.presentation.ui.theme.MeongmoryTheme
import dagger.hilt.android.AndroidEntryPoint

sealed class LoginNaviRoute(val route: String) {
    object CertificationScreen : LoginNaviRoute("CertificationScreen")
    object TermScreen : LoginNaviRoute("TermScreen")
}

@AndroidEntryPoint
class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setUnivSelectScreen()
    }

    private fun setUnivSelectScreen() {
        setContent {
            MeongmoryTheme {
                LoginNavigation()
            }
        }
    }

    companion object {
        fun startActivity(context: Context) {
            val intent = Intent(context, LoginActivity::class.java)
            context.startActivity(intent)
        }
    }
}

@Composable
fun LoginNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = LoginNaviRoute.CertificationScreen.route,
        modifier = modifier
    ) {
        composable(route = LoginNaviRoute.CertificationScreen.route) {
            CertificationScreen(
                navController = navController,
                navigateToTermScreen = { navController.navigate(LoginNaviRoute.TermScreen.route) }
            )
        }
        composable(route = LoginNaviRoute.TermScreen.route) {
            TermScreen(
                navigateToPreviousScreen = { },
                navigateToNicknameScreen = { }
            )
        }
    }
}