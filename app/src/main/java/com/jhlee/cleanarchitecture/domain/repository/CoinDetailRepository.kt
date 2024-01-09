package com.jhlee.cleanarchitecture.domain.repository

interface CoinDetailRepository<T> {
    suspend fun getCoinDetail(coinId: String): T
}