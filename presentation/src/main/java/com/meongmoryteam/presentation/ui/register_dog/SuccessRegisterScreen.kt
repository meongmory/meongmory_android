package com.meongmoryteam.presentation.ui.register_dog

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.meongmoryteam.presentation.R
import com.meongmoryteam.presentation.base.TextButtonComponent
import com.meongmoryteam.presentation.base.TextComponent
import com.meongmoryteam.presentation.ui.theme.AppleSD
import com.meongmoryteam.presentation.ui.theme.Brown
import com.meongmoryteam.presentation.ui.theme.EditDivider
import com.meongmoryteam.presentation.ui.theme.Orange
import com.meongmoryteam.presentation.ui.theme.Typography

@Composable
fun SuccessRegisterScreen(
    navController: NavController,
    viewModel: RegisterDogViewModel = hiltViewModel(),
    navigateToMainScreen: () -> Unit
) {
    val viewState by viewModel.viewState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        RenderSuccessRegister()
        RenderConfirmButton()
    }
}

@Composable
fun RenderSuccessRegister() {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painterResource(id = R.drawable.success_registration),
            contentDescription = stringResource(R.string.breed),
            modifier = Modifier
                .width(300.dp)
                .height(200.dp)
                .padding(bottom = 30.dp)
        )
        TextComponent(
            text = stringResource(R.string.success_registration_title),
            style = Typography.titleLarge,
            color = Brown
        )
        TextComponent(
            text = stringResource(R.string.success_registration_content1),
            style = Typography.titleMedium,
            color = EditDivider,
            modifier = Modifier.padding(vertical = 5.dp)
        )
        Text(buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = Orange,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W400,
                    fontFamily = AppleSD,
                    letterSpacing = 0.6.sp
                )
            ) { append(stringResource(R.string.success_registration_content2)) }
            withStyle(
                style = SpanStyle(
                    color = EditDivider,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W400,
                    fontFamily = AppleSD,
                    letterSpacing = 0.6.sp
                )
            ) { append(stringResource(R.string.success_registration_content3)) }
        })
        TextComponent(
            text = stringResource(R.string.success_registration_content4),
            style = Typography.titleMedium,
            color = EditDivider,
            modifier = Modifier.padding(vertical = 5.dp)
        )
    }
}

@Composable
fun RenderConfirmButton() {
    TextButtonComponent(
        text = stringResource(R.string.check),
        colors = ButtonDefaults.textButtonColors(Orange),
        style = Typography.labelMedium,
        width = 0.6f,
        modifier = Modifier.padding(top = 20.dp)
    ) {

    }
}