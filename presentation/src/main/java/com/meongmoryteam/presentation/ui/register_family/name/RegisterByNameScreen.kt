package com.meongmoryteam.presentation.ui.register_family.name

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.meongmoryteam.presentation.R
import com.meongmoryteam.presentation.ui.register_family.RegisterDogForm
import com.meongmoryteam.presentation.ui.register_family.TextButtonComponent
import com.meongmoryteam.presentation.ui.register_family.TextComponent
import com.meongmoryteam.presentation.ui.register_family.TextFieldComponent
import com.meongmoryteam.presentation.ui.theme.ButtonContent
import com.meongmoryteam.presentation.ui.theme.DarkGrey
import com.meongmoryteam.presentation.ui.theme.InputBoxOutline
import com.meongmoryteam.presentation.ui.theme.LightGrey
import com.meongmoryteam.presentation.ui.theme.LightYellow
import com.meongmoryteam.presentation.ui.theme.NotoSansKR
import com.meongmoryteam.presentation.ui.theme.Orange
import com.meongmoryteam.presentation.ui.theme.Placeholer
import com.meongmoryteam.presentation.ui.theme.Typography
import com.meongmoryteam.presentation.ui.theme.Yellow

@Composable
fun RegisterByNameScreen(navController: NavController) {
    var name by remember{ mutableStateOf(TextFieldValue("")) }
    var enabled by remember{ mutableStateOf(false) }

    RegisterDogForm(navController = navController) {
        Column {
            TextComponent(
                text = stringResource(R.string.register_by_name_title),
                style = Typography.titleLarge,
                modifier = Modifier.padding(bottom = 10.dp),
                color = Orange)
            TextComponent(
                text = stringResource(R.string.register_by_name_info),
                style = Typography.bodyMedium,
                color = DarkGrey)
        }
        Column {
            Text(
                text = stringResource(R.string.input_family_name_label),
                color = Placeholer,
                style = Typography.bodySmall
            )
            TextFieldComponent(
                    name = name,
                    onValueChange = {name = it},
                    placeholder = stringResource(R.string.input_family_name),
                    bgColor = if(name.text.isEmpty()){
                        Color(0xFFF9F9F9)
                    } else {
                        LightYellow
                    },
                    borderColor = if(name.text.isEmpty()){
                        InputBoxOutline
                    } else {
                        Yellow
                    }
                )
            InputException(text = stringResource(R.string.input_family_name_exception))
        }
        Spacer(modifier = Modifier.fillMaxHeight(0.3f))
        Column(modifier = Modifier.padding(bottom = 30.dp)) {
            TextButtonComponent(
                text = stringResource(R.string.make),
                colors = if (name.text.isEmpty()) {
                    ButtonDefaults.textButtonColors(LightGrey)
                } else{
                    ButtonDefaults.textButtonColors(Orange)
                },
                style = TextStyle(
                    fontFamily = NotoSansKR,
                    fontWeight = FontWeight.W500,
                    fontSize = 15.sp,
                    lineHeight = 20.sp,
                    color = ButtonContent,
                    platformStyle = PlatformTextStyle(includeFontPadding = false) //폰트 패딩을 제거해주지 않으면 텍스트가 잘림
                )
            ) {}
        }
    }
}

@Composable
fun InputException(text : String){
    Text(
        modifier = Modifier.padding(vertical = 8.dp) ,
        text = text,
        color = Placeholer,
        style = Typography.titleSmall
    )
}