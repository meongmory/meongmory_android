package com.meongmoryteam.presentation.ui.login

import com.meongmoryteam.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import com.meongmoryteam.presentation.ui.login.LoginContract.LoginState
import com.meongmoryteam.presentation.ui.login.LoginContract.LoginEffect
import com.meongmoryteam.presentation.ui.login.LoginContract.LoginEvent
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(

): BaseViewModel<LoginState, LoginEffect, LoginEvent>(
   LoginState()
) {
    override fun handleEvents(event: LoginEvent) {
        when(event) {
            is LoginEvent.GetCertificationButtonClicked -> {
                /*
                인증 번호 조회 api
                 */
            }
            is LoginEvent.PostCertificationButtonClicked -> {
                /*
                인증 번호 전송 api
                 */
            }
            is LoginEvent.ToTermScreenButtonClicked -> {
                sendEffect({ LoginEffect.MoveToTerm })
            }

            is LoginEvent.OnPhoneChanged -> reflectUpdateState(phoneNumber = event.phoneNumber)
        }
    }

    private fun reflectUpdateState(
        phoneNumber: String = viewState.value.phoneNumber
    ) {
        updateState {
            copy(
                phoneNumber = phoneNumber
            )
        }
    }
}