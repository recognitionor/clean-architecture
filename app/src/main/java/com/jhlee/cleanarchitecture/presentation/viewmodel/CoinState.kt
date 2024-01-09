package com.jhlee.cleanarchitecture.presentation.viewmodel

import com.jhlee.cleanarchitecture.domain.model.Coin

data class CoinState(
    val isLoading: Boolean = false,
    val coinList: List<Coin> = emptyList(),
)