package com.meongmoryteam.domain.usecase.logout

import com.meongmoryteam.domain.repository.logout.LogoutRepository
import javax.inject.Inject

class PostUserLogoutUseCase @Inject constructor(
    private val logoutRepository: LogoutRepository
) {
    suspend operator fun invoke()
        = logoutRepository.postUserLogout()
}