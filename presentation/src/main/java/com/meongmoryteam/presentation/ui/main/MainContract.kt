package com.meongmoryteam.presentation.ui.main

import com.meongmoryteam.presentation.base.ViewEvent
import com.meongmoryteam.presentation.base.ViewSideEffect
import com.meongmoryteam.presentation.base.ViewState

class MainContract {
    object MainViewState : ViewState

    sealed class MainSideEffect : ViewSideEffect {
        object RefreshScreen : MainSideEffect()
    }

    sealed class MainEvent : ViewEvent {
        object FinishedCreateActivity : MainEvent()
    }
}