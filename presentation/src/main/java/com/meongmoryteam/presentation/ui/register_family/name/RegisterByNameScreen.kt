package com.meongmoryteam.presentation.ui.register_family.name

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.meongmoryteam.presentation.R
import com.meongmoryteam.presentation.ui.register_family.RegisterDogForm
import com.meongmoryteam.presentation.ui.register_family.RegisterFamilyContract.RegisterFamilyEvent
import com.meongmoryteam.presentation.ui.register_family.RegisterFamilyContract.RegisterFamilySideEffect
import com.meongmoryteam.presentation.ui.register_family.RegisterFamilyViewModel
import com.meongmoryteam.presentation.ui.register_family.TextButtonComponent
import com.meongmoryteam.presentation.ui.register_family.TextComponent
import com.meongmoryteam.presentation.ui.register_family.TextFieldComponent
import com.meongmoryteam.presentation.ui.theme.ButtonContent
import com.meongmoryteam.presentation.ui.theme.DarkGrey
import com.meongmoryteam.presentation.ui.theme.InputBoxOutline
import com.meongmoryteam.presentation.ui.theme.LightGrey
import com.meongmoryteam.presentation.ui.theme.LightYellow
import com.meongmoryteam.presentation.ui.theme.NotoSansKR
import com.meongmoryteam.presentation.ui.theme.Orange
import com.meongmoryteam.presentation.ui.theme.Placeholer
import com.meongmoryteam.presentation.ui.theme.Typography
import com.meongmoryteam.presentation.ui.theme.Yellow

@Composable
fun RegisterByNameScreen(
    navController: NavController,
    viewModel: RegisterFamilyViewModel = hiltViewModel(),
    navigateToMakeScreen: () -> Unit,
    navigateToFamilyScreen: () -> Unit
) {
    val viewState by viewModel.viewState.collectAsState()

    RegisterDogForm(
        navController = navController,
        navigateTo = { viewModel.setEvent(RegisterFamilyEvent.OnClickBackButton) }) {
        Column(modifier = Modifier.fillMaxWidth()) {
            TextComponent(
                text = stringResource(R.string.register_by_name_title),
                style = Typography.titleLarge,
                modifier = Modifier.padding(bottom = 10.dp),
                color = Orange
            )
            TextComponent(
                text = stringResource(R.string.register_by_name_info),
                style = Typography.bodyMedium,
                color = DarkGrey
            )
        }
        Column {
            Text(
                text = stringResource(R.string.input_family_name_label),
                color = Placeholer,
                style = Typography.bodySmall
            )
            TextFieldComponent(
                name = viewState.familyName,
                onValueChange = { viewModel.setEvent(RegisterFamilyEvent.FillInFamilyName(it)) },
                placeholder = stringResource(R.string.input_family_name),
                bgColor = if (!viewState.isFilledName) {
                    Color(0xFFF9F9F9)
                } else {
                    LightYellow
                },
                borderColor = if (!viewState.isFilledName) {
                    InputBoxOutline
                } else {
                    Yellow
                }
            )
            InputException(text = stringResource(R.string.input_family_name_exception))
        }
        Spacer(modifier = Modifier.fillMaxHeight(0.3f))
        Column(modifier = Modifier.padding(bottom = 30.dp)) {
            TextButtonComponent(
                text = stringResource(R.string.make),
                colors = if (!viewState.isFilledName) {
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
                    platformStyle = PlatformTextStyle(includeFontPadding = false) //폰트 패딩을 제거하지 않으면 정렬이 맞지 않음
                )
            ) { viewModel.setEvent(RegisterFamilyEvent.OnClickMakeButton) }
        }
    }

    LaunchedEffect(key1 = viewModel.effect) {
        viewModel.effect.collect { effect ->
            when (effect) {
                RegisterFamilySideEffect.NavigateToRegisterCodeScreen -> {}
                RegisterFamilySideEffect.NavigateToRegisterNameScreen -> {}
                RegisterFamilySideEffect.NavigateToPreviousScreen -> {
                    navigateToFamilyScreen()
                }

                RegisterFamilySideEffect.NavigateToNextScreen -> {
                    navigateToMakeScreen()
                }
            }
        }
    }
}

@Composable
fun InputException(text: String) {
    Text(
        modifier = Modifier.padding(vertical = 8.dp),
        text = text,
        color = Placeholer,
        style = Typography.titleSmall
    )
}