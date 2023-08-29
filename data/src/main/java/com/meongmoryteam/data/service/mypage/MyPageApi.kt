package com.meongmoryteam.data.service.mypage

import com.meongmoryteam.data.model.response.mypage.GetUserMyPageResponse
import com.meongmoryteam.data.model.response.mypage.PatchUserMyPageResponse
import retrofit2.http.GET
import retrofit2.http.PATCH

interface MyPageApi {
    @GET("users/myPage")
    suspend fun getUserMyPage(): GetUserMyPageResponse

    @PATCH("users/myPage")
    suspend fun patchUserMyPage(): PatchUserMyPageResponse
}