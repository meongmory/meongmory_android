package com.meongmoryteam.domain.model.response.mypage

data class PatchUserMyPageEntity(
    val status: Int,
    val code: String,
    val message: String,
    val patchUserMyPageData: String
)