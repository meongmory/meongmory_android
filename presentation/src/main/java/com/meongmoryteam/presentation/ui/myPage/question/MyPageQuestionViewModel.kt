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
            MyPageQuestionEvent.ClearEmail -> reflectUpdatedState(email = "")
            MyPageQuestionEvent.ClearQuestion -> reflectUpdatedState(question = "")
            is MyPageQuestionEvent.FillEmail -> reflectUpdatedState(email = event.email)
            is MyPageQuestionEvent.FillQuestion -> reflectUpdatedState(question = event.question)
            MyPageQuestionEvent.OnClickButton -> setEmail(viewState.value.email)
        }
    }

    private fun reflectUpdatedState(
        email: String = viewState.value.email,
        question: String = viewState.value.question
    ) {
        updateState {
            copy(
                email = email,
                question = question,
                isAllFilled = isFilled(
                    email,
                    question
                )
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

    private fun isFilled(
        email: String,
        question: String,
    ): Boolean {
        return (email.isNotEmpty() && question.isNotEmpty())
    }
}