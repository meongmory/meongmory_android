package com.meongmoryteam.data.datasource.pet

import com.meongmoryteam.data.model.request.pet.RegisterPetRequest
import com.meongmoryteam.data.model.response.pet.PostRegisterPetResponse
import com.meongmoryteam.data.service.pet.PetApi
import javax.inject.Inject

class PetDataSourceImpl @Inject constructor(
    private val petApi: PetApi
): PetDataSource {
    override suspend fun postRegisterPet(familyId: String, registerPetRequest: RegisterPetRequest): Result<PostRegisterPetResponse> {
        return runCatching { petApi.postRegisterPet(familyId, registerPetRequest) }
    }
}