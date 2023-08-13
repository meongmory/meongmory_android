package com.meongmoryteam.presentation.ui.myPage.question

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
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
    private val _refreshButton = mutableStateOf(false)
    val refreshButton: State<Boolean> = _refreshButton

    override fun handleEvents(event: MyPageQuestionEvent) {
        when (event) {
            MyPageQuestionEvent.ClearEmail -> reflectUpdatedState(email = "")
            MyPageQuestionEvent.ClearQuestion -> reflectUpdatedState(question = "")
            is MyPageQuestionEvent.FillEmail -> reflectUpdatedState(email = event.email)
            is MyPageQuestionEvent.FillQuestion -> reflectUpdatedState(question = event.question)
            MyPageQuestionEvent.OnClickPreviousButton -> _refreshButton.value = true
            is MyPageQuestionEvent.OnClickPostButton -> {
                setEmail()
                _refreshButton.value = true
            }
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

    private fun setEmail(
        email: String = viewState.value.email,
        question: String = viewState.value.question
    ) = viewModelScope.launch {
        updateState {
            copy(
                loadState = LoadState.SUCCESS,
                email = email,
                question = question
            )
        }
        sendEffect({ MyPageQuestionSideEffect.NavigateToMyPageScreen })
    }

    private fun isFilled(
        email: String,
        question: String,
    ): Boolean {
        return (email.isNotEmpty() && question.isNotEmpty())
    }
}