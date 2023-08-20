package com.meongmoryteam.data.datasource.login

import com.meongmoryteam.data.model.response.login.GetSmsSendResponse
import com.meongmoryteam.data.model.request.login.SmsSendRequest
import com.meongmoryteam.data.model.request.login.SmsValidateRequest
import com.meongmoryteam.data.model.response.login.PostSmsValidateResponse

interface LoginDataSource {
    suspend fun getSmsSend(smsSendRequest: SmsSendRequest): Result<GetSmsSendResponse>
    suspend fun postSmsValidate(smsValidateRequest: SmsValidateRequest): Result<PostSmsValidateResponse>
}