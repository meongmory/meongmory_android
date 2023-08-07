package com.meongmoryteam.presentation.ui.myPage.profile

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.meongmoryteam.presentation.base.BaseViewModel
import com.meongmoryteam.presentation.base.LoadState
import com.meongmoryteam.presentation.ui.myPage.profile.MyPageProfileContract.MyPageProfileEvent
import com.meongmoryteam.presentation.ui.myPage.profile.MyPageProfileContract.MyPageProfileSideEffect
import com.meongmoryteam.presentation.ui.myPage.profile.MyPageProfileContract.MyPageProfileViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyPageProfileViewModel @Inject constructor(
    private val saveStateHandle: SavedStateHandle,
) : BaseViewModel<MyPageProfileViewState, MyPageProfileSideEffect, MyPageProfileEvent>(
    MyPageProfileViewState()
) {
    override fun handleEvents(event: MyPageProfileEvent) {
        when (event) {
            MyPageProfileEvent.ClearNickName -> reflectUpdatedState("")
            is MyPageProfileEvent.FillNickName -> reflectUpdatedState(event.nickName)
            MyPageProfileEvent.OnClickChangeButton -> changeNickName(viewState.value.nickName)
        }
    }

    private fun reflectUpdatedState(
        nickName: String = viewState.value.nickName
    ) {
        updateState {
            copy(
                nickName = nickName,
                isError = isOverflowed(nickName)
            )
        }
    }

    private fun changeNickName(nickName: String) = viewModelScope.launch {
        updateState {
            copy(
                loadState = LoadState.LOADING
            )
        }
    }

    // 텍스트 길이 초과
    private fun isOverflowed(nickName: String): Boolean {
        return nickName.isBlank() || (nickName.length > MAX_LENGTH_NICKNAME)
    }
}

const val MAX_LENGTH_NICKNAME = 6
