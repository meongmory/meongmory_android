package com.meongmoryteam.presentation.ui.myPage.question

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.meongmoryteam.presentation.R
import com.meongmoryteam.presentation.ui.myPage.profile.MyPageEditForm
import com.meongmoryteam.presentation.ui.myPage.profile.MyPageToolBar
import com.meongmoryteam.presentation.ui.theme.MeongmoryTheme
import com.meongmoryteam.presentation.ui.theme.ProfileEditStroke
import com.meongmoryteam.presentation.ui.theme.ProfileEditText

val PADDING_8 = 8.dp
val PADDING_16 = 16.dp
val PADDING_24 = 24.dp


@Composable
fun MyPageQuestionScreen() {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        MyPageToolBar(stringResource(R.string.question_title))
    }
}

@Composable
fun EmailForm() {
    var email by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .padding(all = com.meongmoryteam.presentation.ui.myPage.profile.PADDING_16)
            .fillMaxWidth()
            .height(48.dp)
            .border(
                color = ProfileEditStroke,
                width = 1.dp,
                shape = RoundedCornerShape(10.dp)
            ),
        contentAlignment = Alignment.CenterStart // 정렬
    ) {
        BasicTextField(
            value = email,
            onValueChange = { newText ->
                // 한 줄만 입력 가능하게 \n키를 누르면 입력 반영 안함
                email = newText.replace(Regex("[\n]"),"")
            },
            textStyle = TextStyle(
                fontSize = 14.sp,
                textAlign = TextAlign.Start
            ),
            modifier = Modifier.padding(start = com.meongmoryteam.presentation.ui.myPage.profile.PADDING_16)
        )

        if (email.isEmpty()) {
            Text(
                text = stringResource(id = R.string.profile_now_nickname),
                color = ProfileEditText,
                modifier = Modifier.padding(start = com.meongmoryteam.presentation.ui.myPage.profile.PADDING_16)
            )
        }

        else {

        }

    }
}


@Preview(showBackground = true)
@Composable
fun PreviewQuestionScreen() {
    MeongmoryTheme {
        MyPageQuestionScreen()
    }
}