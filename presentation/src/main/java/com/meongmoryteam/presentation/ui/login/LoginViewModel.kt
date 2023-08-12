package com.meongmoryteam.presentation.ui.login

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.meongmoryteam.domain.model.login.SmsSendRequestEntity
import com.meongmoryteam.domain.usecase.login.GetSmsSendUseCase
import com.meongmoryteam.presentation.base.BaseViewModel
import com.meongmoryteam.presentation.base.LoadState
import com.meongmoryteam.presentation.ui.login.LoginContract.LoginEffect
import com.meongmoryteam.presentation.ui.login.LoginContract.LoginEvent
import com.meongmoryteam.presentation.ui.login.LoginContract.LoginState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val getSmsSendUseCase: GetSmsSendUseCase
): BaseViewModel<LoginState, LoginEffect, LoginEvent>(
   LoginState()
) {
    override fun handleEvents(event: LoginEvent) {
        when(event) {
            is LoginEvent.GetCertificationButtonClicked -> {
                updateState { copy(getSmsSendLoadState = LoadState.LOADING) }
                getSmsSend()
            }
            is LoginEvent.PostCertificationButtonClicked -> {
                /*
                인증 번호 전송 api
                 */
            }
            is LoginEvent.ToTermScreenButtonClicked -> {
                sendEffect({ LoginEffect.MoveToTerm })
            }

            is LoginEvent.OnPhoneChanged -> reflectUpdateState(event.phoneNumber)
        }
    }

    private fun getSmsSend() {
        val smsSendRequest = SmsSendRequestEntity(
            viewState.value.phoneNumber
        )
        viewModelScope.launch {
            getSmsSendUseCase(smsSendRequest).onSuccess {
                updateState {
                    copy(
                        getSmsSendLoadState = LoadState.SUCCESS,
                        certificationNumber = it.getSmsSendData.value
                    )
                }
            }.onFailure {
                updateState {
                    copy(
                        getSmsSendLoadState = LoadState.ERROR,
                    )
                }
            }
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