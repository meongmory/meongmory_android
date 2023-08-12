package com.meongmoryteam.data.datasource.login

import com.meongmoryteam.data.model.login.GetSmsSendResponse
import com.meongmoryteam.data.model.login.SmsSendRequest
import com.meongmoryteam.data.service.login.LoginApi
import javax.inject.Inject

class LoginDataSourceImpl @Inject constructor(
    private val loginApi: LoginApi
): LoginDataSource {

    override suspend fun getSmsSend(smsSendRequest: SmsSendRequest): Result<GetSmsSendResponse> {
        return runCatching { loginApi.getSmsSend(smsSendRequest) }
    }
}