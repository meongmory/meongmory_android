package com.meongmoryteam.domain.model.reqeust.login

data class SmsValidateRequestEntity(
    val code: String,
    val phone: String
)
