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
import com.meongmoryteam.presentation.ui.theme.ListDivider
import com.meongmoryteam.presentation.ui.theme.ListNextButton
import com.meongmoryteam.presentation.ui.theme.ListTitle
import com.meongmoryteam.presentation.ui.theme.MeongmoryTheme
import com.meongmoryteam.presentation.ui.theme.MyPageProfileEditButton
import com.meongmoryteam.presentation.ui.theme.MyPageYellowFill
import com.meongmoryteam.presentation.ui.theme.MyPageYellowStroke

val PADDING_8 = 8.dp
val PADDING_16 = 16.dp
val PADDING_24 = 24.dp

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
            .padding(PADDING_24)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = stringResource(R.string.my_page_title))

    }
}

@Composable
fun MyPageProfile() {
// 상단 프로필 메뉴
    Column {
        Row(
            Modifier
                .padding(PADDING_16)
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
                    .padding(start = PADDING_16)
                    .width(48.dp)
                    .height(48.dp)
                    .clip(RoundedCornerShape(100))
            )
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
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .padding()
                            .wrapContentSize(),
                        colors = ButtonDefaults.buttonColors(MyPageProfileEditButton, Color.Black)
                    ) {
                        Text(
                            text = stringResource(R.string.my_page_profile_edit),
                            fontSize = 9.sp
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
fun MyPageList() {

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
        Column{
            Text(
                text = stringResource(R.string.my_page_list_account),
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(start = 24.dp, top = 24.dp, bottom = 8.dp),
                color = ListTitle
            )
            ListButton(painterResource(R.drawable.ic_coin), stringResource(R.string.my_page_pro_ver))
            ListButton(painterResource(R.drawable.ic_logout), stringResource(R.string.my_page_logout))
            ListButton(painterResource( R.drawable.ic_person), stringResource(R.string.my_page_drop))
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
                color = ListTitle
            )

            ListButton(painterResource(R.drawable.ic_mail), stringResource(R.string.my_page_notice))
            ListButton(painterResource(R.drawable.ic_send), stringResource(R.string.my_page_question))

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
                text = stringResource(id = R.string.my_page_app_info),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 24.dp, top = 24.dp, bottom = 8.dp),
                color = ListTitle
            )
            ListButton(painterResource(R.drawable.ic_info), stringResource(R.string.my_page_clause))
            ListButton(painterResource(R.drawable.ic_lock), stringResource(R.string.my_page_personal))

        }


    }
}


@Composable
fun ListButton(
    buttonIcon: Painter? = null,
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

            if (buttonIcon != null) {
                Image(
                    painter = buttonIcon,
                    contentDescription = stringResource(R.string.my_page_list_button_icon),
                    Modifier
                        .width(20.dp)
                        .height(20.dp)
                )
            }
            Text(
                text = buttonText,
                Modifier
                    .padding(start = PADDING_16),
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
                    painter = painterResource(R.drawable.ic_right_btn),
                    contentDescription = stringResource(R.string.my_page_list_button_right),
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewMyPageScreen() {
    MeongmoryTheme {
        MyPageScreen()
    }
}