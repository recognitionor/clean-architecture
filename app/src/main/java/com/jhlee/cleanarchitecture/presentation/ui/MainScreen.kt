package com.jhlee.cleanarchitecture.presentation.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.jhlee.cleanarchitecture.presentation.CoinViewModel

@Composable
fun MainScreen() {
    val viewModel: CoinViewModel = hiltViewModel()
}