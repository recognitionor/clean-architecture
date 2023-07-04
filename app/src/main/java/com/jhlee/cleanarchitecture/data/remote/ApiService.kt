package com.jhlee.cleanarchitecture.data.remote

import com.jhlee.cleanarchitecture.data.remote.dto.CoinDto
import retrofit2.http.GET

interface ApiService {
    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>
}