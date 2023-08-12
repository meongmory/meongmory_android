package com.meongmoryteam.data.model.login

import com.meongmoryteam.domain.model.login.SmsSendRequestEntity

data class SmsSendRequest(
    val phone: String
)

fun SmsSendRequestEntity.toSmsSendRequest(): SmsSendRequest {
    return SmsSendRequest(
        phone = this.phone
    )
}