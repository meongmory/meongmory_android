package com.meongmoryteam.data.model.response.login

import com.meongmoryteam.domain.model.response.login.PostSmsValidateEntity
import kotlinx.serialization.Serializable

@Serializable
data class PostSmsValidateResponse(
    val status: Int,
    val code: String,
    val message: String,
    val data: Boolean
)

fun PostSmsValidateResponse.toPostSmsValidateEntity(): PostSmsValidateEntity {
    return PostSmsValidateEntity(
        status = this.status,
        code = this.code,
        message = this.message,
        data = this.data
    )
}