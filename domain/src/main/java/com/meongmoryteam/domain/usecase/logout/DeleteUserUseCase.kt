package com.meongmoryteam.domain.usecase.logout

import com.meongmoryteam.domain.repository.logout.LogoutRepository
import javax.inject.Inject

class DeleteUserUseCase @Inject constructor(
    private val deleteUserRepository: LogoutRepository
) {
    suspend operator fun invoke()
        = deleteUserRepository.deleteUser()
}