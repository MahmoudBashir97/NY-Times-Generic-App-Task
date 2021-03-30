package com.mahmoudbashir.nytimesgenericapp.repository

import com.mahmoudbashir.nytimesgenericapp.pojo.PopularData_Model
import com.mahmoudbashir.nytimesgenericapp.retrofit.RetrofitInstance
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class PopularRepository() {
    suspend fun getPopularTimes():Response<PopularData_Model> =RetrofitInstance.api.getPopularArticles()
    suspend fun getPopularT()=RetrofitInstance.api.getPopularTimes()
}