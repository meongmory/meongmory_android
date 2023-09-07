package com.meongmoryteam.domain.usecase.family

import com.meongmoryteam.domain.model.reqeust.family.RegisterFamilyNameRequestEntity
import com.meongmoryteam.domain.repository.family.FamilyRepository
import javax.inject.Inject

class PostRegisterFamilyNameUseCase @Inject constructor(
    private val familyRepository: FamilyRepository
) {
    suspend operator fun invoke(registerFamilyNameRequestEntity: RegisterFamilyNameRequestEntity) =
        familyRepository.postRegisterWithName(registerFamilyNameRequestEntity)
}