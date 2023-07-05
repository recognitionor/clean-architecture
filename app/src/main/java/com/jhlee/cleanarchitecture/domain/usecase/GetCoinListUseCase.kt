package com.jhlee.cleanarchitecture.domain.usecase

import com.jhlee.cleanarchitecture.common.Resource
import com.jhlee.cleanarchitecture.domain.model.Coin
import com.jhlee.cleanarchitecture.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class GetCoinListUseCase @Inject constructor(private val repository: CoinRepository) {

    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        val result = repository.getCoinList()
        emit(Resource.Success<List<Coin>>(result))
    }
}