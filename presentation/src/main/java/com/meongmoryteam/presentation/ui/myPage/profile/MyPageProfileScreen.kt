package com.meongmoryteam.presentation.ui.myPage.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsStartWidth
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.meongmoryteam.presentation.R

val padding_8 = 8.dp
val padding_16 = 16.dp
val padding_24 = 24.dp

@Preview
@Composable
fun MypageProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        ProfileChangeTitle()
        ProfileChangeExplain()
        ProfileChangeEdit()
        Box(Modifier.fillMaxHeight(),
            contentAlignment = Alignment.BottomEnd) {
            ProfileChangeButton()
        }
    }
}


@Preview
@Composable
fun ProfileChangeTitle() {
    // 위 아래 여백
    Row(
        modifier = Modifier
            .padding(top = padding_24, bottom = padding_24)
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
            ){
                Icon(painter = painterResource(id = R.drawable.ic_left_btn), contentDescription = "뒤로 가기")

            }
            Text(text = "프로필 수정")
        }
    }
}

@Composable
fun ProfileChangeExplain() {
    Text(
        text = "한글/영문/띄어쓰기/숫자 포함 최대 6자 입력 가능해요.",
        modifier = Modifier
            .alpha(0.67f)
            .padding(top = 24.dp, bottom = 24.dp),
        fontSize = 15.sp
    )
}

@Composable
fun ProfileChangeEdit() {
    var text by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .padding(all = 16.dp)
            .fillMaxWidth()
            .height(48.dp)
            .border(
                color = Color.Gray,
                width = 1.dp,
                shape = CircleShape
            ),
        contentAlignment = Alignment.Center // 정렬
    ) {
        BasicTextField(
            value = text,
            onValueChange = { newText ->
                // 한 줄만 입력 가능하게 \n키를 누르면 입력 반영 안함
                text = newText.replace(Regex("[\n]"),"")
            },
            textStyle = TextStyle(
                fontSize = 14.sp,
                textAlign = TextAlign.Center
            ),
            singleLine = true,
            modifier = Modifier.fillMaxSize()
        )

        if (text.isEmpty()) {
            Text(
                text = "닉네임 입력",
                color = Color.Gray,
                textAlign = TextAlign.Start
            )
        }
    }
}



@Composable
fun ProfileChangeButton() {
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(Color.Gray),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Text(text = "수정하기",
        fontSize = 15.sp)
    }
}
