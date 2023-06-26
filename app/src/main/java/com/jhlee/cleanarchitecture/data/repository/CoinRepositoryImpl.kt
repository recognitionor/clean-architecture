package com.jhlee.cleanarchitecture.data.repository

import com.jhlee.cleanarchitecture.data.remote.CoinPaprikaApi
import com.jhlee.cleanarchitecture.data.remote.dto.CoinDetailDto
import com.jhlee.cleanarchitecture.data.remote.dto.CoinDto
import com.jhlee.cleanarchitecture.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(private val api: CoinPaprikaApi) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> = api.getCoins()

    override suspend fun getCoinById(coinId: String): CoinDetailDto = api.getCoinById(coinId)
}