package com.meongmoryteam.data.service.mypage

import com.meongmoryteam.data.model.response.mypage.GetUserMyPageResponse
import retrofit2.http.GET

interface MyPageApi {
    @GET("users/myPage")
    suspend fun getUserMyPage(): GetUserMyPageResponse
}