package com.meongmoryteam.presentation.ui.main

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.meongmoryteam.presentation.ui.bottom.MeongMoryRoute
import com.meongmoryteam.presentation.ui.myPage.profile.MyPageProfileScreen
import com.meongmoryteam.presentation.ui.myPage.question.MyPageQuestionScreen
import com.meongmoryteam.presentation.ui.theme.MeongmoryTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()
    private var createResultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { _ ->
        viewModel.setEvent(MainContract.MainEvent.FinishedCreateActivity)
    }

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
                        MainScreen(intentToCreateHome = { })
                    }
                    composable(route = MeongMoryRoute.EDIT_NICKNAME.route) {
                        MyPageProfileScreen()
                    }
                    composable(route = MeongMoryRoute.QUESTION.route) {
                        MyPageQuestionScreen()
                    }
                }
            }
        }
    }

    companion object {
        fun startActivity(context: Context, uri: Uri?) {
            val intent = Intent(context, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP + Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(intent)
        }
    }
}
