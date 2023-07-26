package com.meongmoryteam.presentation.ui.register_family

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.meongmoryteam.presentation.ui.register_family.invitation.RegisterByCodeScreen
import com.meongmoryteam.presentation.ui.register_family.name.RegisterByNameScreen
import com.meongmoryteam.presentation.ui.theme.MeongmoryTheme
import com.meongmoryteam.presentation.ui.theme.White

class RegisterDogActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MeongmoryTheme {
                Surface(color = White, modifier = Modifier.fillMaxSize()) {
//                    RegisterDogScreen()
                    RegisterByNameScreen()
//                    RegisterByCodeScreen()
                }
            }
        }
    }
}