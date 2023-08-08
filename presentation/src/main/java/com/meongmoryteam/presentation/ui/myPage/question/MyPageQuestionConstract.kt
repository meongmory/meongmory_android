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
        val isError: Boolean = true
    ) : ViewState

    sealed class MyPageQuestionSideEffect: ViewSideEffect {
        object NavigateToHome : MyPageQuestionSideEffect()
    }

    sealed class MyPageQuestionEvent: ViewEvent {
        data class FillEmail(
            val email: String
        ): MyPageQuestionEvent()
        object ClearEmail: MyPageQuestionEvent()
        object OnClickButton: MyPageQuestionEvent()
    }
}