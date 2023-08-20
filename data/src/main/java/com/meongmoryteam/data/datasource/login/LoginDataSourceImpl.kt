package com.meongmoryteam.data.datasource.login

import com.meongmoryteam.data.model.response.login.GetSmsSendResponse
import com.meongmoryteam.data.model.request.login.SmsSendRequest
import com.meongmoryteam.data.model.request.login.SmsValidateRequest
import com.meongmoryteam.data.model.response.login.PostSmsValidateResponse
import com.meongmoryteam.data.service.login.LoginApi
import javax.inject.Inject

class LoginDataSourceImpl @Inject constructor(
    private val loginApi: LoginApi
): LoginDataSource {

    override suspend fun getSmsSend(smsSendRequest: SmsSendRequest): Result<GetSmsSendResponse> {
        return runCatching { loginApi.getSmsSend(smsSendRequest) }
    }

    override suspend fun postSmsValidate(smsValidateRequest: SmsValidateRequest): Result<PostSmsValidateResponse> {
        return runCatching { loginApi.postSmsValidate(smsValidateRequest) }
    }
}