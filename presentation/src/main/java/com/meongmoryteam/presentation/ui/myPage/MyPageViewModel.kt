package com.meongmoryteam.presentation.ui.myPage

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.meongmoryteam.domain.usecase.login.GetUserMyPageUseCase
import com.meongmoryteam.presentation.base.BaseViewModel
import com.meongmoryteam.presentation.base.LoadState
import com.meongmoryteam.presentation.ui.myPage.MyPageContract.MyPageEvent
import com.meongmoryteam.presentation.ui.myPage.MyPageContract.MyPageSideEffect
import com.meongmoryteam.presentation.ui.myPage.MyPageContract.MyPageViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MyPageViewModel @Inject constructor(
    private val getUserMyPageUseCase: GetUserMyPageUseCase,
) : BaseViewModel<MyPageViewState, MyPageSideEffect, MyPageEvent>(
    MyPageViewState()
) {
    val refreshButton = mutableStateOf(false)

    override fun handleEvents(event: MyPageEvent) {
        when (event) {
            is MyPageEvent.InitMyPageScreen -> {
                updateState { copy(loadState = LoadState.SUCCESS) }
            }

            is MyPageEvent.OnClickProfileEditButtonClicked -> {
                sendEffect({ MyPageSideEffect.NavigateToEditProfile })
            }

            is MyPageEvent.OnQuestionClicked -> {
                sendEffect({ MyPageSideEffect.NavigateToQuestion })
            }
        }
    }

    private fun getUserMyPage() {
        viewModelScope.launch {
            getUserMyPageUseCase().onSuccess {
                updateState {
                    copy(

                    )
                }
            }.onFailure {
                updateState {
                    copy(

                    )
                }
            }
        }
    }
}