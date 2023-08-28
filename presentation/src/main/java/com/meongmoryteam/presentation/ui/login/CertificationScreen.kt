package com.meongmoryteam.presentation.ui.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.meongmoryteam.presentation.R
import com.meongmoryteam.presentation.base.TextButtonComponent
import com.meongmoryteam.presentation.base.TextFieldComponent
import com.meongmoryteam.presentation.ui.theme.ButtonContent
import com.meongmoryteam.presentation.ui.theme.DarkGrey
import com.meongmoryteam.presentation.ui.theme.LightGrey
import com.meongmoryteam.presentation.ui.theme.NotoSansKR
import com.meongmoryteam.presentation.ui.theme.Orange
import com.meongmoryteam.presentation.ui.theme.Typography

@Composable
fun CertificationScreen(
    loginViewModel: LoginViewModel = hiltViewModel(),
    navigateToTermScreen: () -> Unit,
) {
    val loginViewState by loginViewModel.viewState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        LoginPhoneCertTitle()
        LoginPhoneTextField()
        Spacer(modifier = Modifier.weight(1f))
        TextButtonComponent(
            text = stringResource(R.string.login_phone_login_next_button),
            colors = if (!loginViewState.isCertification) {
                ButtonDefaults.textButtonColors(LightGrey)
            } else {
                ButtonDefaults.textButtonColors(Orange)
            },
            style = TextStyle(
                fontFamily = NotoSansKR,
                fontWeight = FontWeight.W500,
                fontSize = 15.sp,
                lineHeight = 20.sp,
                color = ButtonContent,
                platformStyle = PlatformTextStyle(includeFontPadding = false)
            ),
            enabled = loginViewState.isCertification,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 16.dp),
        ) {
            loginViewModel.setEvent(LoginContract.LoginEvent.ToTermScreenButtonClicked)
        }
    }

    LaunchedEffect(key1 = loginViewModel.effect) {
        loginViewModel.effect.collect { effect ->
            when (effect) {
                is LoginContract.LoginEffect.MoveToTerm -> {
                    navigateToTermScreen()
                }
                is LoginContract.LoginEffect.FailCertification -> {
                    /*
                    인증 실패 스낵바 기획 논의
                     */
                }
                is LoginContract.LoginEffect.SuccessCertification -> {
                    /*
                    인증 성공 스낵바 기획 논의
                     */
                }
            }
        }
    }
}

@Composable
fun LoginPhoneCertTitle() {
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
}

@Composable
fun LoginPhoneTextField(
    loginViewModel: LoginViewModel = hiltViewModel(),
) {
    val loginViewState by loginViewModel.viewState.collectAsState()

    Text(
        modifier = Modifier.padding(start = 16.dp),
        text = stringResource(R.string.login_phone),
        color = DarkGrey,
        style = Typography.titleSmall
    )
    Spacer(modifier = Modifier.padding(10.dp))

    TextFieldComponent(
        name = loginViewState.phoneNumber,
        placeholder = stringResource(R.string.login_phone_text_field_hint),
        modifier = Modifier
            .fillMaxWidth()
            .height(37.dp)
            .padding(horizontal = 16.dp),
        onValueChange = { loginViewModel.setEvent(LoginContract.LoginEvent.OnPhoneChanged(it.trim())) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
    Spacer(modifier = Modifier.padding(6.dp))

    TextButtonComponent(
        text = stringResource(R.string.login_phone_get_certification_button),
        colors = if (loginViewState.phoneNumber.length != 11) {
            ButtonDefaults.textButtonColors(LightGrey)
        } else {
            ButtonDefaults.textButtonColors(Orange)
        },
        style = TextStyle(
            fontFamily = NotoSansKR,
            fontWeight = FontWeight.W500,
            fontSize = 15.sp,
            lineHeight = 20.sp,
            color = ButtonContent,
            platformStyle = PlatformTextStyle(includeFontPadding = false)
        ),
        enabled = loginViewState.phoneNumber.length == 11,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
    ) {
        loginViewModel.setEvent(LoginContract.LoginEvent.GetCertificationButtonClicked)
    }
    Spacer(modifier = Modifier.padding(20.dp))

    TextFieldComponent(
        name = loginViewState.certificationNumber,
        placeholder = stringResource(R.string.login_certification_text_field_hint),
        modifier = Modifier
            .fillMaxWidth()
            .height(37.dp)
            .padding(horizontal = 16.dp),
        onValueChange = { loginViewModel.setEvent(LoginContract.LoginEvent.OnCertificationNumberChanged(it)) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
    Spacer(modifier = Modifier.padding(6.dp))

    TextButtonComponent(
        text = stringResource(R.string.login_phone_post_certification_button),
        colors = if (loginViewState.certificationNumber.length != 5) {
            ButtonDefaults.textButtonColors(LightGrey)
        } else {
            ButtonDefaults.textButtonColors(Orange)
        },
        style = TextStyle(
            fontFamily = NotoSansKR,
            fontWeight = FontWeight.W500,
            fontSize = 15.sp,
            lineHeight = 20.sp,
            color = ButtonContent,
            platformStyle = PlatformTextStyle(includeFontPadding = false)
        ),
        enabled = loginViewState.certificationNumber.length == 5,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
    ) {
        loginViewModel.setEvent(LoginContract.LoginEvent.PostCertificationButtonClicked)
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    CertificationScreen() {

    }
}