package com.meongmoryteam.presentation.ui.myPage.question

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class MyPageQuestionActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyPageQuestionScreen()
        }
    }
}