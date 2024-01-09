package com.jhlee.cleanarchitecture.domain.usecase

import com.jhlee.cleanarchitecture.common.Resource
import com.jhlee.cleanarchitecture.domain.model.Coin
import com.jhlee.cleanarchitecture.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(private val repository: CoinRepository<Coin>) {
    fun invoke(): Flow<Resource<List<Coin>>> = flow {
        emit(Resource.Loading())
        emit(Resource.Success(repository.getCoins()))
    }
}