package com.meongmoryteam.data.datasource.logout

import com.meongmoryteam.data.model.response.logout.DeleteUserResponse
import com.meongmoryteam.data.model.response.logout.PostUserLogoutResponse

interface LogoutDataSource {
    suspend fun postUserLogout(): Result<PostUserLogoutResponse>
    suspend fun deleteUser(): Result<DeleteUserResponse>
}