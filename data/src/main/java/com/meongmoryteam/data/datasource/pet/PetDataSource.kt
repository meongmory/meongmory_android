package com.meongmoryteam.data.datasource.pet

import com.meongmoryteam.data.model.request.pet.RegisterPetRequest
import com.meongmoryteam.data.model.response.pet.GetSearchBreedResponse
import com.meongmoryteam.data.model.response.pet.PostRegisterPetResponse

interface PetDataSource {
    suspend fun postRegisterPet(familyId:Int, registerPetRequest: RegisterPetRequest): Result<PostRegisterPetResponse>
    suspend fun getSearchBreed(page: Int?, searchWord: String?, size: Int?, sort: List<String>?, type: String?): Result<GetSearchBreedResponse>
}