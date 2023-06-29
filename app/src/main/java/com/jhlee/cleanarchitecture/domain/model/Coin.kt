package com.jhlee.cleanarchitecture.domain.model

import androidx.room.Entity

data class Coin(
    val id: String,
    val isActive: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
)
