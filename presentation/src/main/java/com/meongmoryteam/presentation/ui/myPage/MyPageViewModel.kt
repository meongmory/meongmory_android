package com.meongmoryteam.presentation.ui.myPage

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.meongmoryteam.domain.usecase.logout.DeleteUserUseCase
import com.meongmoryteam.domain.usecase.logout.PostUserLogoutUseCase
import com.meongmoryteam.domain.usecase.mypage.GetUserMyPageUseCase
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
    private val postUserLogoutUseCase: PostUserLogoutUseCase,
    private val postUserDeleteUserUseCase: DeleteUserUseCase
) : BaseViewModel<MyPageViewState, MyPageSideEffect, MyPageEvent>(
    MyPageViewState()
) {
    val refreshButton = mutableStateOf(false)

    override fun handleEvents(event: MyPageEvent) {
        when (event) {
            is MyPageEvent.InitMyPageScreen -> {
                updateState { copy(loadState = LoadState.SUCCESS) }
                getUserMyPage()
            }

            is MyPageEvent.OnClickProfileEditButtonClicked -> {
                sendEffect({ MyPageSideEffect.NavigateToEditProfile })
            }

            is MyPageEvent.OnQuestionClicked -> {
                sendEffect({ MyPageSideEffect.NavigateToQuestion })
            }

            is MyPageEvent.OnClickLogoutButtonClicked -> {
                postUserLogout()
                sendEffect({ MyPageSideEffect.NavigateToLogin })
            }

            is MyPageEvent.OnClickDeleteUserButtonClicked -> {
                postUserDelete()
                sendEffect({ MyPageSideEffect.NavigateToLogin })
            }
        }
    }

    private fun getUserMyPage() {
        viewModelScope.launch {
            getUserMyPageUseCase().onSuccess {
                updateState {
                    copy(
                        loadState = LoadState.SUCCESS
                    )
                }
            }.onFailure {
                updateState {
                    copy(
                        loadState = LoadState.ERROR
                    )
                }
            }
        }
    }

    private fun postUserLogout() {
        viewModelScope.launch {
            postUserLogoutUseCase().onSuccess {
                updateState {
                    copy(
                        loadState = LoadState.SUCCESS
                    )
                }
            }
        }
    }

    private fun postUserDelete() {
        viewModelScope.launch {
            postUserDeleteUserUseCase().onSuccess {
                updateState {
                    copy(
                        loadState = LoadState.SUCCESS
                    )
                }
            }
        }
    }
}