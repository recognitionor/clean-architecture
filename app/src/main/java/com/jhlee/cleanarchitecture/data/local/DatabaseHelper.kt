package com.jhlee.cleanarchitecture.data.local

import com.jhlee.cleanarchitecture.data.local.entity.DBTest

interface DatabaseHelper {

    suspend fun deleteTest(test: String)
    suspend fun findTest(name: String): List<DBTest>
}