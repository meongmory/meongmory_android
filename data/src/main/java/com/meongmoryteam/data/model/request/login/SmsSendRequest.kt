package com.meongmoryteam.data.model.request.login

import com.meongmoryteam.domain.model.reqeust.login.SmsSendRequestEntity
import kotlinx.serialization.Serializable

@Serializable
data class SmsSendRequest(
    val phone: String
)

fun SmsSendRequestEntity.toSmsSendRequest(): SmsSendRequest {
    return SmsSendRequest(
        phone = this.phone
    )
}