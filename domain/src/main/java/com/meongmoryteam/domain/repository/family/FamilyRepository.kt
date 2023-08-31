package com.meongmoryteam.domain.repository.family

import com.meongmoryteam.domain.model.reqeust.family.RegisterFamilyCodeRequestEntity
import com.meongmoryteam.domain.model.reqeust.family.RegisterFamilyNameRequestEntity
import com.meongmoryteam.domain.model.response.family.PostRegisterFamilyCodeEntity
import com.meongmoryteam.domain.model.response.family.PostRegisterFamilyNameEntity

interface FamilyRepository {
    suspend fun postRegisterWithCode(registerFamilyCodeRequestEntity: RegisterFamilyCodeRequestEntity): Result<PostRegisterFamilyCodeEntity>
    suspend fun postRegisterWithName(familyId: String, registerFamilyNameRequestEntity: RegisterFamilyNameRequestEntity): Result<PostRegisterFamilyNameEntity>
}