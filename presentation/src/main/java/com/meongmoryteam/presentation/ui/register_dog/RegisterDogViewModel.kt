package com.meongmoryteam.presentation.ui.register_dog

import com.meongmoryteam.presentation.base.BaseViewModel
import com.meongmoryteam.presentation.ui.register_dog.RegisterDogContract.RegisterDogEvent
import com.meongmoryteam.presentation.ui.register_dog.RegisterDogContract.RegisterDogSideEffect
import com.meongmoryteam.presentation.ui.register_dog.RegisterDogContract.RegisterDogViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterDogViewModel @Inject constructor() :
    BaseViewModel<RegisterDogViewState, RegisterDogSideEffect, RegisterDogEvent>(
        RegisterDogViewState()
    ) {
    override fun handleEvents(event: RegisterDogEvent) {
        when (event) {
            is RegisterDogEvent.FillInName -> reflectUpdateState(name = event.name)
            is RegisterDogEvent.FillInBreed -> reflectUpdateState(breed = event.breed)
            is RegisterDogEvent.FillInAge -> reflectUpdateState(age = event.age)
            is RegisterDogEvent.FillInYear -> reflectUpdateState(year = event.year)
            is RegisterDogEvent.FillInMonth -> reflectUpdateState(month = event.month)
            is RegisterDogEvent.FillInDay -> reflectUpdateState(day = event.day)
            is RegisterDogEvent.FillInRegistrationNum -> reflectUpdateState(registrationNumber = event.num)

            is RegisterDogEvent.OnClickSearchButton -> sendEffect({ RegisterDogSideEffect.NavigateToSearchBreedScreen })
            is RegisterDogEvent.OnClickBackButton -> sendEffect({ RegisterDogSideEffect.NavigateToPreviousScreen })
            is RegisterDogEvent.OnClickMakeButton -> sendEffect({ RegisterDogSideEffect.NavigateToNextScreen })
        }
    }

    private fun reflectUpdateState(
        name: String = viewState.value.name,
        breed: String = viewState.value.breed,
        age: String = viewState.value.age,
        year: String = viewState.value.year,
        month: String = viewState.value.month,
        day: String = viewState.value.day,
        registrationNumber: String = viewState.value.registrationNumber
    ) {
        updateState {
            copy(
                name = name,
                breed = breed,
                age = age,
                year = year,
                month = month,
                day = day,
                registrationNumber = registrationNumber,
                isAllFilled = isFilled(
                    name,
                    breed,
                    age,
                    year,
                    month,
                    day,
                    registrationNumber
                )
            )
        }
    }

    private fun isFilled(
        name: String,
        breed: String,
        age: String,
        year: String,
        month: String,
        day: String,
        registrationNumber: String
    ): Boolean {
        return (name.isNotEmpty() && breed.isNotEmpty() && age.isNotEmpty() && year.isNotEmpty() && month.isNotEmpty() && day.isNotEmpty() && registrationNumber.isNotEmpty())
    }
}