//package com.jhlee.cleanarchitecture.domain.use_case.get_coin
//
//import android.util.Log
//import com.jhlee.cleanarchitecture.common.Resource
//import com.jhlee.cleanarchitecture.data.local.entity.DBCoin
//import com.jhlee.cleanarchitecture.domain.repository.CoinRepository
//import kotlinx.coroutines.flow.Flow
//import kotlinx.coroutines.flow.flow
//import retrofit2.HttpException
//import java.io.IOException
//import javax.inject.Inject
//
//class GetDBCoinUseCase @Inject constructor(
//    private val repository: CoinRepository<DBCoin, Any?>
//) {
//    operator fun invoke(coinId: String): Flow<Resource<List<DBCoin>>> = flow {
//        try {
//            Log.d("jhlee", "invoke")
//            emit(Resource.Loading<List<DBCoin>>())
//            val coin = repository.getCoins()
//            emit(Resource.Success<List<DBCoin>>(coin))
//        } catch (e: HttpException) {
//            emit(Resource.Error<List<DBCoin>>(e.localizedMessage ?: "An unexpected error occured"))
//        } catch (e: IOException) {
//            emit(Resource.Error<List<DBCoin>>("Couldn't reach server. Check your internet connection."))
//        }
//    }
//}