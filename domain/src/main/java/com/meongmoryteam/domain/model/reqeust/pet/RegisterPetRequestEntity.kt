package com.meongmoryteam.domain.model.reqeust.pet

data class RegisterPetRequestEntity(
    val adoptDate : String,
    val animalId: Int,
    val birth: Int,
    val gender: String,
    val imgKey: String,
    val petName: String,
    val registration: Int
)


