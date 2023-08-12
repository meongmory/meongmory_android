package com.meongmoryteam.presentation.ui.register_dog

import androidx.compose.foundation.ExperimentalFoundationApi
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
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.relocation.bringIntoViewRequester
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.meongmoryteam.presentation.R
import com.meongmoryteam.presentation.base.TextButtonComponent
import com.meongmoryteam.presentation.base.TextComponent
import com.meongmoryteam.presentation.base.TextFieldComponent
import com.meongmoryteam.presentation.ui.register_dog.RegisterDogContract.RegisterDogEvent
import com.meongmoryteam.presentation.ui.register_dog.RegisterDogContract.RegisterDogSideEffect
import com.meongmoryteam.presentation.ui.register_family.RegisterDogForm
import com.meongmoryteam.presentation.ui.theme.Black
import com.meongmoryteam.presentation.ui.theme.ButtonContent
import com.meongmoryteam.presentation.ui.theme.InputBoxOutline
import com.meongmoryteam.presentation.ui.theme.LightGrey
import com.meongmoryteam.presentation.ui.theme.LightYellow
import com.meongmoryteam.presentation.ui.theme.NotoSansKR
import com.meongmoryteam.presentation.ui.theme.Orange
import com.meongmoryteam.presentation.ui.theme.Placeholer
import com.meongmoryteam.presentation.ui.theme.QuestionEditFill
import com.meongmoryteam.presentation.ui.theme.Typography
import com.meongmoryteam.presentation.ui.theme.Yellow
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RegisterDogScreen(
    navController: NavController,
    viewModel: RegisterDogViewModel = hiltViewModel(),
    navigateToSearchBreedScreen: () -> Unit,
    navigateToPreviousScreen: () -> Unit,
    navigateToMakeScreen: () -> Unit,
    searchBreed: String
) {
    val viewState by viewModel.viewState.collectAsState()
    val buttonItemList = listOf("수컷", "암컷")
    val coroutineScope = rememberCoroutineScope()
    val focusManager = LocalFocusManager.current
    val bringIntoViewRequester = BringIntoViewRequester()
    val scrollState = rememberScrollState()

    RegisterDogForm(
        bottomPadding = 0.dp,
        navController = navController, modifier = Modifier.verticalScroll(state = scrollState),
        navigateTo = { viewModel.setEvent(RegisterDogEvent.OnClickBackButton) }) {
        RenderProfile()
        RenderName(value = viewState.name) { viewModel.setEvent(RegisterDogEvent.FillInName(it)) }
        RenderBreed(value = searchBreed) { viewModel.setEvent(RegisterDogEvent.OnClickSearchButton) }
        RenderGender(
            label = R.string.gender,
            buttonItem = buttonItemList,
            value = viewState.gender
        ) { viewModel.setEvent(RegisterDogEvent.OnGenderClicked(it)) }
        RenderAge(value = viewState.age) { viewModel.setEvent(RegisterDogEvent.FillInAge(it)) }
        RenderAdoptionDate(
            year = viewState.year,
            month = viewState.month,
            day = viewState.day,
            { viewModel.setEvent(RegisterDogEvent.FillInYear(it)) },
            { viewModel.setEvent(RegisterDogEvent.FillInMonth(it)) },
            { viewModel.setEvent(RegisterDogEvent.FillInDay(it)) },
        )
        RenderPetRegistrationNumber(
            value = viewState.registrationNumber,
            coroutineScope = coroutineScope,
            bringIntoViewRequester = bringIntoViewRequester,
            focusManager = focusManager
        ) {
            viewModel.setEvent(
                RegisterDogEvent.FillInRegistrationNum(it)
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        RenderRegisterButton(
            isAllFilled = viewState.isAllFilled,
            bringIntoViewRequester = bringIntoViewRequester
        ) {
            viewModel.setEvent(RegisterDogEvent.OnClickMakeButton)
        }
    }

    LaunchedEffect(key1 = viewModel.effect) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is RegisterDogSideEffect.NavigateToSearchBreedScreen -> {
                    navigateToSearchBreedScreen()
                }

                is RegisterDogSideEffect.NavigateToNextScreen -> {
                    navigateToMakeScreen()
                }

                is RegisterDogSideEffect.NavigateToPreviousScreen -> {
                    navigateToPreviousScreen()
                }

                is RegisterDogSideEffect.NavigateToRegisterScreen -> {}
            }
        }
    }
}

@Composable
fun RenderProfile() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            imageVector = ImageVector.vectorResource(R.drawable.default_profile_img),
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
fun RenderBreed(value: String, navigateToSearch: () -> Unit) {
    Box(contentAlignment = Alignment.CenterEnd) {
        val bgColor = if (value.isEmpty()) {
            QuestionEditFill
        } else {
            LightYellow
        }
        val borderColor = if (value.isEmpty()) {
            InputBoxOutline
        } else {
            Yellow
        }
        Column(modifier = Modifier.padding(bottom = 14.dp)) {
            TextComponent(
                text = stringResource(R.string.breed),
                style = Typography.titleSmall,
                color = Placeholer,
                modifier = Modifier.padding(bottom = 12.dp)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(43.dp)
                    .background(bgColor)
                    .border(width = 1.dp, color = borderColor, shape = RoundedCornerShape(10.dp))
                    .padding(horizontal = 15.dp, vertical = 14.dp)
            ) {
                TextComponent(
                    text = stringResource(R.string.breed),
                    style = Typography.titleSmall,
                    color = Placeholer,
                    modifier = Modifier.padding(bottom = 12.dp)
                )
                Text(
                    text = value.ifEmpty { stringResource(R.string.breed) },
                    style = Typography.titleSmall,
                    color = if (value.isEmpty()) Placeholer else Black,
                    maxLines = 1
                )
            }
        }

        SearchButton(padding = 15.dp, navigateToSearch)
    }
}

@Composable
fun RenderGender(
    label: Int,
    buttonItem: List<String>,
    value: String,
    onValueChange: (String) -> Unit
) {
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
                    isSelected = value == item,
                )
                {
                    onValueChange(item)
                }
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

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RenderPetRegistrationNumber(
    value: String,
    coroutineScope: CoroutineScope,
    bringIntoViewRequester: BringIntoViewRequester,
    focusManager: FocusManager,
    onValueChange: (String) -> Unit
) {
    LabelNInputForm(
        label = R.string.pet_registration_number,
        placeholder = R.string.pet_registration_number,
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier
            .fillMaxWidth()
            .onFocusEvent { event ->
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
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RenderRegisterButton(
    isAllFilled: Boolean,
    bringIntoViewRequester: BringIntoViewRequester,
    navigateTo: () -> Unit
) {
    TextButtonComponent(
        text = stringResource(R.string.make),
        colors = if (!isAllFilled) {
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
        onClick = navigateTo
    )
}

@Composable
fun LabelNInputForm(
    label: Int,
    placeholder: Int,
    value: String,
    modifier: Modifier = Modifier.fillMaxWidth(),
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
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
    }
}

@Composable
fun SearchButton(padding: Dp = 0.dp, navigateToSearch: () -> Unit) {
    IconButton(
        onClick = navigateToSearch,
        modifier = Modifier
            .size(45.dp)
            .padding(top = padding)
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.search_btn),
            contentDescription = stringResource(R.string.search),
            modifier = Modifier.size(20.dp)
        )
    }
}

@Composable
fun GenderButton(
    item: String,
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
            text = item,
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
                            QuestionEditFill
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
