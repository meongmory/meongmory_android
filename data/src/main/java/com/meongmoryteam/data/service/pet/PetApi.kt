package com.meongmoryteam.data.service.pet

import com.meongmoryteam.data.model.request.pet.RegisterPetRequest
import com.meongmoryteam.data.model.response.pet.GetSearchBreedResponse
import com.meongmoryteam.data.model.response.pet.PostRegisterPetResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface PetApi {
    //추후 userId, isLogin 쿼리 추가
    @POST("families/{familyId}")
    suspend fun postRegisterPet(
        @Path(value = "familyId") familyId: Int,
        @Body registerPetRequest: RegisterPetRequest,
    ): PostRegisterPetResponse

    @GET("families/pet/kind")
    suspend fun getSearchBreed(
        @Query("page") page: Int?,
        @Query("searchword") searchword: String?,
        @Query("size") size: Int?,
        @Query("sort") sort: List<String>?,
        @Query("type") type: String?
    ): GetSearchBreedResponse
}