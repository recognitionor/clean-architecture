package com.jhlee.cleanarchitecture.presentation.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jhlee.cleanarchitecture.common.Resource
import com.jhlee.cleanarchitecture.domain.usecase.GetCoinListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinViewModel @Inject constructor(private val useCase: GetCoinListUseCase) : ViewModel() {

    init {
        getCoinList()
    }

    private fun getCoinList() {
        useCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    Log.d("jhlee", "resiult : ${result.data}")
                }

                is Resource.Error -> {

                }

                is Resource.Loading -> {

                }
            }

        }.launchIn(viewModelScope)
    }

}