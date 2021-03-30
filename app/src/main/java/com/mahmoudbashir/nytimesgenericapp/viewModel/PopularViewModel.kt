package com.mahmoudbashir.nytimesgenericapp.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.mahmoudbashir.nytimesgenericapp.model.Root
import com.mahmoudbashir.nytimesgenericapp.pojo.PopularData_Model
import com.mahmoudbashir.nytimesgenericapp.repository.PopularRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import retrofit2.Response

class PopularViewModel(val app:Application, private val repo:PopularRepository):AndroidViewModel(app) {
    val pop : MutableLiveData<PopularData_Model> = MutableLiveData()
    suspend fun getPopular():Response<PopularData_Model> {
        return repo.getPopularTimes()
    }

    suspend fun getPopla():Response<PopularData_Model> = repo.getPopularT()
}