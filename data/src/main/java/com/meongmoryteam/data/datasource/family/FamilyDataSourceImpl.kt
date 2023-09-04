package com.meongmoryteam.data.datasource.family

import com.meongmoryteam.data.model.request.family.RegisterFamilyCodeRequest
import com.meongmoryteam.data.model.request.family.RegisterFamilyNameRequest
import com.meongmoryteam.data.model.response.family.PostRegisterFamilyCodeRes
import com.meongmoryteam.data.model.response.family.PostRegisterFamilyNameRes
import com.meongmoryteam.data.service.family.FamilyApi
import javax.inject.Inject

class FamilyDataSourceImpl @Inject constructor(
    private val familyApi: FamilyApi
) : FamilyDataSource {
    override suspend fun registerFamilyWithName(registerFamilyNameReq: RegisterFamilyNameRequest): Result<PostRegisterFamilyNameRes> {
        return runCatching { familyApi.postRegisterFamilyName(registerFamilyNameReq) }
    }

    override suspend fun registerFamilyWithCode(
        registerFamilyCodeReq: RegisterFamilyCodeRequest
    ): Result<PostRegisterFamilyCodeRes> {
        return runCatching { familyApi.postRegisterFamilyCode(registerFamilyCodeReq) }
    }

}