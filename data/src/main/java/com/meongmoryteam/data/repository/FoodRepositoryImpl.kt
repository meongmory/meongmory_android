package com.meongmoryteam.data.repository

import com.meongmoryteam.data.datasource.FoodDataSource
import com.meongmoryteam.domain.model.ResponseWeekFoodEntity
import com.meongmoryteam.domain.repository.FoodRepository
import com.meongmoryteam.domain.model.Result
import javax.inject.Inject

class FoodRepositoryImpl @Inject constructor(
    private val foodDataSource: FoodDataSource
) : FoodRepository {

    override suspend fun weekFood(area: String): Result<ResponseWeekFoodEntity> {
        return foodDataSource.weekGetFoodArea(area)
    }
}