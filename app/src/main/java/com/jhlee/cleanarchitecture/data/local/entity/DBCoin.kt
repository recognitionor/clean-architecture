package com.jhlee.cleanarchitecture.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DBCoin(
    @ColumnInfo(name = "isActive") val isActive: Boolean,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "rank") val rank: Int,
    @ColumnInfo(name = "symbol") val symbol: String,
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
