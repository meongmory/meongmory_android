package com.meongmoryteam.data.datasource.pet

import com.meongmoryteam.data.model.request.pet.RegisterPetRequest
import com.meongmoryteam.data.model.response.pet.PostRegisterPetResponse

interface PetDataSource {
    suspend fun postRegisterPet(familyId:String, registerPetRequest: RegisterPetRequest): Result<PostRegisterPetResponse>
}