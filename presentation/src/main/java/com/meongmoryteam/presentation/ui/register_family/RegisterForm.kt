package com.meongmoryteam.presentation.ui.register_family

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.meongmoryteam.presentation.R
import com.meongmoryteam.presentation.ui.theme.Typography
import com.meongmoryteam.presentation.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterDogForm(
    bottomPadding: Dp = 65.dp,
    navController: NavController,
    navigateTo: () -> Unit = { navController.navigate(RouteScreen.Choose.route) },
    title: String = "",
    verticalArrangement: Arrangement.Vertical = Arrangement.SpaceBetween,
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    Scaffold(
        modifier = Modifier.padding(horizontal = 6.dp),
        containerColor = White,
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = title, style = Typography.titleMedium) },
                modifier = Modifier.padding(top = 15.dp, bottom = bottomPadding),
                colors = TopAppBarDefaults.topAppBarColors(White),
                navigationIcon = {
                    IconButton(
                        onClick = navigateTo,
                        modifier = Modifier.size(30.dp)
                    )
                    {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.close),
                            modifier = Modifier.size(30.dp)
                        )
                    }
                }
            )
        },
    ) {
        Surface(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
        ) {
            Box(
                modifier = Modifier
                    .background(White)
                    .padding(horizontal = 10.dp),
            ) {
                Column(
                    verticalArrangement = verticalArrangement,
                    modifier = modifier
                        .fillMaxHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    content()
                }
            }
        }
    }
}


