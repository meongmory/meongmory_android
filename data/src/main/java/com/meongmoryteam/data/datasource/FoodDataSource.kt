package com.meongmoryteam.data.datasource

import com.meongmoryteam.data.model.WeekFoodResponse

interface FoodDataSource {

    suspend fun weekGetFoodArea(s: String): Result<WeekFoodResponse>
}