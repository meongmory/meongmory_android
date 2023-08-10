package com.meongmoryteam.presentation.ui.main

import com.meongmoryteam.presentation.base.ViewEvent
import com.meongmoryteam.presentation.base.ViewSideEffect
import com.meongmoryteam.presentation.base.ViewState

class HomeContract {
    data class HomeViewState(
        val loginState: LoginState = LoginState.NONE,
    ) : ViewState

    sealed class HomeSideEffect : ViewSideEffect {
    }

    sealed class HomeEvent : ViewEvent {
    }

    enum class LoginState {
        NONE, LOGIN
    }
}