package com.jhlee.cleanarchitecture.data.repository

import com.jhlee.cleanarchitecture.data.remote.ApiService
import com.jhlee.cleanarchitecture.data.remote.dto.coin.toCoin
import com.jhlee.cleanarchitecture.data.remote.dto.coin_detail.toCoinDetail
import com.jhlee.cleanarchitecture.domain.model.Coin
import com.jhlee.cleanarchitecture.domain.model.CoinDetail
import com.jhlee.cleanarchitecture.domain.repository.CoinDetailRepository
import com.jhlee.cleanarchitecture.domain.repository.CoinRepository
import javax.inject.Inject

class CoinDetailRepositoryImpl @Inject constructor(private val apiService: ApiService) :
    CoinDetailRepository<CoinDetail> {
    override suspend fun getCoinDetail(coinId: String): CoinDetail =
        apiService.getCoinById(coinId).toCoinDetail()
}