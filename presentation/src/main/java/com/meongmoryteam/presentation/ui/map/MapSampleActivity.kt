package com.meongmoryteam.presentation.ui.map

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.meongmoryteam.presentation.ui.theme.MeongmoryTheme

class MapSampleActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MeongmoryTheme {
                NavGraph()
            }
        }
    }
}
