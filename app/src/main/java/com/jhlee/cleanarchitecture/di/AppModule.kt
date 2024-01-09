package com.jhlee.cleanarchitecture.di

import com.jhlee.cleanarchitecture.common.URLInfo
import com.jhlee.cleanarchitecture.data.remote.ApiService
import com.jhlee.cleanarchitecture.data.repository.CoinDetailRepositoryImpl
import com.jhlee.cleanarchitecture.data.repository.CoinRepositoryImpl
import com.jhlee.cleanarchitecture.domain.model.Coin
import com.jhlee.cleanarchitecture.domain.model.CoinDetail
import com.jhlee.cleanarchitecture.domain.repository.CoinDetailRepository
import com.jhlee.cleanarchitecture.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {


    @Provides
    @Singleton
    fun provideApiService(): ApiService {
        return Retrofit.Builder().baseUrl(URLInfo.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideRemoteCoinRepository(api: ApiService): CoinRepository<Coin> {
        return CoinRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideRemoteCoinDetailRepository(api: ApiService): CoinDetailRepository<CoinDetail> {
        return CoinDetailRepositoryImpl(api)
    }

}