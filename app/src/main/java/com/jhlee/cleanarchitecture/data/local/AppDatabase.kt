/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jhlee.cleanarchitecture.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jhlee.cleanarchitecture.data.local.dao.DBCoinDao
import com.jhlee.cleanarchitecture.data.local.dao.DBTestDao
import com.jhlee.cleanarchitecture.data.local.entity.DBCoin
import com.jhlee.cleanarchitecture.data.local.entity.DBTest

/**
 * The Room database for this app
 */
@Database(entities = [DBTest::class, DBCoin::class], version = 1, exportSchema = false)

abstract class AppDatabase : RoomDatabase() {
    abstract fun testDao(): DBTestDao
    abstract fun coinDao(): DBCoinDao
}
