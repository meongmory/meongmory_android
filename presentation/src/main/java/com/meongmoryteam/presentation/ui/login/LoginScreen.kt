package com.meongmoryteam.presentation.ui.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.meongmoryteam.presentation.R
import com.meongmoryteam.presentation.ui.theme.DarkGrey
import com.meongmoryteam.presentation.ui.theme.Typography

@Composable
fun LoginScreen(

) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Icon(
            modifier = Modifier.padding(12.dp),
            painter = painterResource(R.drawable.ic_left_btn),
            contentDescription = stringResource(R.string.login_back_button),
        )
        Spacer(modifier = Modifier.padding(30.dp))
        Text(
            modifier = Modifier.padding(start = 16.dp),
            text = stringResource(R.string.login_phone_screen_title),
            fontSize = 20.sp,
            color = Color.Black,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.padding(6.dp))
        Text(
            modifier = Modifier.padding(start = 16.dp),
            text = stringResource(R.string.login_phone_screen_sub_title),
            color = DarkGrey,
            style = Typography.titleSmall
        )
        Spacer(modifier = Modifier.padding(32.dp))
        Text(
            modifier = Modifier.padding(start = 16.dp),
            text = stringResource(R.string.login_phone),
            color = DarkGrey,
            style = Typography.titleSmall
        )
        Spacer(modifier = Modifier.padding(10.dp))
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}