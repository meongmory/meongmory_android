package com.meongmoryteam.data.service.family

import com.meongmoryteam.data.model.request.family.RegisterFamilyCodeRequest
import com.meongmoryteam.data.model.request.family.RegisterFamilyNameRequest
import com.meongmoryteam.data.model.response.family.PostRegisterFamilyCodeRes
import com.meongmoryteam.data.model.response.family.PostRegisterFamilyNameRes
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

interface FamilyApi {
    @POST("families")
    suspend fun postRegisterFamilyCode(
        @Body registerFamilyCodeRequest: RegisterFamilyCodeRequest
    ): PostRegisterFamilyCodeRes

    @POST("families/{familyId}/invite")
    suspend fun postRegisterFamilyName(
        @Path(value = "familyId") familyId: String,
        @Body registerFamilyNameRequest: RegisterFamilyNameRequest
    ): PostRegisterFamilyNameRes
}