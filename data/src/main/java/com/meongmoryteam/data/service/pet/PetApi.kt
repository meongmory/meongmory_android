package com.meongmoryteam.data.service.pet

import com.meongmoryteam.data.model.request.pet.RegisterPetRequest
import com.meongmoryteam.data.model.response.pet.PostRegisterPetResponse
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface PetApi {
    //추후 userId, isLogin 쿼리 추가
    @POST("families/{familyId}")
    suspend fun postRegisterPet(
        @Path(value = "familyId") familyId: String,
        @Body registerPetRequest: RegisterPetRequest,
    ): PostRegisterPetResponse
}