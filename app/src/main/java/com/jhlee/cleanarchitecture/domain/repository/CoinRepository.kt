package com.jhlee.cleanarchitecture.domain.repository


interface CoinRepository<T, U> {
    suspend fun getCoins(): List<T>
    suspend fun getCoinById(coinId: String): U
}