package com.meongmoryteam.meongmory.di

import com.meongmoryteam.data.datasource.login.LoginDataSource
import com.meongmoryteam.data.datasource.login.LoginDataSourceImpl
import com.meongmoryteam.data.repository.login.LoginRepositoryImpl
import com.meongmoryteam.domain.repository.login.LoginRepository
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
}