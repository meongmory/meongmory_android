package com.meongmoryteam.data.model.response.mypage

import com.meongmoryteam.domain.model.response.mypage.GetUserMyPageData
import com.meongmoryteam.domain.model.response.mypage.GetUserMyPageEntity
import kotlinx.serialization.Serializable

@Serializable
data class GetUserMyPageResponse(
    val status: Int,
    val code: String,
    val message: String,
    val data: Data
)

@Serializable
data class Data(
    val myPageUrl: String,
    val nickname: String,
    val phone: String,
    val userIdx: Int,
)

fun GetUserMyPageResponse.toUserMyPageEntity(): GetUserMyPageEntity {
    return GetUserMyPageEntity(
        status = this.status,
        code = this.code,
        message = this.message,
        getUserMyPageData = GetUserMyPageData(
            myPageUrl = this.data.myPageUrl,
            nickname = this.data.nickname,
            phone = this.data.phone,
            userIdx = this.data.userIdx
        )
    )
}
