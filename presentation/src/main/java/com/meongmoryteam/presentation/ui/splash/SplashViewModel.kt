package com.meongmoryteam.presentation.ui.splash

import com.meongmoryteam.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import com.meongmoryteam.presentation.ui.splash.SplashContract.SplashState
import com.meongmoryteam.presentation.ui.splash.SplashContract.SplashEffect
import com.meongmoryteam.presentation.ui.splash.SplashContract.SplashEvent
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(

): BaseViewModel<SplashState, SplashEffect, SplashEvent>(
    SplashState()
) {

    override fun handleEvents(event: SplashEvent) {
        when(event) {
            is SplashEvent.ToLoginButtonClicked -> {
                sendEffect({ SplashEffect.MoveToLogin })
            }
        }
    }
}