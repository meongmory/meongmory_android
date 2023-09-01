package com.meongmoryteam.data.model.response.pet

import com.meongmoryteam.domain.model.response.pet.PostRegisterPetEntity
import kotlinx.serialization.Serializable

@Serializable
data class PostRegisterPetResponse(
    val imgKey:	String,
    val name: String,
    val petId: Long
)

fun PostRegisterPetResponse.toPostRegisterPetEntity(): PostRegisterPetEntity{
    return PostRegisterPetEntity(
        imgKey = this.imgKey,
        name = this.name,
        petId = this.petId
    )
}