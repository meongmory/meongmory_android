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
        val isError: Boolean = true
    ) : ViewState

    sealed class MyPageProfileSideEffect: ViewSideEffect {
        object NavigateToHome : MyPageProfileSideEffect()
    }

    sealed class MyPageProfileEvent: ViewEvent {
        data class FillNickName(
            val nickName: String
        ) : MyPageProfileEvent()
        object ClearNickName: MyPageProfileEvent()
        object OnClickChangeButton: MyPageProfileEvent()
    }
}