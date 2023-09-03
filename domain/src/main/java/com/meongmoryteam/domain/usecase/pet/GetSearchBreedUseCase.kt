package com.meongmoryteam.domain.usecase.pet

import com.meongmoryteam.domain.repository.pet.PetRepository
import javax.inject.Inject

class GetSearchBreedUseCase @Inject constructor(
    private val petRepository: PetRepository
) {
    suspend operator fun invoke(page: Int?, searchWord: String?, size: Int?, sort: List<String>?, type: String?) = petRepository.getSearchBreed(page, searchWord, size, sort, type)
}