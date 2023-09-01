package com.meongmoryteam.presentation.ui.main

import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Base64
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.meongmoryteam.presentation.ui.bottom.MeongMoryRoute
import com.meongmoryteam.presentation.ui.theme.MeongmoryTheme
import dagger.hilt.android.AndroidEntryPoint
import java.security.MessageDigest

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setMainScreen()
        getAppKeyHash()
    }

    private fun getAppKeyHash() {
        try {
            val info = packageManager.getPackageInfo(packageName, PackageManager.GET_SIGNATURES)
            for (i in info.signatures) {
                val md: MessageDigest = MessageDigest.getInstance("SHA")
                md.update(i.toByteArray())

                val something = String(Base64.encode(md.digest(), 0)!!)
                Log.e("Debug key", something)
            }
        } catch (e: Exception) {
            Log.e("Not found", e.toString())
        }
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
