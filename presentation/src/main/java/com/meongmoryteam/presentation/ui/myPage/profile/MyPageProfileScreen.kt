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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.meongmoryteam.presentation.R
import com.meongmoryteam.presentation.ui.MyIconPack
import com.meongmoryteam.presentation.ui.myiconpack.`Arrow-left`
import com.meongmoryteam.presentation.ui.theme.MeongmoryTheme
import com.meongmoryteam.presentation.ui.theme.ProfileEditDivider
import com.meongmoryteam.presentation.ui.theme.ProfileEditStroke
import com.meongmoryteam.presentation.ui.theme.ProfileEditText

val PADDING_8 = 8.dp
val PADDING_16 = 16.dp
val PADDING_24 = 24.dp

@Composable
fun MypageProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {

        Box(Modifier.fillMaxHeight(),
            contentAlignment = Alignment.CenterStart) {

            Column(modifier = Modifier.fillMaxHeight(),
            Arrangement.spacedBy(150.dp)) {
                ProfileChangeToolBar()
                ProfileChangeEdit()




            }

            Column(Modifier.fillMaxHeight(),
                Arrangement.Bottom) {
                ProfileChangeButton()

            }
        }


    }
}



@Composable
fun ProfileChangeToolBar() {
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
                ){
                    Icon(imageVector = MyIconPack.`Arrow-left`,
                        contentDescription = stringResource(
                        id = R.string.profile_back_btn_description
                    ))

                }
                Text(text = stringResource(id = R.string.profile_change_title))
            }
        }

        Divider(
            color = ProfileEditDivider
        )
    }

}


@Composable
fun ProfileChangeLabel() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(start = PADDING_16)) {
        Text(
            text = stringResource(id = R.string.profile_change_label),
            color = ProfileEditText,
            fontSize = 12.sp
        )
    }
}

@Composable
fun ProfileChangeExplain() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(start = PADDING_16)) {
        Text(
            text = stringResource(id = R.string.profile_change_explain),
            color = ProfileEditText,
            fontSize = 11.sp
        )
    }
}

@Composable
fun ProfileChangeEdit(
) {
    var text by remember { mutableStateOf("") }

    Column(
    ) {
        ProfileChangeLabel()

        Box(
            modifier = Modifier
                .padding(all = PADDING_16)
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
                value = text,
                onValueChange = { newText ->
                    // 한 줄만 입력 가능하게 \n키를 누르면 입력 반영 안함
                    text = newText.replace(Regex("[\n]"),"")
                },
                textStyle = TextStyle(
                    fontSize = 14.sp,
                    textAlign = TextAlign.Start
                ),
            )

            if (text.isEmpty()) {
                Text(
                    text = stringResource(id = R.string.profile_now_nickname),
                    color = ProfileEditText,
                )
            }

        }
        ProfileChangeExplain()

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
        Text(text = stringResource(id = R.string.profile_change_button),
        fontSize = 15.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProfileScreen() {
    MeongmoryTheme {
        MypageProfileScreen()
    }
}