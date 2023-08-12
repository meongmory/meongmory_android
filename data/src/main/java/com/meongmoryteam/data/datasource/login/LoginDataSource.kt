package com.meongmoryteam.data.datasource.login

import com.meongmoryteam.data.model.login.GetSmsSendResponse

interface LoginDataSource {
    suspend fun getSmsSend(phone: String): Result<GetSmsSendResponse>
}