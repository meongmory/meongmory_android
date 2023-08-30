package com.meongmoryteam.data.repository.logout

import com.meongmoryteam.data.datasource.logout.LogoutDataSource
import com.meongmoryteam.data.model.response.logout.toPostUserLogoutEntity
import com.meongmoryteam.domain.model.response.logout.PostUserLogoutEntity
import com.meongmoryteam.domain.repository.logout.LogoutRepository
import javax.inject.Inject

class LogoutRepositoryImpl @Inject constructor(
    private val logoutDataSource: LogoutDataSource
) : LogoutRepository {
    override suspend fun postUserLogout(): Result<PostUserLogoutEntity> {
        return logoutDataSource.postUserLogout().map { it.toPostUserLogoutEntity() }
    }
}