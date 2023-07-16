package com.meongmoryteam.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.meongmoryteam.domain.model.Result
import com.meongmoryteam.domain.usecase.GetWeekFoodUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExampleViewModel @Inject constructor(
    private val getWeekFoodUseCase: GetWeekFoodUseCase
) : ViewModel() {

    private val _weekGetFoodArea = MutableStateFlow<ExampleFoodState>(ExampleFoodState.UnInitialized)
    val weekGetFoodArea: StateFlow<ExampleFoodState> = _weekGetFoodArea.asStateFlow()

    fun getWeekFood(area: String) {
        viewModelScope.launch {
            when(val result = getWeekFoodUseCase(area)) {
                is Result.Success -> {
                    _weekGetFoodArea.value = ExampleFoodState.SuccessWeekFoodGetData(result.data)
                }
                is Result.Error -> {
                    _weekGetFoodArea.value = ExampleFoodState.Error(result.exception)
                }
            }
        }
    }
}