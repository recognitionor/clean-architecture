package com.jhlee.cleanarchitecture.domain.usecase

import com.jhlee.cleanarchitecture.common.Resource
import com.jhlee.cleanarchitecture.domain.model.Coin
import com.jhlee.cleanarchitecture.domain.model.CoinDetail
import com.jhlee.cleanarchitecture.domain.repository.CoinDetailRepository
import com.jhlee.cleanarchitecture.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCoinDetailUseCase @Inject constructor(private val repository: CoinDetailRepository<CoinDetail>) {
    fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        emit(Resource.Loading())
        emit(Resource.Success(repository.getCoinDetail(coinId)))
    }
}