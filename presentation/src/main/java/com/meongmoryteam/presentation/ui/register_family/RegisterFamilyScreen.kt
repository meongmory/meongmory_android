package com.meongmoryteam.presentation.ui.register_family

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.meongmoryteam.presentation.R
import com.meongmoryteam.presentation.base.TextButtonComponent
import com.meongmoryteam.presentation.base.TextComponent
import com.meongmoryteam.presentation.ui.register_family.RegisterFamilyContract.RegisterFamilyEvent
import com.meongmoryteam.presentation.ui.register_family.RegisterFamilyContract.RegisterFamilySideEffect
import com.meongmoryteam.presentation.ui.theme.Brown
import com.meongmoryteam.presentation.ui.theme.ButtonContent
import com.meongmoryteam.presentation.ui.theme.DarkGrey
import com.meongmoryteam.presentation.ui.theme.Orange
import com.meongmoryteam.presentation.ui.theme.Typography

@Composable
fun RegisterFamilyScreen(
    navController: NavController,
    viewModel: RegisterFamilyViewModel = hiltViewModel(),
    navigateToRegisterByCode: () -> Unit,
    navigateToRegisterByName: () -> Unit,
    navigateToPreviousScreen: () -> Unit
) {
    RegisterDogForm(navController = navController) {
        Column {
            Row {
                TextComponent(
                    text = stringResource(R.string.register_family_welcome),
                    style = Typography.titleLarge,
                    modifier = Modifier.padding(bottom = 15.dp),
                    color = Orange
                )
                TextComponent(
                    text = stringResource(R.string.register_family_name),
                    style = Typography.titleLarge,
                    modifier = Modifier.padding(bottom = 15.dp),
                    color = Brown
                )
            }
            TextComponent(
                text = stringResource(R.string.register_family_info),
                style = Typography.titleMedium,
                color = DarkGrey,
                maxLine = 5
            )
        }
        Column(modifier = Modifier.padding(bottom = 30.dp)) {
            TextButtonComponent(
                text = stringResource(R.string.go_to_name_btn),
                colors = ButtonDefaults.textButtonColors(
                    containerColor = Orange,
                    contentColor = ButtonContent
                ),
                style = Typography.labelMedium
            ) {
                viewModel.setEvent(RegisterFamilyEvent.OnClickRegisterNameButton)
            }
            TextButtonComponent(
                text = stringResource(R.string.go_to_code_btn),
                colors = ButtonDefaults.textButtonColors(
                    containerColor = Brown,
                    contentColor = ButtonContent
                ),
                style = Typography.labelMedium
            ) {
                viewModel.setEvent(RegisterFamilyEvent.OnClickRegisterCodeButton)
            }
        }
    }

    LaunchedEffect(key1 = viewModel.effect) {
        viewModel.effect.collect { effect ->
            when (effect) {
                RegisterFamilySideEffect.NavigateToRegisterCodeScreen -> {
                    navigateToRegisterByCode()
                }

                RegisterFamilySideEffect.NavigateToRegisterNameScreen -> {
                    navigateToRegisterByName()
                }

                RegisterFamilySideEffect.NavigateToPreviousScreen -> {
                    navigateToPreviousScreen()
                }

                RegisterFamilySideEffect.NavigateToNextScreen -> {}
            }
        }
    }
}
