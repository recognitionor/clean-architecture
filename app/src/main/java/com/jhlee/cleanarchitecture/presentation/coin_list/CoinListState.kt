package com.jhlee.cleanarchitecture.presentation.coin_list

import com.jhlee.cleanarchitecture.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false, val coins: List<Coin> = emptyList(), val error: String = ""
)
