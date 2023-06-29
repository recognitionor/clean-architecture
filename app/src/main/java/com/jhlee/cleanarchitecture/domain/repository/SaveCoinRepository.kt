package com.jhlee.cleanarchitecture.domain.repository


interface SaveCoinRepository<T> {
    suspend fun saveCoin(coin: T)
    suspend fun getCoinList(): List<T>
}