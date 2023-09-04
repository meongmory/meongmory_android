@file:OptIn(ExperimentalFoundationApi::class)

package com.meongmoryteam.presentation.ui.register_dog

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.relocation.bringIntoViewRequester
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.meongmoryteam.domain.model.response.pet.SearchBreedResponse
import com.meongmoryteam.presentation.R
import com.meongmoryteam.presentation.base.TextButtonComponent
import com.meongmoryteam.presentation.base.TextFieldComponent
import com.meongmoryteam.presentation.ui.register_dog.RegisterDogContract.RegisterDogEvent
import com.meongmoryteam.presentation.ui.register_dog.RegisterDogContract.RegisterDogSideEffect
import com.meongmoryteam.presentation.ui.register_family.RegisterDogForm
import com.meongmoryteam.presentation.ui.theme.Black
import com.meongmoryteam.presentation.ui.theme.ButtonContent
import com.meongmoryteam.presentation.ui.theme.DarkGrey
import com.meongmoryteam.presentation.ui.theme.DeepYellow
import com.meongmoryteam.presentation.ui.theme.EditDivider
import com.meongmoryteam.presentation.ui.theme.InputBoxOutline
import com.meongmoryteam.presentation.ui.theme.LightGrey
import com.meongmoryteam.presentation.ui.theme.LightYellow
import com.meongmoryteam.presentation.ui.theme.NotoSansKR
import com.meongmoryteam.presentation.ui.theme.Orange
import com.meongmoryteam.presentation.ui.theme.QuestionEditFill
import com.meongmoryteam.presentation.ui.theme.Typography
import com.meongmoryteam.presentation.ui.theme.Yellow
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SearchBreedScreen(
    navController: NavController,
    viewModel: RegisterDogViewModel = hiltViewModel(),
    navigateToPreviousScreen: () -> Unit,
//    navigateToRegisterScreen: () -> Unit
) {
    val buttonItemList =
        listOf(stringResource(R.string.dog_icon), stringResource(R.string.cat_icon))
    viewModel.setEvent(RegisterDogEvent.InitList)

    val viewState by viewModel.viewState.collectAsState()
    val coroutineScope = rememberCoroutineScope()
    val focusManager = LocalFocusManager.current
    val bringIntoViewRequester = BringIntoViewRequester()

    val searchList = viewState.content
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
            coroutineScope = coroutineScope,
            bringIntoViewRequester = bringIntoViewRequester,
            focusManager = focusManager,
            onValueChange = {
                viewModel.setEvent(
                    RegisterDogEvent.FillInBreed(it)
                )
            },
            navigateToSearch = { viewModel.setEvent(RegisterDogEvent.OnClickSearchButton) }
        )
        SearchList(
            searchList = searchList,
            category = viewState.petType,
            breed = viewState.breed,
            onValueChange = { viewModel.setEvent(RegisterDogEvent.OnBreedClicked(it)) },
            setID = { viewModel.setEvent(RegisterDogEvent.SetAnimalID(it)) }
        )
        RenderSelectButton(
            isSelected = viewState.isSelected,
            breed = viewState.breed,
            bringIntoViewRequester = bringIntoViewRequester,
            navigateTo = {
                viewModel.setEvent(
                    RegisterDogEvent.OnClickSelectButton(
                        viewState.breed,
                        viewState.animalId
                    )
                )
            }
        )
    }

    LaunchedEffect(key1 = viewModel.effect) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is RegisterDogSideEffect.NavigateToPreviousScreen -> {
                    navigateToPreviousScreen()
                }

                is RegisterDogSideEffect.NavigateToSearchBreedScreen -> {}
                is RegisterDogSideEffect.NavigateToRegisterScreen -> {
                    navController.navigate(Route.RegisterDog.route.plus("/${effect.breed}/${effect.animalId}"))
                }

                is RegisterDogSideEffect.NavigateToNextScreen -> {}
            }
        }
    }
}

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
    coroutineScope: CoroutineScope,
    bringIntoViewRequester: BringIntoViewRequester,
    focusManager: FocusManager,
    onValueChange: (String) -> Unit,
    navigateToSearch: () -> Unit
) {
    Box(contentAlignment = Alignment.CenterEnd, modifier = modifier.padding(bottom = 30.dp)) {
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
            modifier = modifier.onFocusEvent { event ->
                if (event.isFocused) {
                    coroutineScope.launch {
                        bringIntoViewRequester.bringIntoView()
                    }
                }
            },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(
                onDone = { focusManager.clearFocus() }
            )
        )
        SearchButton { navigateToSearch }
    }
}

@Composable
fun SearchList(
    searchList: List<SearchBreedResponse>,
    category: String,
    breed: String,
    onValueChange: (String) -> Unit,
    setID: (Int) -> Unit
) {
    Log.d("search", "$searchList")
    val lazyList = if (category == stringResource(R.string.blank)) searchList else selectLogic(
        searchList = searchList,
        category = category
    )
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.85f)
    ) {
        items(lazyList) { item ->
            val tint = if (item.animalName == breed) DeepYellow else EditDivider
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row {
                    val imageVector =
                        if (item.animalType == stringResource(R.string.dog_icon)) R.drawable.dog else R.drawable.cat
                    Icon(
                        modifier = Modifier.padding(horizontal = 5.dp),
                        imageVector = ImageVector.vectorResource(imageVector),
                        contentDescription = stringResource(
                            id = R.string.dog_icon
                        ),
                        tint = tint
                    )
                    Text(text = item.animalName, style = Typography.labelSmall, color = Black)
                    Text(
                        modifier = Modifier.padding(horizontal = 5.dp),
                        text = "[${item.animalType}]",
                        style = Typography.labelSmall,
                        color = DarkGrey
                    )
                }
                Box(
                    modifier = Modifier
                        .size(21.dp)
                        .background(color = Color.Transparent)
                ) {
                    IconButton(
                        onClick = {
                            onValueChange(item.animalName)
                            setID(item.animalId)
                        }
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.checkbox),
                            contentDescription = stringResource(R.string.unchecked_box),
                            tint = tint
                        )
                    }
                }
            }
            Divider(
                modifier = Modifier.padding(vertical = 15.dp),
                thickness = 1.dp,
                color = InputBoxOutline
            )
        }
    }
}

@Composable
fun RenderSelectButton(
    isSelected: Boolean,
    breed: String,
    bringIntoViewRequester: BringIntoViewRequester,
    navigateTo: (String) -> Unit
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
        onClick = { navigateTo(breed) }
    )
}

@Composable
fun selectLogic(
    searchList: List<SearchBreedResponse>,
    category: String
): MutableList<SearchBreedResponse> {
    val selectedList = mutableListOf<SearchBreedResponse>()

    for (item in searchList) {
        if (item.animalType == category) selectedList.add(item)

    }
    return selectedList
}
