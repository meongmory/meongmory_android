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
import com.meongmoryteam.presentation.ui.myPage.profile.MyPageToolBar
import com.meongmoryteam.presentation.ui.theme.EditStroke
import com.meongmoryteam.presentation.ui.theme.EditText
import com.meongmoryteam.presentation.ui.theme.LightGrey
import com.meongmoryteam.presentation.ui.theme.MeongmoryTheme
import com.meongmoryteam.presentation.ui.theme.QuestionButtonText
import com.meongmoryteam.presentation.ui.theme.QuestionChangeButtonFill
import com.meongmoryteam.presentation.ui.theme.QuestionChangeFill
import com.meongmoryteam.presentation.ui.theme.QuestionChangeStroke
import com.meongmoryteam.presentation.ui.theme.QuestionEditFill
import com.meongmoryteam.presentation.ui.theme.QuestionSubTitle

val PADDING_8 = 8.dp
val PADDING_16 = 16.dp


@Composable
fun MyPageQuestionScreen(
    viewModel: MyPageQuestionViewModel = hiltViewModel(),
    navigateToPrevious: () -> Unit,
) {
    val uiState by viewModel.viewState.collectAsState()
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
            QuestionButton(
                isAllFilled = uiState.isAllFilled
            )
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
fun EmailEdit(
    viewModel: MyPageQuestionViewModel = hiltViewModel()
) {
    val uiState by viewModel.viewState.collectAsState()
    Column {
        QuestionLabel(stringResource(R.string.question_email_form_title))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            EmailForm(
                value = uiState.email
            ) {
                viewModel.setEvent(MyPageQuestionConstract.MyPageQuestionEvent.FillEmail(it))
            }
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
fun EmailForm(
    value: String,
    onValueChange: (String) -> Unit
) {
    Box(
        modifier = Modifier
            .padding(all = PADDING_16)
            .height(48.dp)
            .fillMaxWidth(0.5f)
            .border(
                color = if (value.isEmpty()) EditStroke
                else QuestionChangeStroke,
                width = 1.dp,
                shape = RoundedCornerShape(10.dp),
            )
            .background(
                color = if (value.isEmpty()) QuestionEditFill
                else QuestionChangeFill,
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
fun DetailEdit(
    viewModel: MyPageQuestionViewModel = hiltViewModel()
) {
    val uiState by viewModel.viewState.collectAsState()
    QuestionLabel(stringResource(R.string.question_content_title))
    DetailForm(
        value = uiState.question
    ) {
        viewModel.setEvent(MyPageQuestionConstract.MyPageQuestionEvent.FillQuestion(it))
    }
}

@Composable
fun DetailForm(
    value: String,
    onValueChange: (String) -> Unit
) {
    Box(
        modifier = Modifier
            .padding(PADDING_16)
            .fillMaxSize()
            .border(
                color = if (value.isEmpty()) EditStroke
                else QuestionChangeStroke,
                width = 1.dp,
                shape = RoundedCornerShape(10.dp),
            )
            .background(
                color = if (value.isEmpty()) QuestionEditFill
                else QuestionChangeFill,
                shape = RoundedCornerShape(10.dp)
            ),
        contentAlignment = Alignment.TopStart // 정렬
    ) {

        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            textStyle = TextStyle(
                fontSize = 14.sp,
                textAlign = TextAlign.Start
            ),
            modifier = Modifier
                .padding(PADDING_16)
        )
        if (value.isEmpty()) {
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
    isAllFilled: Boolean,
    viewModel: MyPageQuestionViewModel = hiltViewModel()
) {
    Button(
        onClick = {
            viewModel.setEvent(MyPageQuestionConstract.MyPageQuestionEvent.OnClickButton)
        },
        colors = if (!isAllFilled) {
            ButtonDefaults.textButtonColors(LightGrey)
        } else {
            ButtonDefaults.textButtonColors(QuestionChangeButtonFill)
        },
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
