package com.jhlee.cleanarchitecture.data.repository

import com.jhlee.cleanarchitecture.data.remote.ApiService
import com.jhlee.cleanarchitecture.data.remote.dto.coin.toCoin
import com.jhlee.cleanarchitecture.domain.model.Coin
import com.jhlee.cleanarchitecture.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(private val apiService: ApiService) :
    CoinRepository<Coin> {
    override suspend fun getCoins(): List<Coin> = apiService.getCoins().map { it.toCoin() }
}