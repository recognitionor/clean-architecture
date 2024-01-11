package com.jhlee.cleanarchitecture.domain.repository

interface InsertCoinUseCase<T> {
    suspend fun insertCoin(coin: T)
}