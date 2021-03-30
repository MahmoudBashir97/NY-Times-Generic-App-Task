package com.mahmoudbashir.nytimesgenericapp.model

data class Root(
    val copyright: String,
    val num_results: Int,
    val results: List<Result>,
    val status: String
)