package com.jhlee.cleanarchitecture.presentation.screen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.jhlee.cleanarchitecture.presentation.viewmodel.HomeState
import com.jhlee.cleanarchitecture.presentation.viewmodel.HomeViewModel

@Composable
fun MainScreen() {
    val viewModel: HomeViewModel = hiltViewModel()
    val state2 by viewModel.stateTest.collectAsState()

    Column {

//        TestScreen(viewModel, state2)
        CoinScreen()

    }
}

@Composable
fun TestScreen(viewModel2: HomeViewModel, state4: HomeState) {
    val viewModel: HomeViewModel = hiltViewModel()
    val state2 by viewModel.stateTest.collectAsState()
    val state3 by viewModel2.stateTest.collectAsState()
    Column {
        Text(text = "TestScreen")
        Text(text = "state2 : ${state2.testStr}")
        Text(text = "state3 : ${state3.testStr}")
        Text(text = "state4 : ${state4.testStr}")
        Button(onClick = { viewModel.test() }) {
            Text(text = "btn")
        }

    }
}