package com.meongmoryteam.data.datasource.mypage

import com.meongmoryteam.data.model.request.mypage.UserMyPageRequest
import com.meongmoryteam.data.model.response.mypage.GetUserMyPageResponse
import com.meongmoryteam.data.model.response.mypage.PatchUserMyPageResponse

interface MyPageDataSource {
    suspend fun getUserMyPage(): Result<GetUserMyPageResponse>

    suspend fun patchUserMyPage(userMyPageRequest: UserMyPageRequest): Result<PatchUserMyPageResponse>
}