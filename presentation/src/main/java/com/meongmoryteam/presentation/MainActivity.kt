package com.meongmoryteam.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.meongmoryteam.presentation.ui.theme.MeongmoryTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MeongmoryTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(
    name: String,
    modifier: Modifier = Modifier,
    viewModel: ExampleViewModel = hiltViewModel(),
) {
    LaunchedEffect(Unit) {
        viewModel.getWeekFood("MCC식당")
    }

    val weekFoodState by viewModel.weekGetFoodArea.collectAsState()

    when (weekFoodState) {
        is ExampleFoodState.UnInitialized -> {

        }

        is ExampleFoodState.Loading -> {

        }

        is ExampleFoodState.SuccessWeekFoodGetData -> {
            val data =
                (weekFoodState as ExampleFoodState.SuccessWeekFoodGetData).getWeekFoodData
            Log.d("clean architecture test url success", "$data")
        }

        is ExampleFoodState.Error -> {
            Log.d("clean architecture test url error", "error")
        }
    }

    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MeongmoryTheme {
        Greeting("Android")
    }
}