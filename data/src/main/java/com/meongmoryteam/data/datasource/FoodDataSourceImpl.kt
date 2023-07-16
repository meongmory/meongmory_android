package com.meongmoryteam.data.datasource

import com.meongmoryteam.data.model.toWeekFoodEntity
import com.meongmoryteam.data.service.ExampleApi
import com.meongmoryteam.domain.model.ResponseWeekFoodEntity
import com.meongmoryteam.domain.model.Result
import javax.inject.Inject

class FoodDataSourceImpl @Inject constructor(
    private val exampleApi: ExampleApi
) : FoodDataSource {
    override suspend fun weekGetFoodArea(s: String): Result<ResponseWeekFoodEntity> {
        val response = exampleApi.weekGetFoodArea(s)
        return try {
            if (response.isSuccessful) {
                response.body()?.let { data ->
                    return Result.Success(data.toWeekFoodEntity())
                } ?: Result.Error(404)
            } else {
                Result.Error(response.code())
            }
        } catch (e: Exception) {
            Result.Error(response.code())
        }
    }
}