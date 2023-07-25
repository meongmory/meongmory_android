package com.meongmoryteam.presentation.ui.register_dog

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.meongmoryteam.presentation.ui.theme.Button
import com.meongmoryteam.presentation.ui.theme.ButtonContent
import com.meongmoryteam.presentation.ui.theme.MeongmoryTheme
import com.meongmoryteam.presentation.ui.theme.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun RegisterDogScreen(){
    RegisterDogForm {
        Column() {
            TextComponent(text = "환영합니다 ooo님!", style = Typography.titleMedium, modifier = Modifier.padding(bottom = 20.dp))
            TextComponent(text = "우리집 반려동물을 등록하고 가족, 지인과 반려동물의 추억을 공유해보세요!\n" + "\n" + "혹은 가족 및 지인에게 초대 코드를 받아 반려동물의 일상을 구경해보세요!", style = Typography.titleSmall)
        }
        Column(modifier = Modifier.padding(bottom = 30.dp)) {
            TextButtonComponent(onClick = {}, text = "주인으로 강아지네 새로 만들기")
            TextButtonComponent(onClick = {}, text = "가족 및 지인으로 등록하기 (초대 코드)")
        }
    }
}

@Composable
fun TextComponent(text: String, style: TextStyle, modifier: Modifier = Modifier){
    Text(text = text, style = style, modifier = modifier)
}

@Composable
fun TextButtonComponent(onClick: ()->Unit, text: String){
    TextButton(
        onClick = {},
        shape = RoundedCornerShape(10.dp),
        modifier= Modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(vertical = 5.dp),
        colors = ButtonDefaults.textButtonColors(containerColor = Button, contentColor = ButtonContent))
    {
        Text(text = text, style = Typography.labelSmall, textAlign = TextAlign.Center, modifier = Modifier.padding(vertical = 0.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MeongmoryTheme {
        RegisterDogScreen()
    }
}