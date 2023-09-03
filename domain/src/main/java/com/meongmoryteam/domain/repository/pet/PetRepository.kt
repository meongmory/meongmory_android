package com.meongmoryteam.domain.repository.pet

import com.meongmoryteam.domain.model.reqeust.pet.RegisterPetRequestEntity
import com.meongmoryteam.domain.model.response.pet.GetSearchBreedEntity
import com.meongmoryteam.domain.model.response.pet.PostRegisterPetEntity

interface PetRepository {
    suspend fun postRegisterPet(familyId:Int, registerPetRequestEntity: RegisterPetRequestEntity): Result<PostRegisterPetEntity>
    suspend fun getSearchBreed(page: Int?, searchWord: String?, size: Int?, sort: List<String>?, type:String?): Result<GetSearchBreedEntity>
}