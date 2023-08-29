package com.meongmoryteam.domain.repository.mypage

import com.meongmoryteam.domain.model.reqeust.mypage.UserMyPageRequestEntity
import com.meongmoryteam.domain.model.response.mypage.GetUserMyPageEntity
import com.meongmoryteam.domain.model.response.mypage.PatchUserMyPageEntity

interface MyPageRepository {
    suspend fun getUserMyPage(): Result<GetUserMyPageEntity>
    suspend fun patchUserMyPage(userMyPageRequestEntity: UserMyPageRequestEntity): Result<PatchUserMyPageEntity>
}