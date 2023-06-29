package com.jhlee.cleanarchitecture.data.local

import com.jhlee.cleanarchitecture.data.local.entity.DBTest

class DatabaseHelperImpl(private val appDatabase: AppDatabase) : DatabaseHelper {
    override suspend fun deleteTest(test: String) = appDatabase.testDao().deleteTest(test)

    override suspend fun findTest(name: String): List<DBTest> = appDatabase.testDao().findTest(name)

}