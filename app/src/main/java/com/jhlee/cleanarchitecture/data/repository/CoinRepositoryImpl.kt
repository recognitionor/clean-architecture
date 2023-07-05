package com.jhlee.cleanarchitecture.data.repository

import android.util.Log
import com.jhlee.cleanarchitecture.data.remote.ApiService
import com.jhlee.cleanarchitecture.data.remote.dto.getCoinFromDto
import com.jhlee.cleanarchitecture.domain.model.Coin
import com.jhlee.cleanarchitecture.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(private val apiService: ApiService) : CoinRepository {
    override suspend fun getCoinList(): List<Coin> {
        val test = apiService.getCoinList()
        Log.d("jhlee", test.toString())
        return apiService.getCoinList().map {
            it.getCoinFromDto()
        }
    }
}