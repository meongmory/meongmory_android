package com.meongmoryteam.data.model.response.family

import com.meongmoryteam.domain.model.response.family.PostRegisterFamilyNameEntity
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