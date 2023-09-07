package com.meongmoryteam.data.model.request.mypage

import com.meongmoryteam.domain.model.reqeust.mypage.UserMyPageRequestEntity
import kotlinx.serialization.Serializable

@Serializable
data class UserMyPageRequest(
    val nickname: String
)

fun UserMyPageRequestEntity.toUserMyPageRequest(): UserMyPageRequest {
    return UserMyPageRequest(
        nickname = this.nickname
    )
}