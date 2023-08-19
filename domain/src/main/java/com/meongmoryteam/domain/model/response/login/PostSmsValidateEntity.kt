package com.meongmoryteam.domain.model.response.login

data class PostSmsValidateEntity(
    val status: Int,
    val code: String,
    val message: String,
    val data: Boolean,
)
