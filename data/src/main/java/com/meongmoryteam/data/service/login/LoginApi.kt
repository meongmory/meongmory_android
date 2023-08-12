package com.meongmoryteam.data.service.login

import com.meongmoryteam.data.model.login.GetSmsSendResponse
import com.meongmoryteam.data.model.login.SmsSendRequest
import retrofit2.http.Body
import retrofit2.http.GET

interface LoginApi {

    @GET("sms/send")
    suspend fun getSmsSend(
        @Body smsSendRequest: String
    ): GetSmsSendResponse
}