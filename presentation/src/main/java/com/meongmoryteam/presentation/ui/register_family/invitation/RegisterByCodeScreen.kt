package com.meongmoryteam.presentation.ui.register_family.invitation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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
import com.meongmoryteam.presentation.ui.theme.AppleSD
import com.meongmoryteam.presentation.ui.theme.Black
import com.meongmoryteam.presentation.ui.theme.ButtonContent
import com.meongmoryteam.presentation.ui.theme.DarkGrey
import com.meongmoryteam.presentation.ui.theme.Error
import com.meongmoryteam.presentation.ui.theme.InputBoxOutline
import com.meongmoryteam.presentation.ui.theme.LightGrey
import com.meongmoryteam.presentation.ui.theme.LightYellow
import com.meongmoryteam.presentation.ui.theme.NotoSansKR
import com.meongmoryteam.presentation.ui.theme.Orange
import com.meongmoryteam.presentation.ui.theme.Typography
import com.meongmoryteam.presentation.ui.theme.Yellow

@Composable
fun RegisterByCodeScreen(navController: NavController) {
    var name by remember{ mutableStateOf(TextFieldValue("")) }
    var enabled by remember{ mutableStateOf(false) }

    RegisterDogForm(navController = navController) {
        Column {
            TextComponent(text = stringResource(id = R.string.register_by_code_title), style = Typography.titleLarge, modifier = Modifier.padding(bottom = 20.dp), color = Black)
            TextComponent(text = stringResource(id = R.string.register_by_code_info), style = Typography.titleSmall, color = DarkGrey)
        }
        Column {
            Row(verticalAlignment = Alignment.CenterVertically){
                TextFieldComponent(
                    name = name,
                    onValueChange = {name = it},
                    placeholder = stringResource(id = R.string.code_placeholder),
                    width = 0.7f,
                    bgColor = if(name.text.isEmpty()){Color(0xFFF9F9F9)} else {LightYellow},
                    borderColor =  if(name.text.isEmpty()){InputBoxOutline} else {Yellow}
                )
                Spacer(modifier = Modifier.fillMaxWidth(0.1f))
                TextButtonComponent(
                    onClick = {},
                    text = stringResource(id = R.string.check),
                    colors = if (name.text.isEmpty()) {ButtonDefaults.textButtonColors(LightGrey)} else{ButtonDefaults.textButtonColors(Orange)}, style = TextStyle(fontFamily = AppleSD, fontWeight = FontWeight.W400, fontSize = 13.sp, lineHeight = 20.sp, color = ButtonContent, platformStyle = PlatformTextStyle(includeFontPadding = false)), width = 1f,)

            }
            checkValidCode(name = name, enabled = enabled) { enabled = !enabled }
        }
        Spacer(modifier = Modifier.fillMaxHeight(0.3f))
        Column(modifier = Modifier.padding(bottom = 30.dp)) {
            TextButtonComponent(
                onClick = {},
                text = stringResource(id = R.string.next),
                colors = if (name.text.isEmpty()) {ButtonDefaults.textButtonColors(LightGrey)} else{ButtonDefaults.textButtonColors(Orange)}, style = TextStyle(fontFamily = NotoSansKR, fontWeight = FontWeight.W500, fontSize = 15.sp, lineHeight = 20.sp, color = ButtonContent, platformStyle = PlatformTextStyle(includeFontPadding = false)))
        }
    }
}

@Composable
fun checkValidCode(name: TextFieldValue, enabled: Boolean, onChangeState: (Boolean)->Unit){
    //우선 텍스트가 입력되지 않은 경우 경고 메시지가 뜨도록 설정
    if (name.text.isEmpty()){
        Text(
            modifier = Modifier.padding(vertical = 5.dp) ,
            text = stringResource(id = R.string.not_valid_code), color = Error, style = Typography.titleSmall)
    }
}
