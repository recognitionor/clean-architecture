package com.jhlee.cleanarchitecture.domain.repository

import com.jhlee.cleanarchitecture.data.remote.dto.CoinDetailDto
import com.jhlee.cleanarchitecture.data.remote.dto.CoinDto
import com.jhlee.cleanarchitecture.domain.model.CoinDetail

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>
    suspend fun getCoinById(coinId: String): CoinDetailDto
}