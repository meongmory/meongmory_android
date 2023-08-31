package com.meongmoryteam.data.model.response.family

import com.meongmoryteam.data.model.response.login.PostSmsValidateResponse
import com.meongmoryteam.domain.model.response.family.PostRegisterFamilyCodeEntity
import com.meongmoryteam.domain.model.response.family.PostRegisterFamilyNameEntity
import com.meongmoryteam.domain.model.response.login.PostSmsValidateEntity
import kotlinx.serialization.Serializable

@Serializable
data class PostRegisterFamilyNameRes(
    val code: String,
    val data: String,
    val message: String,
    val status: Int,
)

fun PostRegisterFamilyNameRes.toPostRegisterFamilyNameEntity(): PostRegisterFamilyNameEntity {
    return PostRegisterFamilyNameEntity(
        code = this.code,
        data = this.data,
        message = this.message,
        status = this.status,
    )
}