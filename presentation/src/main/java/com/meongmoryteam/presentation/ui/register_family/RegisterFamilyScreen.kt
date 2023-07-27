package com.meongmoryteam.presentation.ui.register_family

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.meongmoryteam.presentation.ui.theme.ButtonContent
import com.meongmoryteam.presentation.ui.theme.Typography
import androidx.navigation.NavController
import com.meongmoryteam.presentation.R
import com.meongmoryteam.presentation.ui.theme.Brown
import com.meongmoryteam.presentation.ui.theme.DarkGrey
import com.meongmoryteam.presentation.ui.theme.Orange

@Composable
fun RegisterFamilyScreen(navController: NavController) {
    RegisterDogForm(navController = navController) {
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
                onClick = {navController.navigate(RouteScreen.Name.route)},
                text = stringResource(id = R.string.go_to_name_btn),
                colors = ButtonDefaults.textButtonColors(containerColor = Orange, contentColor = ButtonContent),
                style = Typography.labelMedium)
            TextButtonComponent(
                onClick = {navController.navigate(RouteScreen.Code.route)},
                text = stringResource(id = R.string.go_to_code_btn),
                colors = ButtonDefaults.textButtonColors(containerColor = Brown, contentColor = ButtonContent),
                style = Typography.labelMedium)
        }
    }
}
