package com.meongmoryteam.meongmory.di

import com.meongmoryteam.data.datasource.family.FamilyDataSource
import com.meongmoryteam.data.datasource.family.FamilyDataSourceImpl
import com.meongmoryteam.data.datasource.login.LoginDataSource
import com.meongmoryteam.data.datasource.login.LoginDataSourceImpl
import com.meongmoryteam.data.repository.family.FamilyRepositoryImpl
import com.meongmoryteam.data.repository.login.LoginRepositoryImpl
import com.meongmoryteam.domain.repository.family.FamilyRepository
import com.meongmoryteam.data.datasource.logout.LogoutDataSource
import com.meongmoryteam.data.datasource.logout.LogoutDataSourceImpl
import com.meongmoryteam.data.datasource.mypage.MyPageDataSource
import com.meongmoryteam.data.datasource.mypage.MyPageDataSourceImpl
import com.meongmoryteam.data.repository.login.LoginRepositoryImpl
import com.meongmoryteam.data.repository.logout.LogoutRepositoryImpl
import com.meongmoryteam.data.repository.mypage.MyPageRepositoryImpl
import com.meongmoryteam.domain.repository.login.LoginRepository
import com.meongmoryteam.domain.repository.logout.LogoutRepository
import com.meongmoryteam.domain.repository.mypage.MyPageRepository
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
    abstract fun bindMyPageRepository(
        myPageRepositoryImpl: MyPageRepositoryImpl
    ): MyPageRepository

    @Singleton
    @Binds
    abstract fun bindMyPageDataSource(
        myPageDataSourceImpl: MyPageDataSourceImpl
    ): MyPageDataSource

    @Singleton
    @Binds
    abstract fun bindLogoutRepository(
        logoutRepositoryImpl: LogoutRepositoryImpl
    ): LogoutRepository

    @Singleton
    @Binds
    abstract fun bindLogoutDataSource(
        logoutDataSourceImpl: LogoutDataSourceImpl
    ): LogoutDataSource
}