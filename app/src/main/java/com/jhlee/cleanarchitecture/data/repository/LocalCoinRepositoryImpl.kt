package com.jhlee.cleanarchitecture.data.repository

import android.util.Log
import com.jhlee.cleanarchitecture.data.local.dao.DBCoinDao
import com.jhlee.cleanarchitecture.data.local.entity.DBCoin
import com.jhlee.cleanarchitecture.domain.repository.CoinRepository
import com.jhlee.cleanarchitecture.domain.repository.SaveCoinRepository
import javax.inject.Inject

class LocalCoinRepositoryImpl @Inject constructor(private val dao: DBCoinDao) :
    SaveCoinRepository<DBCoin>, CoinRepository<DBCoin, Any?> {

    override suspend fun saveCoin(coin: DBCoin) {
        Log.d(
            "jhlee",
            "LocalCoinRepositoryImpl-saveCoin : ${Thread.currentThread().name} ---- $coin"
        )
        dao.saveCoin(coin)
    }

    override suspend fun getCoins(): List<DBCoin> = dao.getCoinList()

    override suspend fun getCoinById(coinId: String): Any? = null
    override suspend fun getCoinList(): List<DBCoin> = dao.getCoinList()
}