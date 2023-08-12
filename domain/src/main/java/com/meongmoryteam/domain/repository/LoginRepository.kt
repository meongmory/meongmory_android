package com.meongmoryteam.domain.repository

import com.meongmoryteam.domain.model.login.GetSmsSendEntity
import com.meongmoryteam.domain.model.login.SmsSendRequestEntity

interface LoginRepository {
    suspend fun getSmsSend(smsSendRequestEntity: SmsSendRequestEntity): Result<GetSmsSendEntity>
}