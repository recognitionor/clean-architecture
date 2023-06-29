package com.jhlee.cleanarchitecture.domain.use_case.get_coins

import android.util.Log
import com.jhlee.cleanarchitecture.common.Resource
import com.jhlee.cleanarchitecture.data.remote.dto.CoinDetailDto
import com.jhlee.cleanarchitecture.data.remote.dto.CoinDto
import com.jhlee.cleanarchitecture.data.remote.dto.toCoin
import com.jhlee.cleanarchitecture.domain.model.Coin
import com.jhlee.cleanarchitecture.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository<CoinDto, CoinDetailDto>
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        Log.d("jhlee", "GetCoinsUseCase : ${Thread.currentThread().name}")
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))
        } catch(e: HttpException) {
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error<List<Coin>>("Couldn't reach server. Check your internet connection."))
        }
    }
}