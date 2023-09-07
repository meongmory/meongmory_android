package com.meongmoryteam.domain.model.response.logout

data class DeleteUserEntity(
    val status: Int,
    val code: String,
    val message: String,
    val data: DeleteUser
)

data class DeleteUser(
    val value: String?
)