package com.meongmoryteam.presentation.ui.map

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.meongmoryteam.presentation.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommonScaffold(
    modifier: Modifier = Modifier,
    navigationIcon: @Composable () -> Unit = {},
    title: @Composable () -> Unit,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
        topBar = {
            CommonTopAppBar(
                navigationIcon = navigationIcon,
                title = title
            )
        },
        content = content
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommonTopAppBar(
    navigationIcon: @Composable () -> Unit = {},
    title: @Composable () -> Unit
) {
    Card(
        modifier = Modifier.padding(8.dp),
    ) {
        TopAppBar(
            navigationIcon = navigationIcon,
            title = title
        )
    }
}

@Composable
fun CloseButton(onClick: () -> Unit) {
    IconButton(onClick) {
        Image(
            imageVector = Icons.Default.Close,
            contentDescription = stringResource(R.string.close))
    }
}

@Composable
fun BackButton(onClick: () -> Unit) {
    IconButton(onClick) {
        Image(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = stringResource(R.string.profile_back_btn_description))
    }
}

@Composable
fun SearchButton(isEnabled: Boolean = true, onClick: () -> Unit) {
    IconButton(onClick, enabled = isEnabled) {
        Image(
            imageVector = Icons.Default.Search,
            contentDescription = stringResource(R.string.search))
    }
}

@Composable
fun SearchImage() {
    SearchButton(onClick = {}, isEnabled = false)
}