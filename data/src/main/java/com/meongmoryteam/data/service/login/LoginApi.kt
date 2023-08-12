package com.meongmoryteam.data.service.login

import com.meongmoryteam.data.model.login.GetSmsSendResponse
import com.meongmoryteam.data.model.login.SmsSendRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginApi {

    @POST("sms/send")
    suspend fun getSmsSend(
        @Body smsSendRequest: SmsSendRequest
    ): GetSmsSendResponse
}