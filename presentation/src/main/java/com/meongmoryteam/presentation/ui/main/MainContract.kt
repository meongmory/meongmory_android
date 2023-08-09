package com.meongmoryteam.presentation.ui.main

import com.meongmoryteam.presentation.base.ViewEvent
import com.meongmoryteam.presentation.base.ViewSideEffect
import com.meongmoryteam.presentation.base.ViewState

class MainContract {
    data class MainViewState(
         val loginState: LoginState = LoginState.NONE
    ) : ViewState

    sealed class MainSideEffect : ViewSideEffect {
        object Navigate
    }

    sealed class MainEvent : ViewEvent {
        object OnBottomNavigationClicked : MainEvent()
    }

    enum class LoginState {
        NONE, LOGIN
    }
}