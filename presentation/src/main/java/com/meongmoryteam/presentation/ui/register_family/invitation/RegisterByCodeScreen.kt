package com.meongmoryteam.presentation.ui.register_family.invitation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
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
import com.meongmoryteam.presentation.ui.register_family.RegisterFamilyContract.RegisterFamilyEvent.FillInCode
import com.meongmoryteam.presentation.ui.register_family.RegisterFamilyViewModel
import com.meongmoryteam.presentation.ui.register_family.TextButtonComponent
import com.meongmoryteam.presentation.ui.register_family.TextComponent
import com.meongmoryteam.presentation.ui.register_family.TextFieldComponent
import com.meongmoryteam.presentation.ui.theme.AppleSD
import com.meongmoryteam.presentation.ui.theme.Black
import com.meongmoryteam.presentation.ui.theme.ButtonContent
import com.meongmoryteam.presentation.ui.theme.DarkGrey
import com.meongmoryteam.presentation.ui.theme.Error
import com.meongmoryteam.presentation.ui.theme.InputBoxOutline
import com.meongmoryteam.presentation.ui.theme.LightGrey
import com.meongmoryteam.presentation.ui.theme.LightYellow
import com.meongmoryteam.presentation.ui.theme.NotoSansKR
import com.meongmoryteam.presentation.ui.theme.Orange
import com.meongmoryteam.presentation.ui.theme.Typography
import com.meongmoryteam.presentation.ui.theme.White
import com.meongmoryteam.presentation.ui.theme.Yellow

@Composable
fun RegisterByCodeScreen(
    navController: NavController,
    viewModel: RegisterFamilyViewModel = hiltViewModel(),
    navigateToRegisterScreen: () -> Unit,
    navigateToMainScreen: () -> Unit
) {
    val viewState by viewModel.viewState.collectAsState()

    RegisterDogForm(navController = navController) {
        Column(modifier = Modifier.fillMaxWidth()) {
            TextComponent(
                text = stringResource(R.string.register_by_code_title),
                style = Typography.titleLarge,
                modifier = Modifier.padding(bottom = 20.dp),
                color = Black
            )
            TextComponent(
                text = stringResource(R.string.register_by_code_info),
                style = Typography.titleSmall,
                color = DarkGrey
            )
        }
        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                TextFieldComponent(
                    name = viewState.code,
                    onValueChange = { viewModel.setEvent(FillInCode(it)) },
                    placeholder = stringResource(R.string.code_placeholder),
                    modifier = Modifier.fillMaxWidth(0.7f),
                    bgColor = if (!viewState.isFilledCode) {
                        Color(0xFFF9F9F9)
                    } else {
                        LightYellow
                    },
                    borderColor = if (!viewState.isFilledCode) {
                        InputBoxOutline
                    } else {
                        Yellow
                    }
                )
                Spacer(modifier = Modifier.fillMaxWidth(0.1f))
                TextButtonComponent(
                    text = stringResource(R.string.check),
                    colors = if (!viewState.isFilledCode) {
                        ButtonDefaults.textButtonColors(LightGrey)
                    } else {
                        ButtonDefaults.textButtonColors(Orange)
                    },
                    style = TextStyle(
                        fontFamily = AppleSD,
                        fontWeight = FontWeight.W400,
                        fontSize = 13.sp,
                        lineHeight = 20.sp,
                        color = ButtonContent
                    ),
                    width = 1f
                ) {}
            }
            CheckValidCode(isInvalid = viewState.isFilledCode)
        }
        Spacer(modifier = Modifier.fillMaxHeight(0.3f))
        Column(modifier = Modifier.padding(bottom = 30.dp)) {
            TextButtonComponent(
                text = stringResource(R.string.next),
                colors = if (!viewState.isFilledCode) {
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
            ) {}
        }
    }
}

@Composable
fun CheckValidCode(isInvalid: Boolean) {
    //우선 텍스트가 입력되지 않은 경우 경고 메시지가 뜨도록 설정
    if (!isInvalid) {
        Text(
            modifier = Modifier.padding(vertical = 5.dp),
            text = stringResource(R.string.not_valid_code),
            color = Error,
            style = Typography.titleSmall
        )
    } else {
        Text(
            modifier = Modifier.padding(vertical = 5.dp),
            text = "",
            color = White,
            style = Typography.titleSmall
        )
    }
}
