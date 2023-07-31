package com.meongmoryteam.presentation.ui.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.meongmoryteam.presentation.R

@Composable
fun SplashScreen(
    viewModel: SplashViewModel = hiltViewModel(),
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
        Spacer(modifier = Modifier.padding(23.dp))
        Image(
            painter = painterResource(R.drawable.pet_diary_text_logo),
            contentDescription = stringResource(R.string.login_logo_description),
            modifier = Modifier.size(139.dp, 28.dp)
        )
        Spacer(modifier = Modifier.padding(40.dp))
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 54.dp),
            shape = RoundedCornerShape(100.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
                contentColor = Color.White
            ),
            onClick = { viewModel.setEvent(SplashContract.SplashEvent.ToLoginButtonClicked) }
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.solar_phone_bold),
                    contentDescription = stringResource(R.string.login_phone_description),
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.padding(8.dp))
                Text(
                    text = stringResource(R.string.login_phone_title_text),
                    fontSize = 17.sp,
                    color = Color.White,
                )
            }
        }
    }

    LaunchedEffect(key1 = viewModel.effect) {
        viewModel.effect.collect { effect ->
            when(effect) {
                SplashContract.SplashEffect.MoveToLogin -> {
                    onButtonClick()
                }
            }
        }
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