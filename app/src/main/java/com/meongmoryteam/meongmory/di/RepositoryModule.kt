package com.meongmoryteam.meongmory.di

import com.meongmoryteam.data.datasource.family.FamilyDataSource
import com.meongmoryteam.data.datasource.family.FamilyDataSourceImpl
import com.meongmoryteam.data.datasource.login.LoginDataSource
import com.meongmoryteam.data.datasource.login.LoginDataSourceImpl
import com.meongmoryteam.data.datasource.pet.PetDataSource
import com.meongmoryteam.data.datasource.pet.PetDataSourceImpl
import com.meongmoryteam.data.repository.family.FamilyRepositoryImpl
import com.meongmoryteam.data.repository.login.LoginRepositoryImpl
import com.meongmoryteam.data.repository.pet.PetRepositoryImpl
import com.meongmoryteam.domain.repository.family.FamilyRepository
import com.meongmoryteam.domain.repository.login.LoginRepository
import com.meongmoryteam.domain.repository.pet.PetRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindLoginRepository(
        loginRepositoryImpl: LoginRepositoryImpl
    ): LoginRepository

    @Singleton
    @Binds
    abstract fun bindLoginDataSource(
        loginDataSourceImpl: LoginDataSourceImpl
    ): LoginDataSource

    @Singleton
    @Binds
    abstract fun bindFamilyRepository(
        familyRepositoryImpl: FamilyRepositoryImpl
    ): FamilyRepository

    @Singleton
    @Binds
    abstract fun bindFamilyDataSource(
        familyDataSourceImpl: FamilyDataSourceImpl
    ): FamilyDataSource

    @Singleton
    @Binds
    abstract fun bindPetRepository(
        petRepositoryImpl: PetRepositoryImpl
    ): PetRepository

    @Singleton
    @Binds
    abstract fun bindPetDataSource(
        petDataSourceImpl: PetDataSourceImpl
    ): PetDataSource
}