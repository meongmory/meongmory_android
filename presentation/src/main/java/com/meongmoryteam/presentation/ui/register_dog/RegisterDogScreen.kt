package com.meongmoryteam.presentation.ui.register_dog

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.meongmoryteam.presentation.Greeting
import com.meongmoryteam.presentation.R
import com.meongmoryteam.presentation.ui.register_family.RegisterDogForm
import com.meongmoryteam.presentation.ui.register_family.TextButtonComponent
import com.meongmoryteam.presentation.ui.register_family.TextFieldComponent
import com.meongmoryteam.presentation.ui.register_family.name.InputException
import com.meongmoryteam.presentation.ui.theme.ButtonContent
import com.meongmoryteam.presentation.ui.theme.InputBoxOutline
import com.meongmoryteam.presentation.ui.theme.LightGrey
import com.meongmoryteam.presentation.ui.theme.LightYellow
import com.meongmoryteam.presentation.ui.theme.MeongmoryTheme
import com.meongmoryteam.presentation.ui.theme.NotoSansKR
import com.meongmoryteam.presentation.ui.theme.Orange
import com.meongmoryteam.presentation.ui.theme.Placeholer
import com.meongmoryteam.presentation.ui.theme.Typography
import com.meongmoryteam.presentation.ui.theme.Yellow

@Composable
fun RegisterDogScreen(navController: NavController){
    var name by remember{ mutableStateOf(TextFieldValue("")) }
    var breed by remember{ mutableStateOf(TextFieldValue("")) }
    var gender by remember{ mutableStateOf(TextFieldValue("")) }
    var age by remember{ mutableStateOf(TextFieldValue("")) }
    var adoptionDate by remember{ mutableStateOf(TextFieldValue("")) }
    var registrationNum by remember{ mutableStateOf(TextFieldValue("")) }

    var enabled by remember{ mutableStateOf(false) }

    RegisterDogForm(bottomPadding = 0.dp, navController = navController) {
        RenderProfile()
        RenderName(name = name){name = it}
        RenderBreed(name = breed){breed = it}
        RenderGender(name = gender){gender = it}
        RenderAge(name = age){age = it}
        RenderAdoptionDate(name = adoptionDate){adoptionDate = it}
        RenderPetRegistrationNumber(name = registrationNum){registrationNum = it}
        Spacer(modifier = Modifier.height(10.dp))
        RenderRegisterButton(name = registrationNum)
    }
}

@Composable
fun RenderProfile(painterResource: Int = R.drawable.default_profile){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,) {
        Image(painter = painterResource(painterResource),
            contentDescription = stringResource(R.string.profile_img),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(90.dp)
                .clip(CircleShape)
        )
        Text(text = stringResource(R.string.profile_img),
            modifier = Modifier.padding(top = 10.dp, bottom = 30.dp))
    }

}

@Composable
fun RenderName(name: TextFieldValue, onValueChange: (TextFieldValue) -> Unit){
    LabelNInputForm(label = R.string.dog_name, placeholder = R.string.dog_name, name = name, onValueChange = onValueChange)
}

@Composable
fun RenderBreed(name: TextFieldValue, onValueChange: (TextFieldValue) -> Unit){
    LabelNInputForm(label = R.string.breed, placeholder = R.string.dog_name, name = name, onValueChange = onValueChange)
}

@Composable
fun RenderGender(name: TextFieldValue, onValueChange: (TextFieldValue) -> Unit){
    LabelNInputForm(label = R.string.gender, placeholder = R.string.dog_name, name = name, onValueChange = onValueChange)
}

@Composable
fun RenderAge(name: TextFieldValue, onValueChange: (TextFieldValue) -> Unit){
    LabelNInputForm(label = R.string.age, placeholder = R.string.dog_name, name = name, onValueChange = onValueChange)
}

@Composable
fun RenderAdoptionDate(name: TextFieldValue, onValueChange: (TextFieldValue) -> Unit){
    LabelNInputForm(label = R.string.adoption_date, placeholder = R.string.dog_name, name = name, onValueChange = onValueChange)
}

@Composable
fun RenderPetRegistrationNumber(name: TextFieldValue, onValueChange: (TextFieldValue) -> Unit){
    LabelNInputForm(label = R.string.pet_registration_number, placeholder = R.string.dog_name, name = name, onValueChange = onValueChange)
}

@Composable
fun RenderRegisterButton(name: TextFieldValue){
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
            platformStyle = PlatformTextStyle(includeFontPadding = false)
        )
    ) {}
}

@Composable
fun LabelNInputForm(label: Int, placeholder: Int, name: TextFieldValue, width: Float = 1f, onValueChange:(TextFieldValue)->Unit){
    Column(modifier = Modifier.padding(bottom = 14.dp)) {
        Text(
            text = stringResource(label),
            color = Placeholer,
            style = Typography.titleSmall,
            modifier = Modifier.padding(bottom = 12.dp)
        )
        TextFieldComponent(
            name = name,
            onValueChange = onValueChange,
            placeholder = stringResource(placeholder),
            bgColor = if(name.text.isEmpty()){
                Color(0xFFF9F9F9)
            } else {
                LightYellow
            },
            borderColor = if(name.text.isEmpty()){
                InputBoxOutline
            } else {
                Yellow
            },
            width = width
        )
    }
}
