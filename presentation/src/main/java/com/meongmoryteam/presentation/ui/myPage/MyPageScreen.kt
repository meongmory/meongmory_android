package com.meongmoryteam.presentation.ui.myPage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.meongmoryteam.presentation.R
import com.meongmoryteam.presentation.ui.theme.ListNextButton
import com.meongmoryteam.presentation.ui.theme.MyPageProfileEditButton
import com.meongmoryteam.presentation.ui.theme.MyPageYellowFill
import com.meongmoryteam.presentation.ui.theme.MyPageYellowStroke
val padding_16 = 16.dp

@Preview
@Composable
fun MyPageScreen() {
    Column {
        MyPageTitle()
        MyPageProfile()
        MyPageList()
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
        Text(text = stringResource(id = R.string.my_page_title))

    }
}

@Preview
@Composable
fun MyPageProfile() {
// 상단 프로필 메뉴
    Column {
        Row(
            Modifier
                .padding(padding_16)
                .fillMaxWidth()
                .clip(RoundedCornerShape(20))
                .border(width = 1.dp, color = MyPageYellowStroke, shape = RoundedCornerShape(20.dp))
                .background(color = Color(MyPageYellowFill.value)),
            // 중앙 정렬
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(R.drawable.ic_profile),
                contentDescription = "프로필 기본 이미지",
                Modifier
                    .padding(start = padding_16)
                    .width(48.dp)
                    .height(48.dp)
                    .clip(RoundedCornerShape(100))
            )
            Column(
                modifier = Modifier
                    .padding(padding_16)
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = stringResource(id = R.string.my_page_profile),
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .padding()
                            .wrapContentSize(),
                        colors = ButtonDefaults.buttonColors(MyPageProfileEditButton, Color.Black)
                    ) {
                        Text(
                            text = stringResource(id = R.string.my_page_profile_edit),
                            fontSize = 9.sp
                        )
                    }
                }
                Text(
                    modifier = Modifier.padding(bottom = 8.dp),
                    text = stringResource(id = R.string.my_page_phone_number),
                    fontSize = 10.sp
                )
            }

        }


    }
}

@Composable
fun MyPageList() {

    // 마이페이지 목록 부분
    Row(
        modifier = Modifier
            .padding(padding_16)
            .clip(RoundedCornerShape(5))
            .background(color = MyPageYellowFill)
            .border(width = 1.dp, color = MyPageYellowStroke, shape = RoundedCornerShape(19.dp))
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Column{
            Text(
                text = stringResource(id = R.string.my_page_list_account),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 24.dp, top = 24.dp, bottom = 8.dp)
            )
            ListButton(painterResource(id = R.drawable.ic_lock), stringResource(id = R.string.my_page_personal))
            ListButton(painterResource(id = R.drawable.ic_lock), stringResource(id = R.string.my_page_personal))
            ListButton(painterResource(id = R.drawable.ic_lock), stringResource(id = R.string.my_page_personal))
            Spacer(modifier = Modifier.padding(top = padding_16))

            // 구분선
            Divider(
                color = Color.Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .padding(start = 24.dp, end = 24.dp)
            )


            Text(
                text = stringResource(id = R.string.my_page_support),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 24.dp, top = 24.dp, bottom = 8.dp)
            )

            ListButton(painterResource(id = R.drawable.ic_lock), stringResource(id = R.string.my_page_personal))
            ListButton(painterResource(id = R.drawable.ic_lock), stringResource(id = R.string.my_page_personal))

            Spacer(modifier = Modifier.padding(top = padding_16))

            // 구분선
            Divider(
                color = Color.Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .padding(start = 24.dp, end = 24.dp)
            )

            Text(
                text = stringResource(id = R.string.my_page_app_info),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 24.dp, top = 24.dp, bottom = 8.dp)
            )
            ListButton(painterResource(id = R.drawable.ic_lock), stringResource(id = R.string.my_page_personal))
            ListButton(painterResource(id = R.drawable.ic_lock), stringResource(id = R.string.my_page_personal))

        }


    }
}


@Composable
fun ListButton(
    buttonIcon: Painter,
    buttonText: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
        ) {

            Image(
                painter = buttonIcon,
                contentDescription = "아이콘",
                Modifier
                    .width(20.dp)
                    .height(20.dp)
            )
            Text(
                text = buttonText,
                Modifier
                    .padding(start = padding_16),
                color = Color.Black
            )
        }

        Box(modifier = Modifier
            .padding()
            .fillMaxWidth(),
            contentAlignment = Alignment.CenterEnd
        ) {
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(Color.Transparent, ListNextButton)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_right_btn,),
                    contentDescription = "",
                    modifier = Modifier
                )
            }
        }
    }
}