package com.meongmoryteam.data.repository.mypage

import com.meongmoryteam.data.datasource.mypage.MyPageDataSource
import com.meongmoryteam.data.model.response.mypage.toUserMyPageEntity
import com.meongmoryteam.domain.model.response.mypage.GetUserMyPageEntity
import com.meongmoryteam.domain.repository.mypage.MyPageRepository
import javax.inject.Inject

class MyPageRepositoryImpl @Inject constructor(
    private val myPageDataSource: MyPageDataSource
) : MyPageRepository {
    override suspend fun getUserMyPage(): Result<GetUserMyPageEntity> {
        return myPageDataSource.getUserMyPage().map { it.toUserMyPageEntity() }
    }
}