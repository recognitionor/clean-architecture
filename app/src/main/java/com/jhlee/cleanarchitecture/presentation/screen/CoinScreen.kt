package com.jhlee.cleanarchitecture.presentation.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jhlee.cleanarchitecture.presentation.viewmodel.CoinViewModel

@Composable
fun CoinScreen() {

    val viewModel: CoinViewModel = hiltViewModel()
    val state by viewModel.state.collectAsState()
    
    Column {
        Button(onClick = { viewModel.getCoinDB() }) {
            Text(text = "TEST")
        }
        
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(state.coinList.size) {
                val coin = state.coinList[it]
                Box(modifier = Modifier
                    .height(100.dp).fillMaxWidth()
                    .clickable {
                        viewModel.insertCoinDB(coin)
                    }) {
                    Column {
                        Text(text = coin.name)
                        Text(text = coin.symbol)
                    }

                }
            }
        }        
    }


}