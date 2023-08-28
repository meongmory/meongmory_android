package com.meongmoryteam.presentation.ui.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.meongmoryteam.presentation.R

@Composable
fun TermScreen(
    navigateToPreviousScreen: () -> Unit,
    navigateToNicknameScreen: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        TermTitle()
        TermContent()
    }
}

@Composable
fun TermTitle() {
    Icon(
        modifier = Modifier.padding(12.dp),
        painter = painterResource(R.drawable.ic_left_btn),
        contentDescription = stringResource(R.string.term_back_button),
    )
    Text(
        modifier = Modifier
            .fillMaxWidth(),
        textAlign = TextAlign.Center,
        text = stringResource(R.string.term_title),
    )
}

@Preview
@Composable
fun TermContent() {
    TermScreen(
        navigateToPreviousScreen = {},
        navigateToNicknameScreen = {}
    )
}