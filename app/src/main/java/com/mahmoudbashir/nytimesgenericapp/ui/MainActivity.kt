package com.mahmoudbashir.nytimesgenericapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.mahmoudbashir.nytimesgenericapp.R
import com.mahmoudbashir.nytimesgenericapp.repository.PopularRepository
import com.mahmoudbashir.nytimesgenericapp.viewModel.PopularViewModel
import com.mahmoudbashir.nytimesgenericapp.viewModel.ViewModelProviderFactory

class MainActivity : AppCompatActivity() {
    private val repo : PopularRepository = PopularRepository()
    lateinit var popViewModel:PopularViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModelProviderFactory = ViewModelProviderFactory(application,repo)
        popViewModel = ViewModelProvider(this,viewModelProviderFactory).get(PopularViewModel::class.java)
    }
}