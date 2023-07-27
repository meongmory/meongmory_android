package com.meongmoryteam.presentation.ui.myPage

import android.widget.ImageButton
import androidx.compose.animation.core.LinearEasing
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.meongmoryteam.presentation.R
import com.meongmoryteam.presentation.ui.theme.Pink40
import com.meongmoryteam.presentation.ui.theme.gray

@Preview
@Composable
fun MyPageScreen() {
    // 상단 프로필 메뉴
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
            Image(
                painter = painterResource(R.drawable.ic_profile),
                contentDescription = "프로필 기본 이미지",
                Modifier
                    .padding(padding)
                    .width(48.dp)
                    .height(48.dp)
                    .clip(RoundedCornerShape(100))
            )
            Column(
                modifier = Modifier.padding(padding)
            ) {
                Text(
                    text = "강아지밥주는사람",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp)
                Text(
                    text = "010-1234-1234",
                    fontSize = 10.sp,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.padding(padding),
                colors = ButtonDefaults.buttonColors(Color.White.copy(alpha = 0.6f), Color.Black)
            ) {
                Text(
                    text = "프로필 수정",
                )
            }
        }


        // 마이페이지 목록 부분
        Row(
            modifier = Modifier
                .padding(padding)
                .clip(RoundedCornerShape(5))
                .background(color = Color(gray.value))
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Column(
                modifier = Modifier.padding(padding)
            ) {
                Text(
                    text = "계정 설정",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(8.dp)
                )
                Row(
                    Modifier.padding(8.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_coin),
                        contentDescription = "pro 버전 아이콘",
                        Modifier
                            .width(25.dp)
                            .height(25.dp)
                    )
                    Text(
                        text = "Pro 버전",
                        Modifier.padding(start = padding)
                    )

                }

                Row(
                    Modifier.padding(8.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_logout),
                        contentDescription = "로그아웃 아이콘",
                        Modifier
                            .width(25.dp)
                            .height(25.dp)
                    )
                    Text(
                        text = "로그아웃",
                        Modifier.padding(start = padding)
                    )
                }

                Row(
                    Modifier.padding(8.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_person),
                        contentDescription = "회원탈퇴 아이콘",
                        Modifier
                            .width(25.dp)
                            .height(25.dp)
                    )
                    Text(
                        text = "회원탈퇴",
                        Modifier.padding(start = padding, bottom = padding)
                    )
                }

                // 구분선
                Divider(
                    color = Color.Black,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .padding(start = 8.dp, end = 8.dp)
                )


                Text(
                    text = "고객 지원",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 8.dp, top = padding, bottom = 8.dp)
                )

                Row(
                    Modifier.padding(8.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_message),
                        contentDescription = "공지사항 아이콘",
                        Modifier
                            .width(25.dp)
                            .height(25.dp)
                    )
                    Text(
                        text = "공지사항",
                        Modifier.padding(start = padding)
                    )
                }
                Row(
                    Modifier.padding(8.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_mail),
                        contentDescription = "문의하기 아이콘",
                        Modifier
                            .width(25.dp)
                            .height(25.dp)
                    )
                    Text(
                        text = "문의하기, 오류제보",
                        Modifier.padding(start = padding, bottom = padding)
                    )
                }

                // 구분선
                Divider(
                    color = Color.Black,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .padding(start = 8.dp, end = 8.dp)
                )

                Text(
                    text = "앱정보",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 8.dp, top = padding, bottom = 8.dp)
                )
                Row(
                    Modifier.padding(8.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_information),
                        contentDescription = "약관안내 아이콘",
                        Modifier
                            .width(25.dp)
                            .height(25.dp)
                    )
                    Text(
                        text = "약관 안내",
                        Modifier.padding(start = padding)
                    )
                }
                Row(
                    Modifier.padding(8.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_lock),
                        contentDescription = "개인정보 처리 방침 아이콘",
                        Modifier
                            .width(25.dp)
                            .height(25.dp)
                    )
                    Text(
                        text = "개인정보 처리 방침",
                        Modifier.padding(start = padding)
                    )
                }

            }

        }
    }
}

