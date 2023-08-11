package com.meongmoryteam.presentation.ui.myPage.question

import com.meongmoryteam.presentation.base.LoadState
import com.meongmoryteam.presentation.base.ViewEvent
import com.meongmoryteam.presentation.base.ViewSideEffect
import com.meongmoryteam.presentation.base.ViewState

class MyPageQuestionConstract {
    data class MyPageQuestionViewState(
        val loadState: LoadState = LoadState.SUCCESS,
        val email: String = "",
        val question: String = "",
        val isError: Boolean = true,
        val isAllFilled: Boolean = false,
    ) : ViewState

    sealed class MyPageQuestionSideEffect : ViewSideEffect {
        object NavigateToPreviousScreen : MyPageQuestionSideEffect()
    }

    sealed class MyPageQuestionEvent : ViewEvent {
        data class FillEmail(
            val email: String
        ) : MyPageQuestionEvent()

        data class FillQuestion(
            val question: String
        ) : MyPageQuestionEvent()

        object ClearEmail : MyPageQuestionEvent()
        object ClearQuestion : MyPageQuestionEvent()
        object OnClickButton : MyPageQuestionEvent()
    }
}