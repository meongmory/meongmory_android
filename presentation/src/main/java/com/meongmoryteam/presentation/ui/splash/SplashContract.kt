package com.meongmoryteam.presentation.ui.splash

import com.meongmoryteam.presentation.base.LoadState
import com.meongmoryteam.presentation.base.ViewEvent
import com.meongmoryteam.presentation.base.ViewSideEffect
import com.meongmoryteam.presentation.base.ViewState

class SplashContract {

    data class SplashState(
        val splashLoadState: LoadState = LoadState.SUCCESS
    ): ViewState

    sealed class SplashEvent : ViewEvent {
        object ToLoginButtonClicked : SplashEvent()
    }

    sealed class SplashEffect : ViewSideEffect {
        object MoveToLogin: SplashEffect()
    }
}