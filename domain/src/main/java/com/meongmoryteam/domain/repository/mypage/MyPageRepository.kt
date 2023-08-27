package com.meongmoryteam.domain.repository.mypage

import com.meongmoryteam.domain.model.response.mypage.GetUserMyPageEntity

interface MyPageRepository {
    suspend fun getUserMyPage(): Result<GetUserMyPageEntity>
}