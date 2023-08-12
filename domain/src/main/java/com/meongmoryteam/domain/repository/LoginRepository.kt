package com.meongmoryteam.domain.repository

import com.meongmoryteam.domain.model.login.GetSmsSendEntity

interface LoginRepository {
    suspend fun getSmsSend(phone: String): Result<GetSmsSendEntity>
}