package com.meongmoryteam.presentation.ui.register_dog

import com.meongmoryteam.domain.model.response.pet.SearchBreedResponse
import com.meongmoryteam.presentation.base.LoadState
import com.meongmoryteam.presentation.base.ViewEvent
import com.meongmoryteam.presentation.base.ViewSideEffect
import com.meongmoryteam.presentation.base.ViewState

class RegisterDogContract {
    data class RegisterDogViewState(
        val postRegisterPetLoadState: LoadState = LoadState.SUCCESS,
        val getBreedLoadState: LoadState = LoadState.SUCCESS,
        val name: String = "",
        val breed: String = "",
        val age: Int = 0,
        val year: String = "",
        val month: String = "",
        val day: String = "",
        val registrationNumber: Int = 0,
        val isAllFilled: Boolean = false,
        val petType: String = "",
        val gender: String = "",
        val isSelected: Boolean = false,
        val imgKey: String = "",
        val familyId: Int = 0,
        val animalId: Int = 0,
        val content: MutableList<SearchBreedResponse> = mutableListOf()
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
        data class FillInAge(val age: Int) : RegisterDogEvent()
        data class FillInYear(val year: String) : RegisterDogEvent()
        data class FillInMonth(val month: String) : RegisterDogEvent()
        data class FillInDay(val day: String) : RegisterDogEvent()
        data class FillInRegistrationNum(val num: Int) : RegisterDogEvent()
        data class OnPetTypeClicked(val petType: String) : RegisterDogEvent()
        data class OnBreedClicked(val breed: String) : RegisterDogEvent()
        data class OnGenderClicked(val gender: String) : RegisterDogEvent()
        object OnClickSearchButton : RegisterDogEvent()
        object OnClickMakeButton : RegisterDogEvent()
        object OnClickBackButton : RegisterDogEvent()
        data class OnClickSelectButton(val breed: String) : RegisterDogEvent()
    }
}