package com.meongmoryteam.data.datasource.mypage

import com.meongmoryteam.data.model.response.mypage.GetUserMyPageResponse

interface MyPageDataSource {
    suspend fun getUserMyPage(): Result<GetUserMyPageResponse>
}