package com.meongmoryteam.domain.repository

import com.meongmoryteam.domain.model.ResponseWeekFoodEntity
import com.meongmoryteam.domain.model.Result

interface FoodRepository {
    suspend fun weekFood(area: String): Result<ResponseWeekFoodEntity>
}