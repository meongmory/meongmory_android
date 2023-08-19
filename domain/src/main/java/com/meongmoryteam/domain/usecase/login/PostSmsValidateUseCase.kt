package com.meongmoryteam.domain.usecase.login

import com.meongmoryteam.domain.model.reqeust.login.SmsValidateRequestEntity
import com.meongmoryteam.domain.repository.login.LoginRepository
import javax.inject.Inject

class PostSmsValidateUseCase @Inject constructor(
    private val loginRepository: LoginRepository
) {
    suspend operator fun invoke(smsValidateRequestEntity: SmsValidateRequestEntity)
        = loginRepository.postSmsValidate(smsValidateRequestEntity)
}