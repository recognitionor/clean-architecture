package com.jhlee.cleanarchitecture.data.repository

import com.jhlee.cleanarchitecture.data.local.dao.DBCoinDao
import com.jhlee.cleanarchitecture.data.local.entity.DBCoin
import com.jhlee.cleanarchitecture.data.local.entity.toCoin
import com.jhlee.cleanarchitecture.data.remote.ApiService
import com.jhlee.cleanarchitecture.data.remote.dto.coin.toCoin
import com.jhlee.cleanarchitecture.domain.model.Coin
import com.jhlee.cleanarchitecture.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val dao: DBCoinDao,
) : CoinRepository<Coin> {
    override suspend fun getCoins(): List<Coin> = apiService.getCoins().map { it.toCoin() }
    override suspend fun getCoinDB(): List<Coin> = dao.getTestAll().map { it.toCoin() }

    override suspend fun insertCoinDB(coin: Coin) {
        dao.insertCoin(
            DBCoin(
                symbol = coin.symbol,
                name = coin.name,
                rank = coin.rank,
                isActive = coin.is_active
            )
        )
    }
}