package com.meongmoryteam.presentation.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.meongmoryteam.presentation.ui.theme.MeongmoryTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setMainScreen()
    }

    private fun setMainScreen() {
        setContent {
            MeongmoryTheme {
                MainScreen(
                    intentToCreateHome = { }
                )
            }
        }
    }
}