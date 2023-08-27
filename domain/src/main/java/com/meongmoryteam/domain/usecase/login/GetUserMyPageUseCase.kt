package com.meongmoryteam.domain.usecase.login

import com.meongmoryteam.domain.repository.mypage.MyPageRepository
import javax.inject.Inject

class GetUserMyPageUseCase @Inject constructor(
    private val myPageRepository: MyPageRepository
) {
    suspend operator fun invoke() = myPageRepository.getUserMyPage()
}