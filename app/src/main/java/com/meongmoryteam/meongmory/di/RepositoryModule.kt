package com.meongmoryteam.meongmory.di

import com.meongmoryteam.data.datasource.FoodDataSource
import com.meongmoryteam.data.datasource.FoodDataSourceImpl
import com.meongmoryteam.data.repository.FoodRepositoryImpl
import com.meongmoryteam.domain.repository.FoodRepository
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
    abstract fun bindFoodRepository(
        foodRepositoryImpl: FoodRepositoryImpl,
    ) : FoodRepository

    @Singleton
    @Binds
    abstract fun bindFoodV2DataSource(
        foodDataSourceImpl: FoodDataSourceImpl
    ): FoodDataSource
}