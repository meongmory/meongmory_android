package com.meongmoryteam.presentation.ui.myPage.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.meongmoryteam.domain.repository.mypage.MyPageRepository
import com.meongmoryteam.domain.usecase.mypage.PatchUserMyPageUseCase
import com.meongmoryteam.presentation.R
import com.meongmoryteam.presentation.ui.theme.ButtonContent
import com.meongmoryteam.presentation.ui.theme.EditChangeFill
import com.meongmoryteam.presentation.ui.theme.EditChangeStroke
import com.meongmoryteam.presentation.ui.theme.EditDivider
import com.meongmoryteam.presentation.ui.theme.EditStroke
import com.meongmoryteam.presentation.ui.theme.EditText
import com.meongmoryteam.presentation.ui.theme.LightGrey
import com.meongmoryteam.presentation.ui.theme.MeongmoryTheme
import com.meongmoryteam.presentation.ui.theme.Orange

val PADDING_16 = 16.dp
val PADDING_24 = 24.dp

@Composable
fun MyPageProfileScreen(
    viewModel: MyPageProfileViewModel = hiltViewModel(),
    navigateToPrevious: () -> Unit,
) {
    val uiState by viewModel.viewState.collectAsState()

    // ViewModel에서 refreshButton 상태 가져오기
    val refreshButton by viewModel.refreshButton

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Box(
            Modifier.fillMaxHeight(),
            contentAlignment = Alignment.CenterStart
        ) {
            Column(
                modifier = Modifier.fillMaxHeight(),
                Arrangement.spacedBy(150.dp)
            ) {
                MyPageToolBar(
                    stringResource(R.string.profile_change_title),
                    onBackClick = {
                        // ViewModel 내부의 refreshButton 상태 변경
                        viewModel.setEvent(MyPageProfileContract.MyPageProfileEvent.OnClickPreviousButton)
                    }
                )
                ProfileChangeEdit()
            }
            Column(
                Modifier.fillMaxHeight(),
                Arrangement.Bottom
            ) {
                ProfileChangeButton(
                    isFilled = uiState.isFilled,
                    isOverflow = uiState.isError
                )
            }
        }
    }

    // refreshButton 상태가 변경되었을 때 이전 페이지로 이동
    LaunchedEffect(refreshButton) {
        if (refreshButton) {
            navigateToPrevious()
        }
    }
}


@Composable
fun MyPageToolBar(
    title: String,
    onBackClick: () -> Unit,
) {
    Column {
        // 위 아래 여백
        Row(
            modifier = Modifier
                .padding(top = PADDING_24, bottom = PADDING_24)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier
                        .height(24.dp)
                        .fillMaxWidth()
                ) {

                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_left_btn),
                        contentDescription = stringResource(R.string.profile_back_btn_description),
                        modifier = Modifier
                            .padding(start = PADDING_16)
                            .clickable {
                                onBackClick()
                            }
                    )
                }
                Text(
                    text = title,
                    fontSize = 15.sp
                )
            }
        }
        Divider(
            color = EditDivider.copy(0.2f)
        )
    }
}


@Composable
fun ProfileChangeLabel() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = PADDING_16)
    ) {
        Text(
            text = stringResource(R.string.profile_change_label),
            color = EditText,
            fontSize = 12.sp
        )
    }
}

@Composable
fun ProfileChangeExplain() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = PADDING_16)
    ) {
        Text(
            text = stringResource(R.string.profile_change_explain),
            color = EditText,
            fontSize = 11.sp
        )
    }
}

@Composable
fun ProfileChangeEdit(
    viewModel: MyPageProfileViewModel = hiltViewModel()
) {
    val uiState by viewModel.viewState.collectAsState()
    Column {
        ProfileChangeLabel()
        MyPageEditForm(
            value = uiState.nickName,
            isOverflow = uiState.isError
        ) {
            viewModel.setEvent(MyPageProfileContract.MyPageProfileEvent.FillNickName(it))
        }
        ProfileChangeExplain()
    }
}


@Composable
fun MyPageEditForm(
    value: String,
    isOverflow: Boolean,
    onValueChange: (String) -> Unit,
) {
    Box(
        modifier = Modifier
            .padding(PADDING_16)
            .fillMaxWidth()
            .height(48.dp)
            .background(
                if (value.isEmpty()) Color.White
                else EditChangeFill
            )
            .border(
                color =
                if (value.isEmpty()) EditStroke
                else if (isOverflow) Color.Red
                else EditChangeStroke,
                width = 1.dp,
                shape = RoundedCornerShape(10.dp)
            ),
        contentAlignment = Alignment.CenterStart // 정렬
    ) {
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            textStyle = TextStyle(
                fontSize = 14.sp,
                textAlign = TextAlign.Start
            ),
            modifier = Modifier.padding(start = PADDING_16, end = PADDING_16)
        )

        if (value.isEmpty()) {
            Text(
                text = stringResource(R.string.profile_now_nickname),
                color = EditText,
                modifier = Modifier.padding(start = PADDING_16, end = PADDING_16)
            )
        }
    }
}

@Composable
fun ProfileChangeButton(
    isFilled: Boolean,
    isOverflow: Boolean,
    viewModel: MyPageProfileViewModel = hiltViewModel()
) {
    Button(
        onClick = {
            if (isFilled && !isOverflow) {
                viewModel.setEvent(MyPageProfileContract.MyPageProfileEvent.OnClickChangeButton)
            }
        },
        colors = if (!isFilled || isOverflow) {
            ButtonDefaults.textButtonColors(LightGrey)
        } else {
            ButtonDefaults.textButtonColors(Orange)
        },
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = RoundedCornerShape(10.dp),
    ) {
        Text(
            text = stringResource(R.string.profile_change_button),
            fontSize = 15.sp,
            color = ButtonContent
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewProfileScreen() {
    MeongmoryTheme {
        MyPageProfileScreen(
            navigateToPrevious = { }
        )
    }
}