package com.meongmoryteam.domain.usecase.mypage

import com.meongmoryteam.domain.model.reqeust.mypage.UserMyPageRequestEntity
import com.meongmoryteam.domain.repository.mypage.MyPageRepository
import javax.inject.Inject

class PatchUserMyPageUseCase @Inject constructor(
    private val myPageRepository: MyPageRepository
) {
    suspend operator fun invoke(userMyPageRequestEntity: UserMyPageRequestEntity)
        = myPageRepository.patchUserMyPage(userMyPageRequestEntity)
}