package com.jhlee.cleanarchitecture.di

import android.content.Context
import com.jhlee.cleanarchitecture.common.URLInfo
import com.jhlee.cleanarchitecture.data.local.AppDatabase
import com.jhlee.cleanarchitecture.data.local.DatabaseBuilder
import com.jhlee.cleanarchitecture.data.local.dao.DBCoinDao
import com.jhlee.cleanarchitecture.data.local.dao.DBTestDao
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
import dagger.hilt.android.qualifiers.ApplicationContext
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
    fun provideRemoteCoinRepository(api: ApiService, dao: DBCoinDao): CoinRepository<Coin> {
        return CoinRepositoryImpl(api, dao)
    }

    @Provides
    @Singleton
    fun provideRemoteCoinDetailRepository(api: ApiService): CoinDetailRepository<CoinDetail> {
        return CoinDetailRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return DatabaseBuilder.getInstance(context)
    }

    @Provides
    @Singleton
    fun provideDBTestDao(database: AppDatabase): DBTestDao {
        return database.testDao()
    }

    @Provides
    @Singleton
    fun provideDBCoinDao(database: AppDatabase): DBCoinDao {
        return database.coinDao()
    }


}