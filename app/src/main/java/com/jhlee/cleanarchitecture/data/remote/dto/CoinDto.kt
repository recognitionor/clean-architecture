package com.jhlee.cleanarchitecture.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.jhlee.cleanarchitecture.domain.model.Coin

data class CoinDto(
    val id: String,
    @SerializedName("is_active") val is_active: Boolean,
    @SerializedName("i s_new") val is_new: Boolean = false,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String = ""
)

fun CoinDto.toCoin(): Coin {
    return Coin(
        id = id, isActive = is_active, name = name, rank = rank, symbol = symbol
    )
}