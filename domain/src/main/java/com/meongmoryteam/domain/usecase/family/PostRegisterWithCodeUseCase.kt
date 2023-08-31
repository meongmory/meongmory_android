package com.meongmoryteam.domain.usecase.family

import com.meongmoryteam.domain.model.reqeust.family.RegisterFamilyCodeRequestEntity
import com.meongmoryteam.domain.repository.family.FamilyRepository
import javax.inject.Inject

class PostRegisterWithCodeUseCase @Inject constructor(
    private val familyRepository: FamilyRepository
) {
    suspend operator fun invoke(registerFamilyCodeRequestEntity: RegisterFamilyCodeRequestEntity) = familyRepository.postRegisterWithCode(registerFamilyCodeRequestEntity)
}