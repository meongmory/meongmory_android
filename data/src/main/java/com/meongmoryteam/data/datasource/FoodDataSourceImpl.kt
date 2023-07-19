package com.meongmoryteam.data.datasource

import com.meongmoryteam.data.model.WeekFoodResponse
import com.meongmoryteam.data.service.ExampleApi
import javax.inject.Inject

class FoodDataSourceImpl @Inject constructor(
    private val exampleApi: ExampleApi
) : FoodDataSource {
    override suspend fun weekGetFoodArea(s: String): Result<WeekFoodResponse> {
        return runCatching { exampleApi.weekGetFoodArea(s) }
    }
}