package com.meongmoryteam.presentation.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.meongmoryteam.presentation.ui.bottom.MeongMoryRoute
import com.meongmoryteam.presentation.ui.theme.MeongmoryTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setMainScreen()
    }

    private fun setMainScreen() {
        setContent {
            MeongmoryTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = MeongMoryRoute.HOME.route,
                ) {
                    composable(route = MeongMoryRoute.HOME.route) {
                        MainScreen()
                    }
                }
            }
        }
    }
}
