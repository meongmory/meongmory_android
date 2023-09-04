package com.meongmoryteam.presentation.ui.register_family

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.meongmoryteam.domain.model.reqeust.family.RegisterFamilyCodeRequestEntity
import com.meongmoryteam.domain.model.reqeust.family.RegisterFamilyNameRequestEntity
import com.meongmoryteam.domain.usecase.family.PostRegisterFamilyCodeUseCase
import com.meongmoryteam.domain.usecase.family.PostRegisterFamilyNameUseCase
import com.meongmoryteam.presentation.base.BaseViewModel
import com.meongmoryteam.presentation.ui.register_family.RegisterFamilyContract.RegisterFamilyEvent
import com.meongmoryteam.presentation.ui.register_family.RegisterFamilyContract.RegisterFamilySideEffect
import com.meongmoryteam.presentation.ui.register_family.RegisterFamilyContract.RegisterFamilyViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RegisterFamilyViewModel @Inject constructor(
    private val postRegisterWithCodeUseCase: PostRegisterFamilyCodeUseCase,
    private val postRegisterWithNameUseCase: PostRegisterFamilyNameUseCase
) :
    BaseViewModel<RegisterFamilyViewState, RegisterFamilySideEffect, RegisterFamilyEvent>(
        RegisterFamilyViewState()
    ) {
    override fun handleEvents(event: RegisterFamilyEvent) {
        when (event) {
            is RegisterFamilyEvent.FillInFamilyName -> reflectUpdateState(familyName = event.familyName)
            is RegisterFamilyEvent.FillInCode -> reflectUpdateState(code = event.code)
            is RegisterFamilyEvent.OnClickBackButton -> sendEffect({ RegisterFamilySideEffect.NavigateToPreviousScreen })
            is RegisterFamilyEvent.OnClickMakeButton -> {
//                sendEffect({ RegisterFamilySideEffect.NavigateToNextScreen })
                postRegisterWithName()
            }

            is RegisterFamilyEvent.OnClickNextButton -> sendEffect({ RegisterFamilySideEffect.NavigateToNextScreen })
            is RegisterFamilyEvent.OnClickOkButton -> {
                reflectUpdateState()
                postRegisterWithCode(code = event.code)
            }

            is RegisterFamilyEvent.OnClickRegisterCodeButton -> sendEffect({ RegisterFamilySideEffect.NavigateToRegisterCodeScreen })
            is RegisterFamilyEvent.OnClickRegisterNameButton -> {
                sendEffect({ RegisterFamilySideEffect.NavigateToRegisterNameScreen })
            }
        }
    }

    private fun postRegisterWithCode(code: String = viewState.value.code) {
        val registerFamilyCodeRequest = RegisterFamilyCodeRequestEntity(
            code
        )
        viewModelScope.launch {
            postRegisterWithCodeUseCase(
                registerFamilyCodeRequest
            ).onSuccess {
                updateState {
                    copy(
                        invalidCode = false
                    )
                }
                Log.d("post", "${it.data}")
            }.onFailure {
                updateState {
                    copy(
                        invalidCode = true
                    )
                }
                Log.d("postfail", "${it.message}")
            }
        }
    }

    //추후 familyId update
    private fun postRegisterWithName() {
        val registerFamilyNameRequest = RegisterFamilyNameRequestEntity(
            viewState.value.familyName
        )
        viewModelScope.launch {
            postRegisterWithNameUseCase(registerFamilyNameRequest).onSuccess {
                sendEffect({ RegisterFamilySideEffect.NavigateToNextScreen })
                Log.d("success", "등록 성공 | ${it.data} | ${it.message}")
            }.onFailure {
                Log.d("fail", "등록 실패 | ${it.cause} | ${it.message}")
            }
        }
    }

    private fun reflectUpdateState(
        familyName: String = viewState.value.familyName,
        code: String = viewState.value.code
    ) {
        updateState {
            copy(
                familyName = familyName,
                code = code,
                isFilledName = isFilled(familyName),
                isFilledCode = isFilled(code),
            )
        }
    }

    private fun isFilled(value: String): Boolean {
        return (value.isNotEmpty())
    }

}