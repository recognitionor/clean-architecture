package com.jhlee.cleanarchitecture.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {


    private val _stateTest = MutableStateFlow(HomeState())
    val stateTest =
        _stateTest.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), _stateTest.value)


    fun test() {
        _stateTest.update { it.copy(testStr = it.testStr + "a") }
    }
}