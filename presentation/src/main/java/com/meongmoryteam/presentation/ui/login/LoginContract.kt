package com.meongmoryteam.presentation.ui.login

import com.meongmoryteam.presentation.base.LoadState
import com.meongmoryteam.presentation.base.ViewEvent
import com.meongmoryteam.presentation.base.ViewSideEffect
import com.meongmoryteam.presentation.base.ViewState

class LoginContract {
    data class LoginState(
        val loginLoadState: LoadState = LoadState.SUCCESS,
        val phoneNumber: String? = null,
    ): ViewState

    sealed class LoginEvent : ViewEvent {
        object GetCertificationButtonClicked : LoginEvent()
        object PostCertificationButtonClicked : LoginEvent()
        object ToTermScreenButtonClicked : LoginEvent()
    }

    sealed class LoginEffect : ViewSideEffect {
        object MoveToTerm: LoginEffect()
        object SuccessCertification: LoginEffect()
        object FailCertification: LoginEffect()
    }
}