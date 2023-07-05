package com.jhlee.cleanarchitecture.domain.repository

import com.jhlee.cleanarchitecture.domain.model.Coin

interface CoinRepository {
    suspend fun getCoinList(): List<Coin>
}