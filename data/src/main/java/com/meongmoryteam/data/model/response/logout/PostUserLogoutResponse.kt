package com.meongmoryteam.data.model.response.logout

import com.meongmoryteam.domain.model.response.logout.PostUserLogoutData
import com.meongmoryteam.domain.model.response.logout.PostUserLogoutEntity
import kotlinx.serialization.Serializable

@Serializable
data class PostUserLogoutResponse(
    val status: Int,
    val code: String,
    val message: String,
    val data: LogoutData
)

@Serializable
data class LogoutData(
    val value: String?,
)

fun PostUserLogoutResponse.toPostUserLogoutEntity(): PostUserLogoutEntity {
    return PostUserLogoutEntity(
        status = this.status,
        code = this.code,
        message = this.message,
        data = PostUserLogoutData(
            value = this.data.value
        )
    )
}