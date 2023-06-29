package com.jhlee.cleanarchitecture.di


import android.content.Context
import com.jhlee.cleanarchitecture.common.Constants
import com.jhlee.cleanarchitecture.data.local.AppDatabase
import com.jhlee.cleanarchitecture.data.local.DatabaseBuilder
import com.jhlee.cleanarchitecture.data.local.dao.DBCoinDao
import com.jhlee.cleanarchitecture.data.local.entity.DBCoin
import com.jhlee.cleanarchitecture.data.remote.CoinPaprikaApi
import com.jhlee.cleanarchitecture.data.remote.dto.CoinDetailDto
import com.jhlee.cleanarchitecture.data.remote.dto.CoinDto
import com.jhlee.cleanarchitecture.data.repository.LocalCoinRepositoryImpl
import com.jhlee.cleanarchitecture.data.repository.RemoteCoinRepositoryImpl
import com.jhlee.cleanarchitecture.domain.repository.CoinRepository
import com.jhlee.cleanarchitecture.domain.repository.SaveCoinRepository
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
object AppModule {

    @Provides
    @Singleton
    fun providePaprikaApi(): CoinPaprikaApi {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRemoteCoinRepository(api: CoinPaprikaApi): CoinRepository<CoinDto, CoinDetailDto> {
        return RemoteCoinRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideLocalCoinRepository(dao: DBCoinDao): SaveCoinRepository<DBCoin> {
        return LocalCoinRepositoryImpl(dao)
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return DatabaseBuilder.getInstance(context)
    }
    @Provides
    @Singleton
    fun provideDBCoinDao(database: AppDatabase): DBCoinDao {
        return database.coinDao()
    }
}