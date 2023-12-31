package com.meongmoryteam.presentation.base

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.meongmoryteam.presentation.ui.theme.AppleSD
import com.meongmoryteam.presentation.ui.theme.Black
import com.meongmoryteam.presentation.ui.theme.InputBoxOutline
import com.meongmoryteam.presentation.ui.theme.Placeholer
import com.meongmoryteam.presentation.ui.theme.QuestionButtonText
import com.meongmoryteam.presentation.ui.theme.Typography

@Composable
fun TextComponent(
    text: String,
    style: TextStyle,
    modifier: Modifier = Modifier,
    color: Color,
    maxLine: Int = 1
) {
    Text(
        text = text,
        style = style,
        modifier = modifier,
        color = color,
        maxLines = maxLine
    )
}

@Composable
fun TextButtonComponent(
    text: String,
    colors: ButtonColors,
    style: TextStyle,
    width: Float = 1f,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    TextButton(
        onClick = onClick,
        shape = RoundedCornerShape(10.dp),
        modifier = modifier
            .fillMaxWidth(width)
            .height(50.dp)
            .padding(vertical = 5.dp),
        colors = colors,
        enabled = enabled
    )
    {
        Text(
            text = text,
            style = style,
            textAlign = TextAlign.Center,
            color = QuestionButtonText
        )
    }
}

@Composable
fun TextFieldComponent(
    name: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    modifier: Modifier = Modifier.fillMaxWidth(),
    bgColor: Color = Color(0xFFF9F9F9),
    borderColor: Color = InputBoxOutline,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default
) {
    BasicTextField(
        value = name,
        onValueChange = onValueChange,
        modifier = Modifier.height(43.dp),
        singleLine = true,
        textStyle = TextStyle(
            color = Black,
            fontFamily = AppleSD,
            fontWeight = FontWeight.W400,
            fontSize = 12.sp,
            lineHeight = 20.sp
        ),
        decorationBox = {
            Box(
                modifier = modifier
                    .background(bgColor)
                    .border(width = 1.dp, color = borderColor, shape = RoundedCornerShape(10.dp))
                    .padding(horizontal = 15.dp, vertical = 14.dp)
            ) {
                if (name.isEmpty()) {
                    Text(text = placeholder, style = Typography.titleSmall, color = Placeholer)
                } else {
                    it()
                    Log.d("CHANGE", "change")
                }
            }
        },
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions
    )
}