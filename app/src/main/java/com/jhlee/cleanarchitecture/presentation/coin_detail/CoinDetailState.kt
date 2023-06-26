package com.jhlee.cleanarchitecture.presentation.coin_detail

import com.jhlee.cleanarchitecture.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false, val coin: CoinDetail? = null, val error: String = ""
)