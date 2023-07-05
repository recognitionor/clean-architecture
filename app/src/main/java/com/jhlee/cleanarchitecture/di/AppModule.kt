package com.jhlee.cleanarchitecture.di

import com.jhlee.cleanarchitecture.data.remote.ApiService
import com.jhlee.cleanarchitecture.data.repository.CoinRepositoryImpl
import com.jhlee.cleanarchitecture.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideApiService(): ApiService {
        return Retrofit.Builder().baseUrl("https://api.coinpaprika.com")
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepo(apiService: ApiService): CoinRepository {
        return CoinRepositoryImpl(apiService)
    }
}