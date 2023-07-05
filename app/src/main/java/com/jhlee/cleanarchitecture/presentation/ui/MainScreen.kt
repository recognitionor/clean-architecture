package com.jhlee.cleanarchitecture.presentation.ui

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel

@Composable
fun MainScreen() {
    var viewModel: CoinViewModel = hiltViewModel()
    Text(text = "test")
}