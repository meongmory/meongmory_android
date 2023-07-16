package com.meongmoryteam.presentation

import com.meongmoryteam.domain.model.ResponseWeekFoodEntity

sealed class ExampleFoodState {
    object UnInitialized : ExampleFoodState()

    object Loading : ExampleFoodState()

    data class SuccessWeekFoodGetData(val getWeekFoodData: ResponseWeekFoodEntity) : ExampleFoodState()

    data class Error(val errorCode: Int) : ExampleFoodState()
}