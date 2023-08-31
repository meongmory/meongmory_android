package com.meongmoryteam.data.datasource.family

import com.meongmoryteam.data.model.request.family.RegisterFamilyCodeRequest
import com.meongmoryteam.data.model.request.family.RegisterFamilyNameRequest
import com.meongmoryteam.data.model.response.family.PostRegisterFamilyCodeRes
import com.meongmoryteam.data.model.response.family.PostRegisterFamilyNameRes
import com.meongmoryteam.data.service.family.FamilyApi
import com.meongmoryteam.domain.repository.family.FamilyRepository
import javax.inject.Inject

class FamilyDataSourceImpl @Inject constructor(
    private val familyApi: FamilyApi
): FamilyDataSource{
    override suspend fun registerFamilyWithCode(registerFamilyCodeReq: RegisterFamilyCodeRequest): Result<PostRegisterFamilyCodeRes> {
        return runCatching{familyApi.postRegisterFamilyCode(registerFamilyCodeReq)}
    }

    override suspend fun registerFamilyWithName(familyId: String, registerFamilyNameReq: RegisterFamilyNameRequest): Result<PostRegisterFamilyNameRes> {
        return runCatching{familyApi.postRegisterFamilyName(familyId, registerFamilyNameReq)}
    }

}