package com.jhlee.cleanarchitecture.data.remote.dto

data class Links(
    val explorer: List<String> = arrayListOf(),
    val facebook: List<String> = arrayListOf(),
    val reddit: List<String> = arrayListOf(),
    val source_code: List<String> = arrayListOf(),
    val website: List<String> = arrayListOf(),
    val youtube: List<String> = arrayListOf()
)