package com.meongmoryteam.presentation.ui.login

import com.meongmoryteam.presentation.base.LoadState
import com.meongmoryteam.presentation.base.ViewEvent
import com.meongmoryteam.presentation.base.ViewSideEffect
import com.meongmoryteam.presentation.base.ViewState
import com.meongmoryteam.presentation.ui.register_dog.RegisterDogContract

class LoginContract {
    data class LoginState(
        val getSmsSendLoadState: LoadState = LoadState.SUCCESS,
        val phoneNumber: String = "",
        val certificationNumber: String = "",
        val getCertificationNumber: String = "",
    ): ViewState

    sealed class LoginEvent : ViewEvent {
        object GetCertificationButtonClicked : LoginEvent()
        object PostCertificationButtonClicked : LoginEvent()
        object ToTermScreenButtonClicked : LoginEvent()
        data class OnPhoneChanged(val phoneNumber: String) : LoginEvent()
        data class OnCertificationNumberChanged(val certificationNumber: String) : LoginEvent()
    }

    sealed class LoginEffect : ViewSideEffect {
        data class ShowSnackBar(val message: String): LoginEffect()
        object MoveToTerm: LoginEffect()
        object SuccessCertification: LoginEffect()
        object FailCertification: LoginEffect()
    }
}