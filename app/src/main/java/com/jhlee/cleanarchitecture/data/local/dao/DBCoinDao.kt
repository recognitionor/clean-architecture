package com.jhlee.cleanarchitecture.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jhlee.cleanarchitecture.data.local.entity.DBCoin
import com.jhlee.cleanarchitecture.data.local.entity.DBTest

@Dao
interface DBCoinDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCoin(coin: DBCoin)

    @Query("SELECT * FROM DBCoin")
    suspend fun getCoinList(): List<DBCoin>
}