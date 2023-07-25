package com.meongmoryteam.presentation.ui.register_family

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.meongmoryteam.presentation.ui.theme.ButtonContent
import com.meongmoryteam.presentation.ui.theme.MeongmoryTheme
import com.meongmoryteam.presentation.ui.theme.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.meongmoryteam.presentation.R
import com.meongmoryteam.presentation.ui.theme.Brown
import com.meongmoryteam.presentation.ui.theme.DarkGrey
import com.meongmoryteam.presentation.ui.theme.Orange

@Composable
fun RegisterDogScreen(){
    RegisterDogForm {
        Column() {
            Row {
                TextComponent(
                    text = stringResource(id = R.string.register_family_welcome),
                    style = Typography.titleLarge,
                    modifier = Modifier.padding(bottom = 15.dp),
                    color = Orange)
                TextComponent(
                    text = "ooo님!",
                    style = Typography.titleLarge,
                    modifier = Modifier.padding(bottom = 15.dp),
                    color = Brown)
            }
            TextComponent(
                text = stringResource(id = R.string.register_family_info),
                style = Typography.titleMedium,
                color = DarkGrey)
        }
        Column(modifier = Modifier.padding(bottom = 30.dp)) {
            TextButtonComponent(
                onClick = {},
                text = stringResource(id = R.string.go_to_name_btn),
                colors = ButtonDefaults.textButtonColors(containerColor = Orange, contentColor = ButtonContent),
                style = Typography.labelMedium)
            TextButtonComponent(
                onClick = {},
                text = stringResource(id = R.string.go_to_code_btn),
                colors = ButtonDefaults.textButtonColors(containerColor = Brown, contentColor = ButtonContent),
                style = Typography.labelMedium)
        }
    }
}

@Composable
fun TextComponent(text: String, style: TextStyle, modifier: Modifier = Modifier, color: Color){
    Text(
        text = text,
        style = style,
        modifier = modifier,
        color = color)
}

@Composable
fun TextButtonComponent(onClick: ()->Unit, text: String, colors: ButtonColors, style: TextStyle, width: Float = 1f){
    TextButton(
        onClick = {},
        shape = RoundedCornerShape(10.dp),
        modifier= Modifier
            .fillMaxWidth(width)
            .height(50.dp)
            .padding(vertical = 5.dp),
        colors = colors,
    )
    {
        Text(
            text = text,
            style = style,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(vertical = 0.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MeongmoryTheme {
        RegisterDogScreen()
    }
}