package com.jhlee.cleanarchitecture.domain.usecase

import com.jhlee.cleanarchitecture.common.Resource
import com.jhlee.cleanarchitecture.domain.model.Coin
import com.jhlee.cleanarchitecture.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class InsertCoinUseCase @Inject constructor(private val coinRepository: CoinRepository<Coin>) {

    fun invoke(coin: Coin): Flow<Resource<Unit>> = flow {
        emit(Resource.Loading())
        try {
            coinRepository.insertCoinDB(coin)
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: ""))
        }
        emit(Resource.Success(Unit))
    }
}