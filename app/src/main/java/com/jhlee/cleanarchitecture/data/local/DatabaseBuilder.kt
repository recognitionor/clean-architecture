package com.jhlee.cleanarchitecture.data.local

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

object DatabaseBuilder {

    private var INSTANCE: AppDatabase? = null

    fun getInstance(context: Context): AppDatabase {
        if (INSTANCE == null) {
            synchronized(AppDatabase::class) {
                INSTANCE = buildRoomDB(context)
            }
        }
        return INSTANCE!!
    }

    private fun buildRoomDB(context: Context) = Room.databaseBuilder(
        context.applicationContext, AppDatabase::class.java, context.packageName
    ).fallbackToDestructiveMigration().build()

}