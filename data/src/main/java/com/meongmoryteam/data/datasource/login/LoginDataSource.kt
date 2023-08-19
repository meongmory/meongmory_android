package com.meongmoryteam.data.datasource.login

import com.meongmoryteam.data.model.response.login.GetSmsSendResponse
import com.meongmoryteam.data.model.request.login.SmsSendRequest

interface LoginDataSource {
    suspend fun getSmsSend(smsSendRequest: SmsSendRequest): Result<GetSmsSendResponse>
}