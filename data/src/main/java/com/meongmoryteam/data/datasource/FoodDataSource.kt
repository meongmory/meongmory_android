package com.meongmoryteam.data.datasource

import com.meongmoryteam.domain.model.ResponseWeekFoodEntity
import com.meongmoryteam.domain.model.Result

interface FoodDataSource {

    suspend fun weekGetFoodArea(s: String): Result<ResponseWeekFoodEntity>
}