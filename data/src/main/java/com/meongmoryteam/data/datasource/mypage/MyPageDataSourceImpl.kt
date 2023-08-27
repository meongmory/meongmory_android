package com.meongmoryteam.data.datasource.mypage

import com.meongmoryteam.data.model.response.mypage.GetUserMyPageResponse
import com.meongmoryteam.data.service.mypage.MyPageApi
import javax.inject.Inject

class MyPageDataSourceImpl @Inject constructor(
    private val myPageApi: MyPageApi
): MyPageDataSource {
    override suspend fun getUserMyPage(): Result<GetUserMyPageResponse> {
        return kotlin.runCatching { myPageApi.getUserMyPage() }
    }
}