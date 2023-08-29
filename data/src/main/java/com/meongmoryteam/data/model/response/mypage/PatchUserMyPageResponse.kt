package com.meongmoryteam.data.model.response.mypage

import com.meongmoryteam.domain.model.response.mypage.PatchUserMyPageEntity
import kotlinx.serialization.Serializable

@Serializable
data class PatchUserMyPageResponse(
    val status: Int,
    val code: String,
    val message: String,
    val data: String
)

fun PatchUserMyPageResponse.toUserMyPageEntity(): PatchUserMyPageEntity {
    return PatchUserMyPageEntity(
        status = this.status,
        code = this.code,
        message = this.message,
        patchUserMyPageData = this.data
    )
}