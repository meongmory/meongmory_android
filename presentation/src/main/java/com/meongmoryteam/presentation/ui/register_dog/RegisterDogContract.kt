package com.meongmoryteam.presentation.ui.register_dog

import com.meongmoryteam.presentation.base.LoadState
import com.meongmoryteam.presentation.base.ViewEvent
import com.meongmoryteam.presentation.base.ViewSideEffect
import com.meongmoryteam.presentation.base.ViewState

class RegisterDogContract {
    data class RegisterDogViewState(
        val loadState: LoadState = LoadState.SUCCESS,
        val name: String = "",
        val breed: String = "",
        val age: String = "",
        val year: String = "",
        val month: String = "",
        val day: String = "",
        val registrationNumber: String = "",
        val isAllFilled: Boolean = false,
        val petType: String = "",
        val gender: String = "",
        val isSelected: Boolean = false
    ) : ViewState

    sealed class RegisterDogSideEffect : ViewSideEffect {
        object NavigateToSearchBreedScreen : RegisterDogSideEffect()
        object NavigateToNextScreen : RegisterDogSideEffect()
        object NavigateToPreviousScreen : RegisterDogSideEffect()
        data class NavigateToRegisterScreen(val breed: String) : RegisterDogSideEffect()
    }

    sealed class RegisterDogEvent : ViewEvent {
        data class FillInName(val name: String) : RegisterDogEvent()
        data class FillInBreed(val breed: String) : RegisterDogEvent()
        data class FillInAge(val age: String) : RegisterDogEvent()
        data class FillInYear(val year: String) : RegisterDogEvent()
        data class FillInMonth(val month: String) : RegisterDogEvent()
        data class FillInDay(val day: String) : RegisterDogEvent()
        data class FillInRegistrationNum(val num: String) : RegisterDogEvent()
        data class OnPetTypeClicked(val petType: String) : RegisterDogEvent()
        data class OnBreedClicked(val breed: String) : RegisterDogEvent()
        data class OnGenderClicked(val gender: String) : RegisterDogEvent()
        object OnClickSearchButton : RegisterDogEvent()
        object OnClickMakeButton : RegisterDogEvent()
        object OnClickBackButton : RegisterDogEvent()
        data class OnClickSelectButton(val breed: String) : RegisterDogEvent()
    }
}