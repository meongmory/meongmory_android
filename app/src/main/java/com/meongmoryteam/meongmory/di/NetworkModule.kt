package com.meongmoryteam.meongmory.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.meongmoryteam.data.service.ExampleApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private val contentType = "application/json".toMediaType()
    private val json = Json { ignoreUnknownKeys = true }

    private const val BASE_URL = "http://52.79.149.29/"

    @Provides
    @Singleton
    fun provideClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(100, TimeUnit.SECONDS)
            .readTimeout(100, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(json.asConverterFactory(contentType))
            .client(client)
            .build()
    }

    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit): ExampleApi {
        return retrofit.create(ExampleApi::class.java)
    }
}