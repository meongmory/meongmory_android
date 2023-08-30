package com.meongmoryteam.data.service.logout

import com.meongmoryteam.data.model.response.logout.PostUserLogoutResponse
import retrofit2.http.POST

interface LogoutApi {
    @POST("users/logout")
    suspend fun postUserLogout(
    ): PostUserLogoutResponse
}