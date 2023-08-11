package com.meongmoryteam.presentation.ui.myPage.question

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import com.meongmoryteam.presentation.R
import com.meongmoryteam.presentation.ui.myPage.profile.MyPageProfileViewModel
import com.meongmoryteam.presentation.ui.myPage.profile.MyPageToolBar
import com.meongmoryteam.presentation.ui.theme.EditButtonFalse
import com.meongmoryteam.presentation.ui.theme.EditStroke
import com.meongmoryteam.presentation.ui.theme.EditText
import com.meongmoryteam.presentation.ui.theme.MeongmoryTheme
import com.meongmoryteam.presentation.ui.theme.QuestionButtonText
import com.meongmoryteam.presentation.ui.theme.QuestionChangeFill
import com.meongmoryteam.presentation.ui.theme.QuestionChangeStroke
import com.meongmoryteam.presentation.ui.theme.QuestionEditFill
import com.meongmoryteam.presentation.ui.theme.QuestionSubTitle

val PADDING_8 = 8.dp
val PADDING_16 = 16.dp
val PADDING_24 = 24.dp


@Composable
fun MyPageQuestionScreen(
    viewModel: MyPageProfileViewModel = hiltViewModel(),
    navigateToPrevious: () -> Unit,
) {
    val refreshButton = remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Top,
    ) {
        MyPageToolBar(
            stringResource(R.string.question_title),
            onBackClick = {
                navigateToPrevious
                refreshButton.value = true
            }
        )
        Spacer(modifier = Modifier.padding(PADDING_8))
        EmailEdit()
        Column(
            modifier = Modifier.fillMaxHeight(0.5f)
        ) {
            DetailEdit()
        }
        Box(
            modifier = Modifier.fillMaxHeight(),
            contentAlignment = Alignment.BottomCenter
        ) {
            QuestionButton()
        }
    }
    // refreshButton 상태가 변경되었을 때 이전 페이지로 이동
    LaunchedEffect(refreshButton.value) {
        if (refreshButton.value) {
            navigateToPrevious()
        }
    }
}

@Composable
fun EmailEdit() {
    Column {
        QuestionLabel(stringResource(R.string.question_email_form_title))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            EmailForm()
            Text(text = stringResource(R.string.question_at))
            EmailSelect()
        }
    }
}


@Composable
fun QuestionLabel(
    label: String
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = PADDING_16, top = PADDING_16)
    ) {
        Text(
            text = label,
            color = QuestionSubTitle,
            fontSize = 13.sp
        )
    }
}


@Composable
fun EmailForm() {
    var email by remember { mutableStateOf("") }
    var isTextEmpty by remember { mutableStateOf(true) } // Text가 비어있는지 여부를 추적

    Box(
        modifier = Modifier
            .padding(all = PADDING_16)
            .height(48.dp)
            .fillMaxWidth(0.5f)
            .border(
                color = if (isTextEmpty) EditStroke
                else QuestionChangeStroke,
                width = 1.dp,
                shape = RoundedCornerShape(10.dp),
            )
            .background(
                color = if (isTextEmpty) QuestionEditFill
                else QuestionChangeFill,
                shape = RoundedCornerShape(10.dp)),
        contentAlignment = Alignment.CenterStart // 정렬
    ) {

        BasicTextField(
            value = email,
            onValueChange = { newText ->
                // 한 줄만 입력 가능하게 \n키를 누르면 입력 반영 안함
                email = newText.replace(Regex("[\n]"), "")
                isTextEmpty = newText.isBlank()
            },
            textStyle = TextStyle(
                fontSize = 14.sp,
                textAlign = TextAlign.Start
            ),
            modifier = Modifier.padding(start = PADDING_16, end = PADDING_16)
        )

        if (email.isEmpty()) {
            Text(
                text = stringResource(R.string.question_email_form_hint),
                color = EditText,
                fontSize = 12.sp,
                modifier = Modifier.padding(start = PADDING_16, end = PADDING_16)
            )
        }
    }
}

@Composable
fun EmailSelect() {
    Row(
        modifier = Modifier
            .padding(PADDING_16)
            .height(48.dp)
            .fillMaxWidth()
            .border(
                color = EditStroke,
                width = 1.dp,
                shape = RoundedCornerShape(10.dp)
            )
            .background(color = QuestionEditFill, shape = RoundedCornerShape(10.dp)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            stringResource(R.string.question_email_select),
            fontSize = 12.sp,
            color = EditText,
            modifier = Modifier.padding(PADDING_16)
        )
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_email_select),
            contentDescription = stringResource(R.string.question_email_select),
            modifier = Modifier.padding(end = PADDING_8)
        )
    }
}


@Composable
fun DetailEdit() {
    QuestionLabel(stringResource(R.string.question_content_title))
    DetailForm()
}

@Composable
fun DetailForm() {
    var detail by remember { mutableStateOf("") }
    var isTextEmpty by remember { mutableStateOf(true) } // Text가 비어있는지 여부를 추적

    Box(
        modifier = Modifier
            .padding(PADDING_16)
            .fillMaxSize()
            .border(
                color = if (isTextEmpty) EditStroke
                else QuestionChangeStroke,
                width = 1.dp,
                shape = RoundedCornerShape(10.dp),
            )
            .background(
                color = if (isTextEmpty) QuestionEditFill
                else QuestionChangeFill,
                shape = RoundedCornerShape(10.dp)),
        contentAlignment = Alignment.TopStart // 정렬
    ) {

        BasicTextField(
            value = detail,
            onValueChange = { newText ->
                // 한 줄만 입력 가능하게 \n키를 누르면 입력 반영 안함
                detail = newText
                isTextEmpty = newText.isBlank()
            },
            textStyle = TextStyle(
                fontSize = 14.sp,
                textAlign = TextAlign.Start
            ),
            modifier = Modifier
                .padding(PADDING_16)
        )
        if (detail.isEmpty()) {
            Text(
                text = stringResource(R.string.question_content_detail),
                color = EditText,
                fontSize = 12.sp,
                modifier = Modifier
                    .padding(PADDING_16)
            )
        }
    }
}

@Composable
fun QuestionButton(
    viewModel: MyPageQuestionViewModel = hiltViewModel()
) {
    val uiState by viewModel.viewState.collectAsState()
    Button(
        onClick = {
            viewModel.setEvent(MyPageQuestionConstract.MyPageQuestionEvent.OnClickButton)
        },
        colors = ButtonDefaults.buttonColors(EditButtonFalse),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = RoundedCornerShape(10.dp)
    ) {
        Text(
            text = stringResource(R.string.question_button),
            color = QuestionButtonText,
            fontSize = 15.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewQuestionScreen() {
    MeongmoryTheme {
        MyPageQuestionScreen(
            navigateToPrevious = { }
        )
    }
}
