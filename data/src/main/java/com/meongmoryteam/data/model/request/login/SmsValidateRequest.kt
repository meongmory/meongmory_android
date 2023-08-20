package com.meongmoryteam.data.model.request.login

import com.meongmoryteam.domain.model.reqeust.login.SmsValidateRequestEntity
import kotlinx.serialization.Serializable

@Serializable
data class SmsValidateRequest(
    val code: String,
    val phone: String
)

fun SmsValidateRequestEntity.toSmsValidateRequest(): SmsValidateRequest {
    return SmsValidateRequest(
        code = this.code,
        phone = this.phone
    )
}
