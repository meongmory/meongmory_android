package com.meongmoryteam.domain.model.response.login

data class GetSmsSendEntity(
    val status: Int,
    val code: String,
    val message: String,
    val getSmsSendData: GetSmsSendData,
)

data class GetSmsSendData(
    val value: String,
    val message: String?
)

