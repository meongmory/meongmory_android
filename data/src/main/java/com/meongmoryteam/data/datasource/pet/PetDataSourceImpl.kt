package com.meongmoryteam.data.datasource.pet

import com.meongmoryteam.data.model.request.pet.RegisterPetRequest
import com.meongmoryteam.data.model.response.pet.GetSearchBreedResponse
import com.meongmoryteam.data.model.response.pet.PostRegisterPetResponse
import com.meongmoryteam.data.service.pet.PetApi
import javax.inject.Inject

class PetDataSourceImpl @Inject constructor(
    private val petApi: PetApi
): PetDataSource {
    override suspend fun postRegisterPet(familyId: Int, registerPetRequest: RegisterPetRequest): Result<PostRegisterPetResponse> {
        return runCatching { petApi.postRegisterPet(familyId, registerPetRequest) }
    }

    override suspend fun getSearchBreed(
        page: Int?,
        searchWord: String?,
        size: Int?,
        sort: List<String>?,
        type: String?
    ): Result<GetSearchBreedResponse> {
        return runCatching { petApi.getSearchBreed(page, searchWord, size,sort,type) }
    }
}