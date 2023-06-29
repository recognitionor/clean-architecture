package com.jhlee.cleanarchitecture.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.jhlee.cleanarchitecture.data.local.entity.DBTest

@Dao
interface DBTestDao {
    @Query("SELECT * FROM DBTest WHERE name = (:name)")
    fun findTest(name: String): List<DBTest>

    @Query("DELETE FROM DBTest WHERE name = (:name)")
    fun deleteTest(name: String)
}