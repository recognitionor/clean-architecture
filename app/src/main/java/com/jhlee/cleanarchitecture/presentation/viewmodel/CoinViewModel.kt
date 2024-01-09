package com.jhlee.cleanarchitecture.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jhlee.cleanarchitecture.common.Resource
import com.jhlee.cleanarchitecture.domain.usecase.GetCoinDetailUseCase
import com.jhlee.cleanarchitecture.domain.usecase.GetCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinUseCase,
    private val getCoinDetailUseCase: GetCoinDetailUseCase,
) : ViewModel() {
    private val _state = mutableStateOf(CoinState())
    val state: State<CoinState> = _state

    init {
        getCoinList()
    }

    private fun getCoinList() {
        getCoinUseCase.invoke().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = _state.value.copy(coinList = result.data ?: emptyList())
                }

                is Resource.Loading -> {
                }

                is Resource.Error -> {
                }
            }
        }.launchIn(viewModelScope)
    }

}

