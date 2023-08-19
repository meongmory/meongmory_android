package com.meongmoryteam.data.repository.login

import com.meongmoryteam.data.datasource.login.LoginDataSource
import com.meongmoryteam.data.model.response.login.toGetSmsSendEntity
import com.meongmoryteam.data.model.request.login.toSmsSendRequest
import com.meongmoryteam.domain.model.response.login.GetSmsSendEntity
import com.meongmoryteam.domain.model.reqeust.login.SmsSendRequestEntity
import com.meongmoryteam.domain.model.reqeust.login.SmsValidateRequestEntity
import com.meongmoryteam.domain.model.response.login.PostSmsValidateEntity
import com.meongmoryteam.domain.repository.login.LoginRepository
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val loginDataSource: LoginDataSource
) : LoginRepository {

    override suspend fun getSmsSend(smsSendRequestEntity: SmsSendRequestEntity): Result<GetSmsSendEntity> {
        return loginDataSource.getSmsSend(smsSendRequestEntity.toSmsSendRequest()).map { it.toGetSmsSendEntity() }
    }

    override suspend fun postSmsValidate(smsValidateRequestEntity: SmsValidateRequestEntity): Result<PostSmsValidateEntity> {

    }
}