package com.meongmoryteam.presentation.ui.register_family

import com.meongmoryteam.presentation.base.BaseViewModel
import com.meongmoryteam.presentation.base.LoadState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import com.meongmoryteam.presentation.ui.register_family.RegisterFamilyContract.RegisterFamilyViewState
import com.meongmoryteam.presentation.ui.register_family.RegisterFamilyContract.RegisterFamilySideEffect
import com.meongmoryteam.presentation.ui.register_family.RegisterFamilyContract.RegisterFamilyEvent


@HiltViewModel
class RegisterFamilyViewModel @Inject constructor() :
    BaseViewModel<RegisterFamilyViewState, RegisterFamilySideEffect, RegisterFamilyEvent>(
        RegisterFamilyViewState()
    ) {
    override fun handleEvents(event: RegisterFamilyEvent) {
        when (event) {
            is RegisterFamilyEvent.FillInFamilyName -> reflectUpdateState(familyName = event.familyName)
            is RegisterFamilyEvent.FillInCode -> reflectUpdateState(code = event.code)
            is RegisterFamilyEvent.OnClickBackButton -> sendEffect({ RegisterFamilySideEffect.NavigateToPreviousScreen })
            is RegisterFamilyEvent.OnClickMakeButton -> sendEffect({ RegisterFamilySideEffect.NavigateToNextScreen })
            is RegisterFamilyEvent.OnClickNextButton -> sendEffect({ RegisterFamilySideEffect.NavigateToNextScreen })
            is RegisterFamilyEvent.OnClickOkButton -> reflectUpdateState()
            is RegisterFamilyEvent.OnClickRegisterCodeButton -> sendEffect({RegisterFamilySideEffect.NavigateToRegisterCodeScreen})
            is RegisterFamilyEvent.OnClickRegisterNameButton -> sendEffect({RegisterFamilySideEffect.NavigateToRegisterNameScreen})
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