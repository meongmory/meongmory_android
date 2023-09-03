package com.meongmoryteam.domain.usecase.pet

import com.meongmoryteam.domain.model.reqeust.pet.RegisterPetRequestEntity
import com.meongmoryteam.domain.repository.pet.PetRepository
import javax.inject.Inject

class PostRegisterPetUseCase @Inject constructor(
    private val petRepository: PetRepository
) {
    suspend operator fun invoke(familyId:Int, registerPetRequestEntity: RegisterPetRequestEntity)
    = petRepository.postRegisterPet(familyId, registerPetRequestEntity)
}