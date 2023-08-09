package com.meongmoryteam.presentation.ui.main

import com.meongmoryteam.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import com.meongmoryteam.presentation.ui.main.MainContract.*

@HiltViewModel
class MainViewModel @Inject constructor() : BaseViewModel<MainViewState, MainSideEffect, MainEvent>(
    MainViewState()
) {
    override fun handleEvents(event: MainEvent) {
        when (event) {
            is MainEvent.OnBottomNavigationClicked -> {
            }
        }
    }
}