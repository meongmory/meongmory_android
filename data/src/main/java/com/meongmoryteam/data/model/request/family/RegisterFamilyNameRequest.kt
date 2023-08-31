package com.meongmoryteam.data.model.request.family

import com.meongmoryteam.domain.model.reqeust.family.RegisterFamilyCodeRequestEntity
import com.meongmoryteam.domain.model.reqeust.family.RegisterFamilyNameRequestEntity
import kotlinx.serialization.Serializable

@Serializable
data class RegisterFamilyNameRequest(
    val name: String
)

fun RegisterFamilyNameRequestEntity.toRegisterWithNameRequest(): RegisterFamilyNameRequest {
    return RegisterFamilyNameRequest(
        name = this.name)
}