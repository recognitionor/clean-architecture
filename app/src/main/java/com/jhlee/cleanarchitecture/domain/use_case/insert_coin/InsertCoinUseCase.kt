package com.jhlee.cleanarchitecture.domain.use_case.insert_coin

import android.util.Log
import com.jhlee.cleanarchitecture.common.Resource
import com.jhlee.cleanarchitecture.data.local.entity.DBCoin
import com.jhlee.cleanarchitecture.domain.repository.SaveCoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class InsertCoinUseCase @Inject constructor(
    private val repository: SaveCoinRepository<DBCoin>
) {
    operator fun invoke(coin: DBCoin): Flow<Resource<Any?>> = flow {
        Log.d("jhlee", "InsertCoinUseCase : ${Thread.currentThread().name} ---- $coin")
        try {
            emit(Resource.Loading<Any?>())
            repository.saveCoin(coin)
            emit(Resource.Success<Any?>(null))
        } catch(e: Exception) {
            Log.d("jhlee", "error : ${e.message}")
            emit(Resource.Error<Any?>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error<Any?>("Couldn't reach server. Check your internet connection."))
        }

    }

    fun getList(): Flow<Resource<List<DBCoin>>> = flow {
        Log.d("jhlee", "InsertCoinUseCase.getList")
        val result = repository.getCoinList()

        emit(Resource.Success<List<DBCoin>>(result))
    }
}