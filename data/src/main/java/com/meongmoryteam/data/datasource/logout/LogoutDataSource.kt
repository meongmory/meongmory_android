package com.meongmoryteam.data.datasource.logout

import com.meongmoryteam.data.model.response.logout.PostUserLogoutResponse

interface LogoutDataSource {
    suspend fun postUserLogout(): Result<PostUserLogoutResponse>
}