package com.meongmoryteam.presentation.ui.map

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.meongmoryteam.presentation.ui.theme.MeongmoryTheme

@Composable
fun MapScreen() {
    Text(
        text = "MapScreen",
    )
}

@Preview(showBackground = true)

@Composable
fun MapScreenPreview() {
    MeongmoryTheme {
        MapScreen()
    }
}