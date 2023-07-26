package com.meongmoryteam.presentation.ui.myPage

import android.widget.ImageButton
import androidx.compose.animation.core.LinearEasing
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.meongmoryteam.presentation.R
import com.meongmoryteam.presentation.ui.theme.gray

@Composable
fun MyPageScreen() {
    Column {
        val padding = 16.dp
        Row(
            Modifier
                .padding(padding)
                .fillMaxWidth()
                .clip(RoundedCornerShape(30))
                .background(color = Color(gray.value)),
            // 중앙 정렬
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "프로필")
            Column(
                modifier = Modifier.padding(start = 16.dp)
            ) {
                Text(text = "강아지밥주는사람")
                Text(text = "010-1234-1234")
            }
            Button(
                onClick = { /*TODO*/ },
                Modifier.padding(padding)
            ) {
                Text(text = "프로필 수정")
            }
        }

        Row(
            modifier = Modifier.padding(padding)
                .clip(RoundedCornerShape(5))
                .background(color = Color(gray.value))
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Column(
                modifier = Modifier.padding(padding)
            ) {
                Text(text = "계정 설정")
                Row(
                    Modifier.padding(8.dp)
                ) {
                    Text(text = "아이콘")
                    Text(text = "Pro 버전")
                }

                Row(
                    Modifier.padding(8.dp)
                ) {
                    Text(text = "아이콘")
                    Text(text = "로그아웃")
                }

                Row(
                    Modifier.padding(8.dp)
                ) {
                    Text(text = "아이콘")
                    Text(text = "회원탈퇴")
                }

                Text(text = "고객 지원")

                Row(
                    Modifier.padding(8.dp)
                ) {
                    Text(text = "아이콘")
                    Text(text = "공지사항")
                }
                Row(
                    Modifier.padding(8.dp)
                ) {
                    Text(text = "아이콘")
                    Text(text = "문의하기, 오류제보")
                }

                Text(text = "앱정보")
                Row(
                    Modifier.padding(8.dp)
                ) {
                    Text(text = "아이콘")
                    Text(text = "약관 안내")
                }
                Row(
                    Modifier.padding(8.dp)
                ) {
                    Text(text = "아이콘")
                    Text(text = "개인정보 처리 방침")
                }

            }

        }
    }
}