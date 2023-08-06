@file:OptIn(ExperimentalFoundationApi::class)

package com.meongmoryteam.presentation.ui.register_dog

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.relocation.bringIntoViewRequester
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.meongmoryteam.presentation.R
import com.meongmoryteam.presentation.ui.register_dog.RegisterDogContract.RegisterDogEvent
import com.meongmoryteam.presentation.ui.register_dog.RegisterDogContract.RegisterDogSideEffect
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
import com.meongmoryteam.presentation.ui.theme.QuestionEditFill
import com.meongmoryteam.presentation.ui.theme.Yellow

@Composable
fun SearchBreedScreen(
    navController: NavController,
    viewModel: RegisterDogViewModel = hiltViewModel(),
    navigateToPreviousScreen: () -> Unit,
    navigateToSelectScreen: () -> Unit
) {
    val buttonItemList = listOf("강아지", "고양이")
    val searchList = listOf(Breed("말티즈", "강아지"), Breed("말티즈", "고양이"), Breed("푸들", "강아지"), Breed("푸들", "고양이"), )
    val viewState by viewModel.viewState.collectAsState()
    val coroutineScope = rememberCoroutineScope()
    val focusManager = LocalFocusManager.current
    val bringIntoViewRequester = BringIntoViewRequester()

    RegisterDogForm(
        navController = navController,
        title = stringResource(R.string.search_breed),
        bottomPadding = 20.dp,
        verticalArrangement = Arrangement.Top,
        navigateTo = { viewModel.setEvent(RegisterDogEvent.OnClickBackButton) }
    ) {
        CategoryScreen(
            buttonItem = buttonItemList,
            petType = viewState.petType
        ) { viewModel.setEvent(RegisterDogEvent.OnPetTypeClicked(it)) }
        SearchScreen(
            value = viewState.breed,
            onValueChange = {
                viewModel.setEvent(
                    RegisterDogEvent.FillInBreed(it)
                )
            },
            navigateToSearch = { viewModel.setEvent(RegisterDogEvent.OnClickSearchButton) }
        )
        SearchList(searchList = searchList)
        RenderSelectButton(
            isSelected = viewState.isSelected,
            bringIntoViewRequester = bringIntoViewRequester
        ) {
            viewModel.setEvent(RegisterDogEvent.OnClickMakeButton)
        }
    }

    LaunchedEffect(key1 = viewModel.effect) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is RegisterDogSideEffect.NavigateToPreviousScreen -> {
                    navigateToPreviousScreen()
                }

                is RegisterDogSideEffect.NavigateToSearchBreedScreen -> {}
                is RegisterDogSideEffect.NavigateToNextScreen -> {
                    navigateToSelectScreen()
                }
            }
        }
    }
}

//
@Composable
fun CategoryScreen(
    buttonItem: List<String>,
    petType: String,
    onValueChange: (String) -> Unit
) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        items(buttonItem) { item ->
            GenderButton(
                item = item,
                isSelected = petType == item,
            )
            {
                onValueChange(item)
            }
        }
    }
}

@Composable
fun SearchScreen(
    value: String,
    modifier: Modifier = Modifier.fillMaxWidth(),
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    onValueChange: (String) -> Unit,
    navigateToSearch: () -> Unit
) {
    Box(contentAlignment = Alignment.CenterEnd) {
        TextFieldComponent(
            name = value,
            onValueChange = onValueChange,
            placeholder = stringResource(R.string.blank),
            bgColor = if (value.isEmpty()) {
                QuestionEditFill
            } else {
                LightYellow
            },
            borderColor = if (value.isEmpty()) {
                InputBoxOutline
            } else {
                Yellow
            },
            modifier = modifier,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions
        )
        SearchButton { navigateToSearch }
    }
}

@Composable
fun SearchList(
    searchList: List<Breed>
){
    LazyColumn(
        modifier = Modifier.background(Black).fillMaxWidth().fillMaxHeight(0.85f)
    ){
        items(searchList) { item ->

        }
    }
}

@Composable
fun RenderSelectButton(
    isSelected: Boolean,
    bringIntoViewRequester: BringIntoViewRequester,
    navigateTo: () -> Unit
) {
    TextButtonComponent(
        text = stringResource(R.string.select),
        colors = if (!isSelected) {
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
        ),
        modifier = Modifier
            .bringIntoViewRequester(bringIntoViewRequester)
            .padding(bottom = 30.dp),
        onClick = {
            if(isSelected) navigateTo else {}
        }
    )
}

data class Breed(
    val breed: String,
    val category: String
)