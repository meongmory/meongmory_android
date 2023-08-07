package com.meongmoryteam.presentation.ui.myPage.profile

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MyPageProfileViewModel @Inject constructor(
    private val saveStateHandle: SavedStateHandle,
) : ViewModel() {
    private val _uiState = MutableStateFlow(MyPageProfileContract.MyPageUiState())
    private lateinit var currentProfile: String
    // asStateFlow() -> 변경 가능 상태 흐름을 읽기 전용 상태 흐름으로 만든다
    val uiState: StateFlow<MyPageProfileContract.MyPageUiState> = _uiState.asStateFlow()
}