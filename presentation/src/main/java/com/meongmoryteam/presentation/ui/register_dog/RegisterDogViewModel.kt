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
            is RegisterDogEvent.OnPetTypeClicked -> reflectUpdateState(petType = event.petType)
            is RegisterDogEvent.OnBreedClicked -> reflectUpdateState(breed = event.breed)
            is RegisterDogEvent.OnGenderClicked -> reflectUpdateState(gender = event.gender)
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
        registrationNumber: String = viewState.value.registrationNumber,
        petType: String = viewState.value.petType,
        gender: String = viewState.value.gender
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
                petType = petType,
                gender = gender,
                isAllFilled = isFilled(
                    name,
                    breed,
                    age,
                    year,
                    month,
                    day,
                    registrationNumber,
                    gender
                ),
                isSelected = isConfirmed(petType, breed)
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
        registrationNumber: String,
        gender: String
    ): Boolean {
        return (name.isNotEmpty() && breed.isNotEmpty() && age.isNotEmpty() && year.isNotEmpty() && month.isNotEmpty() && day.isNotEmpty() && registrationNumber.isNotEmpty() && gender.isNotEmpty())
    }

    private fun isConfirmed(
        petType: String,
        breed: String
    ): Boolean{
        return (petType.isNotEmpty() && breed.isNotEmpty())
    }
}