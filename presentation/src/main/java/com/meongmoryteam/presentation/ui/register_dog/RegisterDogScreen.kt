package com.meongmoryteam.presentation.ui.register_dog

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.meongmoryteam.presentation.R
import com.meongmoryteam.presentation.ui.register_family.RegisterDogForm
import com.meongmoryteam.presentation.ui.register_family.TextButtonComponent
import com.meongmoryteam.presentation.ui.register_family.TextFieldComponent
import com.meongmoryteam.presentation.ui.theme.Black
import com.meongmoryteam.presentation.ui.theme.ButtonContent
import com.meongmoryteam.presentation.ui.theme.InputBoxOutline
import com.meongmoryteam.presentation.ui.theme.LightGrey
import com.meongmoryteam.presentation.ui.theme.LightYellow
import com.meongmoryteam.presentation.ui.theme.NotoSansKR
import com.meongmoryteam.presentation.ui.theme.Orange
import com.meongmoryteam.presentation.ui.theme.Placeholer
import com.meongmoryteam.presentation.ui.theme.Typography
import com.meongmoryteam.presentation.ui.theme.Yellow

@Composable
fun RegisterDogScreen(navController: NavController) {
    var name by remember { mutableStateOf("") }
    var breed by remember { mutableStateOf("") }
    val buttonItemList = listOf(ButtonItem(0, "수컷"), ButtonItem(1, "암컷"))
    var age by remember { mutableStateOf("") }
    var year by remember { mutableStateOf("") }
    var month by remember { mutableStateOf("") }
    var day by remember { mutableStateOf("") }
    var registrationNum by remember { mutableStateOf("") }

    RegisterDogForm(bottomPadding = 0.dp, navController = navController) {
        RenderProfile()
        RenderName(value = name) { name = it }
        RenderBreed(value = breed) { breed = it }
        RenderGender(label = R.string.gender, buttonItem = buttonItemList)
        RenderAge(value = age) { age = it }
        RenderAdoptionDate(
            year = year,
            month = month,
            day = day,
            { year = it },
            { month = it },
            { day = it },
        )
        RenderPetRegistrationNumber(value = registrationNum) { registrationNum = it }
        Spacer(modifier = Modifier.height(10.dp))
        RenderRegisterButton(value = registrationNum)
    }
}

@Composable
fun RenderProfile(painterResource: Int = R.drawable.default_profile) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(painterResource),
            contentDescription = stringResource(R.string.profile_img),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(90.dp)
                .clip(CircleShape)
        )
        Text(
            text = stringResource(R.string.profile_img),
            modifier = Modifier.padding(top = 10.dp, bottom = 30.dp)
        )
    }

}

@Composable
fun RenderName(value: String, onValueChange: (String) -> Unit) {
    LabelNInputForm(
        label = R.string.dog_name,
        placeholder = R.string.dog_name,
        value = value,
        onValueChange = onValueChange
    )
}

@Composable
fun RenderBreed(value: String, onValueChange: (String) -> Unit) {
    Box(contentAlignment = Alignment.BottomEnd) {
        LabelNInputForm(
            label = R.string.breed,
            placeholder = R.string.breed,
            value = value,
            onValueChange = onValueChange
        )
        SearchButton()
    }
}

@Composable
fun RenderGender(label: Int, buttonItem: List<ButtonItem>) {
    var selectedIndex by rememberSaveable { mutableStateOf(-1) }
    Column(
        modifier = Modifier
            .padding(bottom = 14.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(label),
            color = Placeholer,
            style = Typography.titleSmall,
            modifier = Modifier
                .padding(bottom = 12.dp)
                .fillMaxWidth()
        )
        LazyRow(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            items(buttonItem) { item ->
                GenderButton(
                    item = item,
                    isSelected = selectedIndex == item.index,
                    onTap = { selectedIndex = item.index }
                )
            }
        }
    }
}

@Composable
fun RenderAge(value: String, onValueChange: (String) -> Unit) {
    LabelNInputForm(
        label = R.string.age,
        placeholder = R.string.age,
        value = value,
        onValueChange = onValueChange
    )
}

@Composable
fun RenderAdoptionDate(
    year: String,
    month: String,
    day: String,
    onYearChange: (String) -> Unit,
    onMonthChange: (String) -> Unit,
    onDayChange: (String) -> Unit
) {
    DateInputForm(
        label = R.string.adoption_date,
        year = year,
        month = month,
        day = day,
        modifier = Modifier.width(70.dp),
        onYearChange = onYearChange,
        onMonthChange = onMonthChange,
        onDayChange = onDayChange
    )
}

@Composable
fun RenderPetRegistrationNumber(value: String, onValueChange: (String) -> Unit) {
    LabelNInputForm(
        label = R.string.pet_registration_number,
        placeholder = R.string.pet_registration_number,
        value = value,
        onValueChange = onValueChange
    )
}

@Composable
fun RenderRegisterButton(value: String) {
    TextButtonComponent(
        text = stringResource(R.string.make),
        colors = if (value.isEmpty()) {
            ButtonDefaults.textButtonColors(LightGrey)
        } else {
            ButtonDefaults.textButtonColors(Orange)
        },
        style = TextStyle(
            fontFamily = NotoSansKR,
            fontWeight = FontWeight.W500,
            fontSize = 15.sp,
            lineHeight = 20.sp,
            color = ButtonContent,
            platformStyle = PlatformTextStyle(includeFontPadding = false)
        )
    ) {}
}

@Composable
fun LabelNInputForm(
    label: Int,
    placeholder: Int,
    value: String,
    onValueChange: (String) -> Unit
) {
    Column(modifier = Modifier.padding(bottom = 14.dp)) {
        Text(
            text = stringResource(label),
            color = Placeholer,
            style = Typography.titleSmall,
            modifier = Modifier.padding(bottom = 12.dp)
        )
        TextFieldComponent(
            name = value,
            onValueChange = onValueChange,
            placeholder = stringResource(placeholder),
            bgColor = if (value.isEmpty()) {
                Color(0xFFF9F9F9)
            } else {
                LightYellow
            },
            borderColor = if (value.isEmpty()) {
                InputBoxOutline
            } else {
                Yellow
            },
        )
    }
}

@Composable
fun SearchButton() {
    IconButton(
        onClick = {},
        modifier = Modifier
            .size(45.dp)
            .padding(bottom = 25.dp)
    ) {
        Icon(
            painter = painterResource(R.drawable.search),
            contentDescription = stringResource(R.string.search),
            modifier = Modifier.size(20.dp)
        )
    }
}

@Composable
fun GenderButton(
    item: ButtonItem,
    isSelected: Boolean,
    modifier: Modifier = Modifier,
    onTap: () -> Unit
) {
    val backgroundColor =
        if (isSelected) LightYellow
        else Color(0xFFF9F9F9)
    val borderColor =
        if (isSelected) Yellow
        else InputBoxOutline
    val contentColor =
        if (isSelected) Black
        else Placeholer
    Box(
        modifier = modifier
            .width(170.dp)
            .border(
                width = 1.dp,
                color = borderColor,
                shape = RoundedCornerShape(10.dp)
            )
            .clip(shape = RoundedCornerShape(10.dp))
            .background(color = backgroundColor)
            .clickable { onTap() }
            .padding(horizontal = 15.dp, vertical = 14.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = item.label,
            color = contentColor,
            style = Typography.titleSmall,
        )
    }
}

@Composable
fun DateInputForm(
    label: Int,
    year: String,
    month: String,
    day: String,
    modifier: Modifier,
    onYearChange: (String) -> Unit,
    onMonthChange: (String) -> Unit,
    onDayChange: (String) -> Unit,
) {
    val itemList = listOf("년", "월", "일")
    val textValueList = listOf(year, month, day)
    val valueChangeList = listOf(onYearChange, onMonthChange, onDayChange)
    val placeholderList = listOf("yyyy", "mm", "dd")

    Column(
        modifier = Modifier
            .padding(bottom = 14.dp)
            .fillMaxWidth(),
    ) {
        Text(
            text = stringResource(label),
            color = Placeholer,
            style = Typography.titleSmall,
            modifier = Modifier
                .padding(bottom = 12.dp)
                .fillMaxWidth()
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            itemList.forEach {
                Row(
                    modifier = Modifier.width(100.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextFieldComponent(
                        name = textValueList[itemList.indexOf(it)],
                        onValueChange = valueChangeList[itemList.indexOf(it)],
                        placeholder = placeholderList[itemList.indexOf(it)],
                        bgColor = if (textValueList[itemList.indexOf(it)].isEmpty()) {
                            Color(0xFFF9F9F9)
                        } else {
                            LightYellow
                        },
                        borderColor = if (textValueList[itemList.indexOf(it)].isEmpty()) {
                            InputBoxOutline
                        } else {
                            Yellow
                        },
                        modifier = modifier
                    )
                    Text(
                        text = it,
                        color = Placeholer,
                        style = Typography.titleSmall,
                        modifier = Modifier.padding(horizontal = 8.dp),
                    )
                }
            }
        }
    }
}

data class ButtonItem(
    var index: Int,
    var label: String
)
