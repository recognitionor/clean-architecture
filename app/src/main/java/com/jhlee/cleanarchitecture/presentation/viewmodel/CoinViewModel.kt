package com.jhlee.cleanarchitecture.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jhlee.cleanarchitecture.common.Resource
import com.jhlee.cleanarchitecture.domain.model.Coin
import com.jhlee.cleanarchitecture.domain.usecase.GetCoinDBUseCase
import com.jhlee.cleanarchitecture.domain.usecase.GetCoinDetailUseCase
import com.jhlee.cleanarchitecture.domain.usecase.GetCoinUseCase
import com.jhlee.cleanarchitecture.domain.usecase.InsertCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class CoinViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinUseCase,
    private val getCoinDBUseCase: GetCoinDBUseCase,
    private val insertCoinUseCase: InsertCoinUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(CoinState())
    val state = _state.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), _state.value)


    init {
        getCoinList()
    }

    fun getCoinDB() {
        getCoinDBUseCase.invoke().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    Log.d("jhlee", "success: ${result.data}")
                }

                is Resource.Loading -> {
                    Log.d("jhlee", "loading: ")
                }

                is Resource.Error -> {
                    Log.d("jhlee", "error: ")
                }
            }
        }.launchIn(viewModelScope)
    }

    fun insertCoinDB(coin: Coin) {
        insertCoinUseCase.invoke(coin).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    Log.d("jhlee", "success")
                }

                is Resource.Error -> {
                    Log.d("jhlee", "error")
                }

                is Resource.Loading -> {
                    Log.d("jhlee", "loading")
                }
            }

        }.launchIn(viewModelScope)
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

