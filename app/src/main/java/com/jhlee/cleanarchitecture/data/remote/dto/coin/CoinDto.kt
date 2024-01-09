package com.jhlee.cleanarchitecture.data.remote.dto.coin

import com.jhlee.cleanarchitecture.domain.model.Coin

data class CoinDto(
    val id: String,
    val is_active: Boolean,
    val is_new: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String,
)

fun CoinDto.toCoin(): Coin = Coin(id, is_active, is_new, name, rank, symbol, type)