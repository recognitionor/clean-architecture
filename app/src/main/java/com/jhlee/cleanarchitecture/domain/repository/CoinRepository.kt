package com.jhlee.cleanarchitecture.domain.repository

interface CoinRepository<T> {
    suspend fun getCoins(): List<T>
}