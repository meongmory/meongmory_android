package com.meongmoryteam.presentation.ui.main

import com.meongmoryteam.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import com.meongmoryteam.presentation.ui.main.HomeContract.*

@HiltViewModel
class HomeViewModel @Inject constructor(
) : BaseViewModel<HomeViewState, HomeSideEffect, HomeEvent>(
    HomeViewState()
) {
    override fun handleEvents(event: HomeEvent) {
    }
}