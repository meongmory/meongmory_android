package com.meongmoryteam.domain.repository.pet

import com.meongmoryteam.domain.model.reqeust.pet.RegisterPetRequestEntity
import com.meongmoryteam.domain.model.response.pet.PostRegisterPetEntity

interface PetRepository {
    suspend fun postRegisterPet(familyId:String, registerPetRequestEntity: RegisterPetRequestEntity): Result<PostRegisterPetEntity>
}