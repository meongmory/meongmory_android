package com.meongmoryteam.presentation.ui.myPage.profile

import androidx.compose.foundation.border
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.meongmoryteam.presentation.R
import com.meongmoryteam.presentation.ui.theme.EditButtonFalse
import com.meongmoryteam.presentation.ui.theme.EditDivider
import com.meongmoryteam.presentation.ui.theme.EditStroke
import com.meongmoryteam.presentation.ui.theme.EditText
import com.meongmoryteam.presentation.ui.theme.MeongmoryTheme

val PADDING_16 = 16.dp
val PADDING_24 = 24.dp

@Composable
fun MyPageProfileScreen(
    viewModel: MyPageProfileViewModel = hiltViewModel(),
) {
    val uiState by viewModel.viewState.collectAsState()

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
                MyPageToolBar(stringResource(R.string.profile_change_title))
                ProfileChangeEdit()
            }
            Column(
                Modifier.fillMaxHeight(),
                Arrangement.Bottom
            ) {
                ProfileChangeButton()
            }
        }
    }
}


@Composable
fun MyPageToolBar(
    title: String
) {
    Column() {
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
                        modifier = Modifier.padding(start = PADDING_16),
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
) {
    Column {
        ProfileChangeLabel()
        MyPageEditForm()
        ProfileChangeExplain()
    }
}


@Composable
fun MyPageEditForm() {
    var text by remember { mutableStateOf("") }
    Box(
        modifier = Modifier
            .padding(PADDING_16)
            .fillMaxWidth()
            .height(48.dp)
            .border(
                color = EditStroke,
                width = 1.dp,
                shape = RoundedCornerShape(10.dp)
            ),
        contentAlignment = Alignment.CenterStart // 정렬
    ) {
        BasicTextField(
            value = text,
            onValueChange = { newText ->
                // 한 줄만 입력 가능하게 \n키를 누르면 입력 반영 안함
                text = newText.replace(Regex("[\n]"), "")
            },
            textStyle = TextStyle(
                fontSize = 14.sp,
                textAlign = TextAlign.Start
            ),
            modifier = Modifier.padding(start = PADDING_16, end = PADDING_16)
        )

        if (text.isEmpty()) {
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
    viewModel: MyPageProfileViewModel = hiltViewModel()
) {
    val uiState by viewModel.viewState.collectAsState()
    Button(
        onClick = {
            viewModel.setEvent(MyPageProfileContract.MyPageProfileEvent.OnClickChangeButton)
        },
        colors = ButtonDefaults.buttonColors(EditButtonFalse),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = RoundedCornerShape(10.dp),
    ) {
        Text(
            text = stringResource(R.string.profile_change_button),
            fontSize = 15.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProfileScreen() {
    MeongmoryTheme {
        MyPageProfileScreen()
    }
}