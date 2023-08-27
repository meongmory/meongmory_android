package com.meongmoryteam.domain.model.response.mypage

data class GetUserMyPageEntity(
    val status: Int,
    val code: String,
    val message: String,
    val getSmsSendData: GetUserMyPageData,
)

data class GetUserMyPageData(
    val myPageUrl: String,
    val nickname: String,
    val phone: String,
    val userIdx: Int,
)