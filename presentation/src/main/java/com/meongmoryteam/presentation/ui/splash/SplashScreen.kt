package com.meongmoryteam.presentation.ui.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.meongmoryteam.presentation.R

@Composable
fun SplashScreen(
    onButtonClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(R.drawable.pet_diary_logo),
            contentDescription = stringResource(R.string.login_logo_description),
            modifier = Modifier.size(168.dp, 180.dp)
        )
        Spacer(modifier = Modifier.height(23.dp))
        Image(
            painter = painterResource(R.drawable.pet_diary_text_logo),
            contentDescription = stringResource(R.string.login_logo_description),
            modifier = Modifier.size(139.dp, 28.dp)
        )
    }
}

@Preview
@Composable
fun SplashScreenPreview() {
    SplashScreen(
        onButtonClick = {

        }
    )
}