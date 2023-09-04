package com.meongmoryteam.presentation.ui.register_dog

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.meongmoryteam.domain.model.reqeust.pet.RegisterPetRequestEntity
import com.meongmoryteam.domain.usecase.pet.GetSearchBreedUseCase
import com.meongmoryteam.domain.usecase.pet.PostRegisterPetUseCase
import com.meongmoryteam.presentation.base.BaseViewModel
import com.meongmoryteam.presentation.base.LoadState
import com.meongmoryteam.presentation.ui.register_dog.RegisterDogContract.RegisterDogEvent
import com.meongmoryteam.presentation.ui.register_dog.RegisterDogContract.RegisterDogSideEffect
import com.meongmoryteam.presentation.ui.register_dog.RegisterDogContract.RegisterDogViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterDogViewModel @Inject constructor(
    private val postRegisterPetUseCase: PostRegisterPetUseCase,
    private val getSearchBreedUseCase: GetSearchBreedUseCase
) :
    BaseViewModel<RegisterDogViewState, RegisterDogSideEffect, RegisterDogEvent>(
        RegisterDogViewState()
    ) {
    override fun handleEvents(event: RegisterDogEvent) {
        when (event) {
            is RegisterDogEvent.InitList -> getSearchBreed()
            is RegisterDogEvent.FillInName -> reflectUpdateState(name = event.name)
            is RegisterDogEvent.FillInBreed -> reflectUpdateState(breed = event.breed)
            is RegisterDogEvent.FillInAge -> reflectUpdateState(age = event.age)
            is RegisterDogEvent.FillInYear -> reflectUpdateState(year = event.year)
            is RegisterDogEvent.FillInMonth -> reflectUpdateState(month = event.month)
            is RegisterDogEvent.FillInDay -> reflectUpdateState(day = event.day)
            is RegisterDogEvent.FillInRegistrationNum -> reflectUpdateState(registrationNumber = event.num)
            is RegisterDogEvent.OnPetTypeClicked -> reflectUpdateState(animalType = event.petType)
            is RegisterDogEvent.OnBreedClicked -> {
                reflectUpdateState(breed = event.breed)
            }

            is RegisterDogEvent.SetAnimalID -> reflectUpdateState(animalId = event.animalId)
            is RegisterDogEvent.OnGenderClicked -> reflectUpdateState(gender = event.gender)
            is RegisterDogEvent.OnClickSearchButton -> {
                getSearchBreed()
            }

            is RegisterDogEvent.OnClickBackButton -> sendEffect({ RegisterDogSideEffect.NavigateToPreviousScreen })
            is RegisterDogEvent.OnClickMakeButton -> {
                postRegisterPet()
            }

            is RegisterDogEvent.OnClickSelectButton -> sendEffect({
                RegisterDogSideEffect.NavigateToRegisterScreen(
                    breed = event.breed,
                    animalId = event.animalId
                )
            })
        }
    }

    private fun getSearchBreed() {
        viewModelScope.launch {
            getSearchBreedUseCase(
                null,
                viewState.value.breed,
                null,
                null,
                viewState.value.petType
            ).onSuccess {
                updateState {
                    copy(
                        getBreedLoadState = LoadState.SUCCESS,
                        content = it.data.animalTypeLists.content
                    )
                }
                Log.d("getSearchBreed", "${viewState.value.content}")

                sendEffect({ RegisterDogSideEffect.NavigateToSearchBreedScreen })
            }.onFailure {
                updateState {
                    copy(
                        getBreedLoadState = LoadState.ERROR
                    )
                }
                Log.d("getSearchBreed", "${it.cause} | ${it.message}")
            }
        }
    }

    private fun postRegisterPet() {
        val registerPetRequest = RegisterPetRequestEntity(
            "${viewState.value.year}-${viewState.value.month}-${viewState.value.day}",
            viewState.value.animalId,
            viewState.value.age,
            viewState.value.gender,
            viewState.value.imgKey,
            viewState.value.name,
            viewState.value.registrationNumber
        )
        viewModelScope.launch {
            postRegisterPetUseCase(viewState.value.familyId, registerPetRequest).onSuccess {
                updateState {
                    copy(
                        postRegisterPetLoadState = LoadState.SUCCESS
                    )
                }
                sendEffect({ RegisterDogSideEffect.NavigateToNextScreen })
            }.onFailure {
                updateState {
                    copy(
                        postRegisterPetLoadState = LoadState.ERROR
                    )
                }
                Log.d("postRegisterPet", "${it.cause} | ${it.message}")
            }
        }
    }

    private fun reflectUpdateState(
        name: String = viewState.value.name,
        breed: String = viewState.value.breed,
        age: Int = viewState.value.age,
        year: String = viewState.value.year,
        month: String = viewState.value.month,
        day: String = viewState.value.day,
        registrationNumber: Int = viewState.value.registrationNumber,
        animalType: String = viewState.value.petType,
        gender: String = viewState.value.gender,
        animalId: Int = viewState.value.animalId
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
                petType = animalType,
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
                isSelected = isConfirmed(animalType, breed),
                animalId = animalId
            )
        }
    }

    private fun isFilled(
        name: String,
        breed: String,
        age: Int,
        year: String,
        month: String,
        day: String,
        registrationNumber: Int,
        gender: String
    ): Boolean {
        return (name.isNotEmpty() && breed.isNotEmpty() && (age != -1) && year.isNotEmpty() && month.isNotEmpty() && day.isNotEmpty() && (registrationNumber != 0) && gender.isNotEmpty())
    }

    private fun isConfirmed(
        petType: String,
        breed: String
    ): Boolean {
        return (breed.isNotEmpty())
    }
}