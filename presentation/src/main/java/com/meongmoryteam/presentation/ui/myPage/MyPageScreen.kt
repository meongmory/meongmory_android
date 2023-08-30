package com.meongmoryteam.presentation.ui.myPage

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.meongmoryteam.presentation.R
import com.meongmoryteam.presentation.base.LogoutAlertDialog
import com.meongmoryteam.presentation.base.SecessionAlertDialog
import com.meongmoryteam.presentation.ui.theme.ListDivider
import com.meongmoryteam.presentation.ui.theme.ListNextButton
import com.meongmoryteam.presentation.ui.theme.ListTitle
import com.meongmoryteam.presentation.ui.theme.MeongmoryTheme
import com.meongmoryteam.presentation.ui.theme.MyPageProfileEditButton
import com.meongmoryteam.presentation.ui.theme.MyPageYellowFill
import com.meongmoryteam.presentation.ui.theme.MyPageYellowStroke

val PADDING_8 = 8.dp
val PADDING_16 = 16.dp

@Composable
fun MyPageScreen(
    viewModel: MyPageViewModel = hiltViewModel(),
    navigateToEditNickNameScreen: () -> Unit,
    navigateToQuestionScreen: () -> Unit,
    navigateToLoginScreen: () -> Unit
) {
    LaunchedEffect(true) {
        viewModel.setEvent(MyPageContract.MyPageEvent.InitMyPageScreen)
    }

    LaunchedEffect(viewModel.effect) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is MyPageContract.MyPageSideEffect.NavigateToEditProfile -> {
                    navigateToEditNickNameScreen()
                }

                is MyPageContract.MyPageSideEffect.NavigateToQuestion -> {
                    navigateToQuestionScreen()
                }

                is MyPageContract.MyPageSideEffect.NavigateToLogin -> {
                    navigateToLoginScreen()
                }
            }
        }
    }

    Column {
        MyPageTitle()
        MyPageProfile(
            OnClickEditNickname = {
                viewModel.setEvent(MyPageContract.MyPageEvent.OnClickProfileEditButtonClicked)
            }
        )
        MyPageList(
            onQuestionClicked = {
                viewModel.setEvent(MyPageContract.MyPageEvent.OnQuestionClicked)
            }
        )
    }
}

    @Composable
    fun MyPageTitle() {
        Box(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(R.string.my_page_title),
                fontSize = 15.sp
            )
        }
    }


    @Composable
    fun MyPageProfile(
        OnClickEditNickname: () -> Unit,
    ) {
// 상단 프로필 메뉴
        Column {
            Row(
                Modifier
                    .padding(PADDING_16)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(20))
                    .border(
                        width = 1.dp,
                        color = MyPageYellowStroke,
                        shape = RoundedCornerShape(20.dp)
                    )
                    .background(color = Color(MyPageYellowFill.value)),
                // 중앙 정렬
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Column(
                    modifier = Modifier
                        .padding(PADDING_16)
                        .fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = stringResource(R.string.my_page_profile),
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp
                        )

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End
                        ) {
                            MyPageProfileButton(
                                stringResource(R.string.my_page_profile_alarm),
                                onClick = { }
                            )
                            MyPageProfileButton(
                                stringResource(R.string.my_page_profile_edit),
                                onClick = OnClickEditNickname
                            )
                        }
                    }
                    Text(
                        modifier = Modifier.padding(bottom = 8.dp),
                        text = stringResource(R.string.my_page_phone_number),
                        fontSize = 10.sp
                    )
                }
            }
        }
    }


    @Composable
    fun MyPageList(
        onQuestionClicked: () -> Unit,
    ) {
        // 마이페이지 목록 부분
        Row(
            modifier = Modifier
                .padding(PADDING_16)
                .clip(RoundedCornerShape(5))
                .background(color = MyPageYellowFill)
                .border(width = 1.dp, color = MyPageYellowStroke, shape = RoundedCornerShape(19.dp))
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Column {
                Text(
                    text = stringResource(R.string.my_page_list_account),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(start = 24.dp, top = 24.dp, bottom = 8.dp),
                    color = ListTitle,
                    fontSize = 11.sp
                )
                ListButton(
                    R.drawable.ic_coin,
                    stringResource(R.string.my_page_pro_ver),
                    onClick = { },
                )
                ListButton(
                    R.drawable.ic_logout,
                    stringResource(R.string.my_page_logout),
                    stringResource(R.string.my_page_logout),
                    onClick = {  },
                )
                ListButton(
                    R.drawable.ic_user,
                    stringResource(R.string.my_page_drop),
                    stringResource(R.string.my_page_drop),
                    onClick = { },
                )

                Spacer(modifier = Modifier.padding(top = PADDING_16))

                // 구분선
                Divider(
                    color = ListDivider,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .padding(start = 24.dp, end = 24.dp)
                )

                Text(
                    text = stringResource(R.string.my_page_support),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 24.dp, top = 24.dp, bottom = 8.dp),
                    color = ListTitle,
                    fontSize = 11.sp
                )

                ListButton(
                    R.drawable.ic_mail,
                    stringResource(R.string.my_page_notice),
                    onClick = { },
                )
                ListButton(
                    R.drawable.ic_send,
                    stringResource(R.string.my_page_question),
                    onClick = onQuestionClicked,
                )

                Spacer(modifier = Modifier.padding(top = PADDING_16))

                // 구분선
                Divider(
                    color = ListDivider,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .padding(start = 24.dp, end = 24.dp)
                )

                Text(
                    text = stringResource(R.string.my_page_app_info),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 24.dp, top = 24.dp, bottom = 8.dp),
                    color = ListTitle,
                    fontSize = 11.sp
                )
                ListButton(
                    R.drawable.ic_info,
                    stringResource(R.string.my_page_clause),
                    onClick = { },
                )
                ListButton(
                    R.drawable.ic_unlock,
                    stringResource(R.string.my_page_personal),
                    onClick = { },
                )
            }
        }
    }

    @Composable
    fun MyPageProfileButton(
        buttonText: String? = null,
        onClickAction: String? = null,
        onClick: () -> Unit,
        viewModel: MyPageViewModel = hiltViewModel()
    ) {
        val refreshButton = viewModel.refreshButton

        Column(modifier = Modifier) {
            Button(
                onClick = {
                    onClick()
                    if (onClickAction != null) {
                        // ViewModel 내의 refreshButton 값을 직접 수정
                        viewModel.refreshButton.value = true
                    }
                },
                modifier = Modifier
                    .padding(end = PADDING_8)
                    .wrapContentSize(),
                contentPadding = PaddingValues(4.dp),
                colors = ButtonDefaults.buttonColors(MyPageProfileEditButton, Color.Black)
            ) {
                if (buttonText != null) {
                    Text(
                        text = buttonText,
                        fontSize = 9.sp
                    )
                }
            }
        }
        // 버튼마다 다른 다이어로그
        if (refreshButton.value) {
            if (onClickAction == stringResource(R.string.my_page_profile_edit)) {
                LogoutAlertDialog(openDialogCustom = refreshButton)
            }
            if (onClickAction == stringResource(R.string.my_page_question)) {
                SecessionAlertDialog(openDialogCustom = refreshButton)
            }
        }
    }


    @Composable
    fun ListButton(
        buttonIcon: Int? = null,
        buttonText: String,
        onClickAction: String? = null,
        onClick: () -> Unit,
    ) {
        val openDialogCustom = remember {
            mutableStateOf(false)
        }
        val refreshButton = remember {
            mutableStateOf(false)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Button(
                onClick = {
                    onClick()
                    openDialogCustom.value = true
                    if (onClickAction != null) {
                        refreshButton.value = true
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.Unspecified,
                    containerColor = Color.Transparent
                )
            ) {

                if (buttonIcon != null) {
                    Icon(
                        imageVector = ImageVector.vectorResource(buttonIcon),
                        contentDescription = stringResource(R.string.my_page_list_button_icon),
                    )
                }
                Text(
                    text = buttonText,
                    Modifier
                        .padding(start = PADDING_16),
                    color = Color.Black,
                    fontSize = 12.sp
                )
            }
            Box(
                modifier = Modifier
                    .padding()
                    .fillMaxWidth(),
                contentAlignment = Alignment.CenterEnd
            ) {
                Button(
                    onClick = {
                        onClick()
                        openDialogCustom.value = true
                        if (onClickAction != null) {
                            refreshButton.value = true
                        }
                    },
                    colors = ButtonDefaults.buttonColors(Color.Transparent, ListNextButton)
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_right_btn),
                        contentDescription = stringResource(R.string.my_page_list_button_right),
                    )
                }
            }
        }
        // 버튼마다 다른 다이어로그
        if (openDialogCustom.value) {
            if (onClickAction == stringResource(R.string.my_page_logout)) {
                LogoutAlertDialog(openDialogCustom = openDialogCustom)
            }
            if (onClickAction == stringResource(R.string.my_page_drop)) {
                SecessionAlertDialog(openDialogCustom = openDialogCustom)
            }
        }
    }


    @Preview(showBackground = true)
    @Composable
    fun PreviewMyPageScreen() {
        MeongmoryTheme {
            MyPageScreen(
                navigateToEditNickNameScreen = { },
                navigateToQuestionScreen = { },
                navigateToLoginScreen = { }
            )
        }
    }

