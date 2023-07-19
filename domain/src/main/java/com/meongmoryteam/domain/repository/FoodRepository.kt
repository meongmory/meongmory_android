package com.meongmoryteam.domain.repository

import com.meongmoryteam.domain.model.ResponseWeekFoodEntity

interface FoodRepository {
    suspend fun weekFood(area: String): Result<ResponseWeekFoodEntity>
}