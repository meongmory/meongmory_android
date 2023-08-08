package com.meongmoryteam.presentation.ui.myPage

import androidx.lifecycle.SavedStateHandle
import com.meongmoryteam.presentation.base.BaseViewModel
import com.meongmoryteam.presentation.base.LoadState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import com.meongmoryteam.presentation.ui.myPage.MyPageContract.*


@HiltViewModel
class MyPageViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : BaseViewModel<MyPageViewState, MyPageSideEffect, MyPageEvent>(
    MyPageViewState()
) {
    override fun handleEvents(event: MyPageEvent) {
        when (event) {
            is MyPageEvent.OnClickProfileEditButtonClicked -> {
                sendEffect({ MyPageSideEffect.EditNickName })
            }
            is MyPageEvent.OnClickQuestionButtonClicked -> {
                sendEffect({ MyPageSideEffect.NavigateToQuestion })
            }
        }
    }
}