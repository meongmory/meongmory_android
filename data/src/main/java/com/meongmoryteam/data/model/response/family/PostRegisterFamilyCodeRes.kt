package com.meongmoryteam.data.model.response.family

import com.meongmoryteam.data.model.response.login.PostSmsValidateResponse
import com.meongmoryteam.domain.model.response.family.PostRegisterFamilyCodeEntity
import com.meongmoryteam.domain.model.response.login.GetSmsSendData
import com.meongmoryteam.domain.model.response.login.GetSmsSendEntity
import com.meongmoryteam.domain.model.response.login.PostSmsValidateEntity
import kotlinx.serialization.Serializable

@Serializable
data class PostRegisterFamilyCodeRes(
    val code: String,
    val data: String,
    val message: String,
    val status: Int,
)

fun PostRegisterFamilyCodeRes.toPostRegisterFamilyCodeEntity(): PostRegisterFamilyCodeEntity {
    return PostRegisterFamilyCodeEntity(
        code = this.code,
        data = this.data,
        message = this.message,
        status = this.status,
    )
}

