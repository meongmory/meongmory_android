package com.meongmoryteam.domain.model.response.logout

data class PostUserLogoutEntity(
    val status: Int,
    val code: String,
    val message: String,
    val data: PostUserLogoutData
)

data class PostUserLogoutData(
    val value: String?
)
