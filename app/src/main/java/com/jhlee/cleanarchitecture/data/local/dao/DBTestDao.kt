package com.jhlee.cleanarchitecture.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jhlee.cleanarchitecture.data.local.entity.DBTest

@Dao
interface DBTestDao {
    @Query("SELECT * FROM DBTest WHERE name = (:name)")
    suspend fun findTest(name: String): List<DBTest>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCoin(coin: DBTest)
}