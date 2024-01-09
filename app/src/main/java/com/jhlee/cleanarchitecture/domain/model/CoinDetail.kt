package com.jhlee.cleanarchitecture.domain.model

data class CoinDetail(
    val description: String,
    val id: String,
    val is_active: Boolean,
    val is_new: Boolean,
    val logo: String,
    val message: String,
    val name: String,
    val open_source: Boolean,
    val rank: Int,
    val symbol: String,
    val type: String,
)
