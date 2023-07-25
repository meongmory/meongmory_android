package com.meongmoryteam.presentation.ui.register_dog

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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.meongmoryteam.presentation.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterDogForm(content: @Composable ColumnScope.() -> Unit){
    Scaffold(
        modifier = Modifier.padding(horizontal = 15.dp),
        topBar = {
            TopAppBar(
                title = { Text("") },
                modifier = Modifier.padding(top = 15.dp, bottom = 65.dp),
                navigationIcon = {
                    IconButton(onClick = {}, modifier = Modifier.size(30.dp)) {
                        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "닫기", modifier = Modifier.size(30.dp)
                        )
                    }
                }
            )
        },
    ) {
        Surface(modifier = Modifier.padding(it).fillMaxSize()) {
            Box(modifier = Modifier.background(White).padding(horizontal = 15.dp),) {
                Column(
                    verticalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxHeight()
                ) {
                    content()
                }
            }
        }
    }
}