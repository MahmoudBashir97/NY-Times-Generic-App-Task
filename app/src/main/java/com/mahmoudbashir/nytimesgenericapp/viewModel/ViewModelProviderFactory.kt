@file:Suppress("UNCHECKED_CAST")

package com.mahmoudbashir.nytimesgenericapp.viewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mahmoudbashir.nytimesgenericapp.repository.PopularRepository

class ViewModelProviderFactory(private val app: Application,
                               private val repos: PopularRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PopularViewModel(app,repos ) as T
}
}