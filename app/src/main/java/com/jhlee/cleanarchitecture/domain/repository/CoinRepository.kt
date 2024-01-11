package com.jhlee.cleanarchitecture.domain.repository

interface CoinRepository<T> {
    suspend fun getCoins(): List<T>

    suspend fun insertCoinDB(coin: T)

    suspend fun getCoinDB(): List<T>
}