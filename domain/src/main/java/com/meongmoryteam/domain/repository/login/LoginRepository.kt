package com.meongmoryteam.domain.repository.login

import com.meongmoryteam.domain.model.response.login.GetSmsSendEntity
import com.meongmoryteam.domain.model.reqeust.login.SmsSendRequestEntity
import com.meongmoryteam.domain.model.reqeust.login.SmsValidateRequestEntity
import com.meongmoryteam.domain.model.response.login.PostSmsValidateEntity

interface LoginRepository {
    suspend fun getSmsSend(smsSendRequestEntity: SmsSendRequestEntity): Result<GetSmsSendEntity>
    suspend fun postSmsValidate(smsValidateRequestEntity: SmsValidateRequestEntity): Result<PostSmsValidateEntity>
}