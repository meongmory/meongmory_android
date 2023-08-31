package com.meongmoryteam.data.model.request.family

import com.meongmoryteam.domain.model.reqeust.family.RegisterFamilyCodeRequestEntity
import kotlinx.serialization.Serializable

@Serializable
data class RegisterFamilyCodeRequest(
    val familyCode: String
)

fun RegisterFamilyCodeRequestEntity.toRegisterWithCodeRequest(): RegisterFamilyCodeRequest {
    return RegisterFamilyCodeRequest(
        familyCode = this.familyCode
    )
}