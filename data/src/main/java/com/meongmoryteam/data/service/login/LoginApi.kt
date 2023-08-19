package com.meongmoryteam.data.service.login

import com.meongmoryteam.data.model.response.login.GetSmsSendResponse
import com.meongmoryteam.data.model.request.login.SmsSendRequest
import com.meongmoryteam.data.model.request.login.SmsValidateRequest
import com.meongmoryteam.data.model.response.login.PostSmsValidateResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginApi {

    @POST("sms/send")
    suspend fun getSmsSend(
        @Body smsSendRequest: SmsSendRequest
    ): GetSmsSendResponse

    @POST("sms/validate")
    suspend fun postSmsValidate(
        @Body smsValidateRequest: SmsValidateRequest
    ): PostSmsValidateResponse
}