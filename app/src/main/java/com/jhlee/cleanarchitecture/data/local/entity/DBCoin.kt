package com.jhlee.cleanarchitecture.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.jhlee.cleanarchitecture.domain.model.Coin

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

fun DBCoin.toCoin(): Coin {
    return Coin(
        rank = rank,
        name = name,
        symbol = symbol,
        type = "",
        id = "",
        is_active = true,
        is_new = false
    )
}