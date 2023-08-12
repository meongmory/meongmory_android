package com.meongmoryteam.data.model.login

import com.meongmoryteam.domain.model.login.GetSmsSendData
import com.meongmoryteam.domain.model.login.GetSmsSendEntity

data class GetSmsSendResponse(
    val status: Int,
    val code: String,
    val message: String,
    val data: Data,
)

data class Data(
    val value: String,
    val message: String?
)

fun GetSmsSendResponse.toGetSmsSendEntity(): GetSmsSendEntity {
    return GetSmsSendEntity(
        status = this.status,
        code = this.code,
        message = this.message,
        getSmsSendData = GetSmsSendData(
            value = this.data.value,
            message = this.data.message
        )
    )
}