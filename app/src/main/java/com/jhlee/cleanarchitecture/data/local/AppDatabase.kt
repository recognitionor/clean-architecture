package com.jhlee.cleanarchitecture.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jhlee.cleanarchitecture.data.local.dao.DBCoinDao
import com.jhlee.cleanarchitecture.data.local.dao.DBTestDao
import com.jhlee.cleanarchitecture.data.local.entity.DBCoin
import com.jhlee.cleanarchitecture.data.local.entity.DBTest

@Database(entities = [DBTest::class, DBCoin::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun testDao(): DBTestDao

    abstract fun coinDao(): DBCoinDao

}