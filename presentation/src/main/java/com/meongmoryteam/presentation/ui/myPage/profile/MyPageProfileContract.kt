package com.meongmoryteam.presentation.ui.myPage.profile

import com.meongmoryteam.presentation.base.LoadState
import com.meongmoryteam.presentation.base.ViewState

class MyPageProfileContract {
    // 모델 클래스
    data class MyPageUiState(
        val loadState: LoadState = LoadState.SUCCESS,
        val nickname: String = ""
    ) : ViewState
}