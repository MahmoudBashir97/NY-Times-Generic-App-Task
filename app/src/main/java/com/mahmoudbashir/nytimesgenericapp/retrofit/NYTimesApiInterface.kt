package com.mahmoudbashir.nytimesgenericapp.retrofit

import com.mahmoudbashir.nytimesgenericapp.BuildConfig
import com.mahmoudbashir.nytimesgenericapp.pojo.PopularData_Model
import com.mahmoudbashir.nytimesgenericapp.util.Constants
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface NYTimesApiInterface {

    @Headers("Accept: application/json")
    @GET("svc/mostpopular/v2/viewed/7.json")
    suspend fun getPopularArticles(
        @Query("api-key")
        apiKey:String = Constants.API_KEY
    ):Response<PopularData_Model>

    @Headers("Accept: application/json")
    @GET("svc/mostpopular/v2/viewed/7.json")
    suspend fun getPopularTimes(@Query("api-key") apiKey: String = BuildConfig.API_KEY):Response<PopularData_Model>
}