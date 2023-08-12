package com.meongmoryteam.domain.usecase.login

import com.meongmoryteam.domain.model.login.SmsSendRequestEntity
import com.meongmoryteam.domain.repository.login.LoginRepository
import javax.inject.Inject

class GetSmsSendUseCase @Inject constructor(
    private val loginRepository: LoginRepository
) {
    suspend operator fun invoke(smsSendRequestEntity: SmsSendRequestEntity) = loginRepository.getSmsSend(smsSendRequestEntity)
}