package com.meongmoryteam.data.datasource.family

import com.meongmoryteam.data.model.request.family.RegisterFamilyCodeRequest
import com.meongmoryteam.data.model.request.family.RegisterFamilyNameRequest
import com.meongmoryteam.data.model.response.family.PostRegisterFamilyCodeRes
import com.meongmoryteam.data.model.response.family.PostRegisterFamilyNameRes

interface FamilyDataSource {
    suspend fun registerFamilyWithCode(registerFamilyCodeReq: RegisterFamilyCodeRequest): Result<PostRegisterFamilyCodeRes>
    suspend fun registerFamilyWithName(familyId: String, registerFamilyNameReq: RegisterFamilyNameRequest): Result<PostRegisterFamilyNameRes>
}