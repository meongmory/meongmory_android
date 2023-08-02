package com.meongmoryteam.presentation.ui.register_family

import com.meongmoryteam.presentation.base.LoadState
import com.meongmoryteam.presentation.base.ViewEvent
import com.meongmoryteam.presentation.base.ViewSideEffect
import com.meongmoryteam.presentation.base.ViewState

class RegisterFamilyContract {
    data class RegisterFamilyViewState(
        val loadState: LoadState = LoadState.SUCCESS,
        val code: String = "",
        val familyName: String = "",
        val isFilledName: Boolean = false,
        val isFilledCode: Boolean = false,
        val invalidCode: Boolean = false
    ) : ViewState

    sealed class RegisterFamilySideEffect : ViewSideEffect {
        object NavigateToNextScreen : RegisterFamilySideEffect()
        object NavigateToPreviousScreen : RegisterFamilySideEffect()
    }

    sealed class RegisterFamilyEvent : ViewEvent {
        data class FillInFamilyName(val familyName: String) : RegisterFamilyEvent()
        data class FillInCode(val code: String) : RegisterFamilyEvent()

        //        object ClearFamilyName : RegisterFamilyEvent()
//        object ClearCode : RegisterFamilyEvent()
        object OnClickOkButton : RegisterFamilyEvent()
        object OnClickNextButton : RegisterFamilyEvent()
        object OnClickBackButton : RegisterFamilyEvent()
        object OnClickMakeButton : RegisterFamilyEvent()
    }
}