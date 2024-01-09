package com.jhlee.cleanarchitecture.presentation.screen

import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.jhlee.cleanarchitecture.presentation.viewmodel.CoinViewModel

@Composable
fun MainScreen() {
    val viewModel: CoinViewModel = hiltViewModel()
    val state = viewModel.state.value
    Log.d("jhlee", "state : ${state.coinList.size}")
    LazyColumn {
        items(state.coinList.size) {
            val coin = state.coinList[it]
            Text(text = coin.name)

        }
    }
}