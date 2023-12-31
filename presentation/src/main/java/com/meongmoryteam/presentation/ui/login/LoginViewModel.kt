package com.meongmoryteam.presentation.ui.login

import androidx.lifecycle.viewModelScope
import com.meongmoryteam.domain.model.reqeust.login.SmsSendRequestEntity
import com.meongmoryteam.domain.model.reqeust.login.SmsValidateRequestEntity
import com.meongmoryteam.domain.usecase.login.GetSmsSendUseCase
import com.meongmoryteam.domain.usecase.login.PostSmsValidateUseCase
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
    private val getSmsSendUseCase: GetSmsSendUseCase,
    private val postSmsSendUseCase: PostSmsValidateUseCase
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
                postSmsSend()
            }
            is LoginEvent.ToTermScreenButtonClicked -> {
                sendEffect({ LoginEffect.MoveToTerm })
            }
            is LoginEvent.OnPhoneChanged -> reflectUpdateState(phoneNumber = event.phoneNumber)
            is LoginEvent.OnCertificationNumberChanged -> reflectUpdateState(certificationNumber = event.certificationNumber)
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
                        getCertificationNumber = it.getSmsSendData.value
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

    private fun postSmsSend() {
        val smsValidRequest = SmsValidateRequestEntity(
            viewState.value.certificationNumber,
            viewState.value.phoneNumber
        )
        viewModelScope.launch {
            postSmsSendUseCase(smsValidRequest).onSuccess {
                updateState {
                    copy(
                        isCertification = true
                    )
                }
                sendEffect({ LoginEffect.SuccessCertification })
            }.onFailure {
                sendEffect({ LoginEffect.FailCertification })
            }
        }
    }

    private fun reflectUpdateState(
        phoneNumber: String = viewState.value.phoneNumber,
        certificationNumber: String = viewState.value.certificationNumber
    ) {
        updateState {
            copy(
                phoneNumber = phoneNumber,
                certificationNumber = certificationNumber
            )
        }
    }
}