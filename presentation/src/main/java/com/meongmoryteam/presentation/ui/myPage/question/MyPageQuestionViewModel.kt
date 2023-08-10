package com.meongmoryteam.presentation.ui.myPage.question

import androidx.lifecycle.viewModelScope
import com.meongmoryteam.presentation.base.BaseViewModel
import com.meongmoryteam.presentation.base.LoadState
import com.meongmoryteam.presentation.ui.myPage.question.MyPageQuestionConstract.MyPageQuestionEvent
import com.meongmoryteam.presentation.ui.myPage.question.MyPageQuestionConstract.MyPageQuestionSideEffect
import com.meongmoryteam.presentation.ui.myPage.question.MyPageQuestionConstract.MyPageQuestionViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyPageQuestionViewModel @Inject constructor(
) : BaseViewModel<MyPageQuestionViewState, MyPageQuestionSideEffect, MyPageQuestionEvent>(
    MyPageQuestionViewState()
) {
    override fun handleEvents(event: MyPageQuestionEvent) {
        when (event) {
            MyPageQuestionEvent.ClearEmail -> reflectUpdatedState("")
            is MyPageQuestionEvent.FillEmail -> reflectUpdatedState(event.email)
            MyPageQuestionEvent.OnClickButton -> setEmail(viewState.value.email)
        }
    }

    private fun reflectUpdatedState(
        email: String = viewState.value.email
    ) {
        updateState {
            copy(
                email = email,
            )
        }
    }

    private fun setEmail(email: String) = viewModelScope.launch {
        updateState {
            copy(
                loadState = LoadState.LOADING
            )
        }
    }
}