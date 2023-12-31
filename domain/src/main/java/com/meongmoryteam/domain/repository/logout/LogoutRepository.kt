package com.meongmoryteam.domain.repository.logout

import com.meongmoryteam.domain.model.response.logout.DeleteUserEntity
import com.meongmoryteam.domain.model.response.logout.PostUserLogoutEntity

interface LogoutRepository {
    suspend fun postUserLogout(): Result<PostUserLogoutEntity>
    suspend fun deleteUser(): Result<DeleteUserEntity>
}