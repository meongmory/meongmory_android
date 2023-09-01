package com.meongmoryteam.data.model.request.pet

import com.meongmoryteam.domain.model.reqeust.pet.RegisterPetRequestEntity

data class RegisterPetRequest(
    val adoptDate : String,
    val animalId: Int,
    val birth: Int,
    val gender: String,
    val imgKey: String,
    val petName: String,
    val registration: Int
)

fun RegisterPetRequestEntity.toRegisterPetRequest(): RegisterPetRequest{
    return RegisterPetRequest(
        adoptDate = this.adoptDate,
        animalId = this.animalId,
        birth = this.birth,
        gender = this.gender,
        imgKey = this.imgKey,
        petName = this.petName,
        registration = this.registration
    )
}