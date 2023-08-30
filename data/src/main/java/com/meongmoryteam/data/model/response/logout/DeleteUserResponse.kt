package com.meongmoryteam.data.model.response.logout

import com.meongmoryteam.domain.model.response.logout.DeleteUser
import com.meongmoryteam.domain.model.response.logout.DeleteUserEntity
import kotlinx.serialization.Serializable

@Serializable
data class DeleteUserResponse(
    val status: Int,
    val code: String,
    val message: String,
    val data: DeleteUserData
)

@Serializable
data class DeleteUserData(
    val value: String?
)

fun DeleteUserResponse.toDeleteUserEntity(): DeleteUserEntity {
    return DeleteUserEntity(
        status = this.status,
        code = this.code,
        message = this.message,
        data = DeleteUser(
            value = this.data.value
        )
    )
}
