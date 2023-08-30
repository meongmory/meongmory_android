package com.meongmoryteam.data.datasource.logout

import com.meongmoryteam.data.model.response.logout.PostUserLogoutResponse
import com.meongmoryteam.data.service.logout.LogoutApi
import javax.inject.Inject

class LogoutDataSourceImpl @Inject constructor(
    private val logoutApi: LogoutApi
): LogoutDataSource {
    override suspend fun postUserLogout(): Result<PostUserLogoutResponse> {
        return runCatching { logoutApi.postUserLogout() }
    }
}