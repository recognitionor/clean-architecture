package com.jhlee.cleanarchitecture.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jhlee.cleanarchitecture.data.local.entity.DBCoin
import com.jhlee.cleanarchitecture.data.local.entity.DBTest

@Dao
interface DBCoinDao {
    @Query("SELECT * FROM DBCoin WHERE name = (:name)")
    suspend fun getTest(name: String): List<DBCoin>

    @Query("SELECT * FROM DBCoin")
    suspend fun getTestAll(): List<DBCoin>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCoin(coin: DBCoin)
}