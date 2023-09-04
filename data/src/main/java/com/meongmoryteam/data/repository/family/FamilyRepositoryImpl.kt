package com.meongmoryteam.data.repository.family

import com.meongmoryteam.data.datasource.family.FamilyDataSource
import com.meongmoryteam.data.model.request.family.toRegisterWithCodeRequest
import com.meongmoryteam.data.model.request.family.toRegisterWithNameRequest
import com.meongmoryteam.data.model.response.family.toPostRegisterFamilyCodeEntity
import com.meongmoryteam.data.model.response.family.toPostRegisterFamilyNameEntity
import com.meongmoryteam.domain.model.reqeust.family.RegisterFamilyCodeRequestEntity
import com.meongmoryteam.domain.model.reqeust.family.RegisterFamilyNameRequestEntity
import com.meongmoryteam.domain.model.response.family.PostRegisterFamilyCodeEntity
import com.meongmoryteam.domain.model.response.family.PostRegisterFamilyNameEntity
import com.meongmoryteam.domain.repository.family.FamilyRepository
import javax.inject.Inject

class FamilyRepositoryImpl @Inject constructor(
    private val familyDataSource: FamilyDataSource
) : FamilyRepository {
    override suspend fun postRegisterWithName(registerFamilyNameRequestEntity: RegisterFamilyNameRequestEntity): Result<PostRegisterFamilyNameEntity> {
        return familyDataSource.registerFamilyWithName(registerFamilyNameRequestEntity.toRegisterWithNameRequest())
            .map { it.toPostRegisterFamilyNameEntity() }
    }

    override suspend fun postRegisterWithCode(
        registerFamilyCodeRequestEntity: RegisterFamilyCodeRequestEntity
    ): Result<PostRegisterFamilyCodeEntity> {
        return familyDataSource.registerFamilyWithCode(
            registerFamilyCodeRequestEntity.toRegisterWithCodeRequest()
        ).map { it.toPostRegisterFamilyCodeEntity() }
    }
}