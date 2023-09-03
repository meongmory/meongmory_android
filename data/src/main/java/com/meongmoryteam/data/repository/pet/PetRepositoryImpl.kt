package com.meongmoryteam.data.repository.pet

import com.meongmoryteam.data.datasource.pet.PetDataSource
import com.meongmoryteam.data.model.request.pet.toRegisterPetRequest
import com.meongmoryteam.data.model.response.pet.toGetSearchBreedEntity
import com.meongmoryteam.data.model.response.pet.toPostRegisterPetEntity
import com.meongmoryteam.domain.model.reqeust.pet.RegisterPetRequestEntity
import com.meongmoryteam.domain.model.response.pet.GetSearchBreedEntity
import com.meongmoryteam.domain.model.response.pet.PostRegisterPetEntity
import com.meongmoryteam.domain.repository.pet.PetRepository
import javax.inject.Inject

class PetRepositoryImpl @Inject constructor(
    private val petDataSource: PetDataSource
): PetRepository {
    override suspend fun postRegisterPet(familyId:Int, registerPetRequestEntity: RegisterPetRequestEntity): Result<PostRegisterPetEntity> {
        return petDataSource.postRegisterPet(familyId, registerPetRequestEntity.toRegisterPetRequest()).map { it.toPostRegisterPetEntity() }
    }

    override suspend fun getSearchBreed(
        page: Int?,
        searchWord: String?,
        size: Int?,
        sort: List<String>?,
        type: String?
    ): Result<GetSearchBreedEntity> {
        return petDataSource.getSearchBreed(page, searchWord, size, sort, type).map { it.toGetSearchBreedEntity() }
    }
}