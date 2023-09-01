package com.meongmoryteam.data.repository.pet

import com.meongmoryteam.data.datasource.pet.PetDataSource
import com.meongmoryteam.data.model.request.pet.toRegisterPetRequest
import com.meongmoryteam.data.model.response.pet.toPostRegisterPetEntity
import com.meongmoryteam.domain.model.reqeust.pet.RegisterPetRequestEntity
import com.meongmoryteam.domain.model.response.pet.PostRegisterPetEntity
import com.meongmoryteam.domain.repository.pet.PetRepository
import javax.inject.Inject

class PetRepositoryImpl @Inject constructor(
    private val petDataSource: PetDataSource
): PetRepository {
    override suspend fun postRegisterPet(familyId:String, registerPetRequestEntity: RegisterPetRequestEntity): Result<PostRegisterPetEntity> {
        return petDataSource.postRegisterPet(familyId, registerPetRequestEntity.toRegisterPetRequest()).map { it.toPostRegisterPetEntity() }
    }
}