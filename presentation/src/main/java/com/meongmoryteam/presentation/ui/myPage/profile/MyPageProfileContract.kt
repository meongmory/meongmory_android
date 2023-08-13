package com.meongmoryteam.presentation.ui.myPage.profile

import com.meongmoryteam.presentation.base.LoadState
import com.meongmoryteam.presentation.base.ViewEvent
import com.meongmoryteam.presentation.base.ViewSideEffect
import com.meongmoryteam.presentation.base.ViewState

class MyPageProfileContract {
    // 모델 클래스
    data class MyPageProfileViewState(
        val loadState: LoadState = LoadState.SUCCESS,
        val nickName: String = "",
        val nickNameHint: String = "",
        val isFilled: Boolean = false,
        val isError: Boolean = true
    ) : ViewState

    sealed class MyPageProfileSideEffect : ViewSideEffect {
        object NavigateToMyPageScreen : MyPageProfileSideEffect()
    }

    sealed class MyPageProfileEvent : ViewEvent {
        data class FillNickName(
            val nickName: String
        ) : MyPageProfileEvent()

        object ClearNickName : MyPageProfileEvent()
        object OnClickPreviousButton : MyPageProfileEvent()
        object OnClickChangeButton : MyPageProfileEvent()
    }
}