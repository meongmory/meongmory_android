package com.meongmoryteam.presentation.ui.myPage

import com.meongmoryteam.presentation.base.LoadState
import com.meongmoryteam.presentation.base.ViewEvent
import com.meongmoryteam.presentation.base.ViewSideEffect
import com.meongmoryteam.presentation.base.ViewState

class MyPageContract {
    data class MyPageViewState(
        val loadState: LoadState = LoadState.SUCCESS,
        val nickName: String = "",
        val isDialogVisible: Boolean = false
    ) : ViewState

    sealed class MyPageSideEffect : ViewSideEffect {
        object NavigateToEditProfile : MyPageSideEffect()
        object NavigateToQuestion : MyPageSideEffect()
        object NavigateToLogin : MyPageSideEffect()
    }

    sealed class MyPageEvent : ViewEvent {
        object InitMyPageScreen : MyPageEvent()
        object OnClickProfileEditButtonClicked : MyPageEvent()
        object OnQuestionClicked : MyPageEvent()
        object OnClickLogoutButtonClicked: MyPageEvent()
        object OnClickDeleteUserButtonClicked: MyPageEvent()
    }
}