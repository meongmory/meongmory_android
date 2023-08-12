package com.meongmoryteam.data.repository.login

import com.meongmoryteam.data.datasource.login.LoginDataSource
import com.meongmoryteam.data.model.login.toGetSmsSendEntity
import com.meongmoryteam.domain.model.login.GetSmsSendEntity
import com.meongmoryteam.domain.repository.LoginRepository
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val loginDataSource: LoginDataSource
) : LoginRepository {

    override suspend fun getSmsSend(phone: String): Result<GetSmsSendEntity> {
        return loginDataSource.getSmsSend(phone).map { it.toGetSmsSendEntity() }
    }
}