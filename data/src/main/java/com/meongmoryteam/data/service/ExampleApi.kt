package com.meongmoryteam.data.service

import com.meongmoryteam.data.model.WeekFoodResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ExampleApi {

    @GET("/api/v2/meals/week/{area}")
    suspend fun weekGetFoodArea(
        @Path("area") area: String
    ): Response<WeekFoodResponse>
}