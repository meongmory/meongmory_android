package com.meongmoryteam.data.datasource.login

import com.meongmoryteam.data.model.login.GetSmsSendResponse
import com.meongmoryteam.data.model.login.SmsSendRequest

interface LoginDataSource {
    suspend fun getSmsSend(smsSendRequest: SmsSendRequest): Result<GetSmsSendResponse>
}