package com.mahmoudbashir.nytimesgenericapp.pojo

import com.google.gson.annotations.SerializedName

data class PopularData_Model(
    @SerializedName("status")
    val status:String,
    @SerializedName("copyright")
    val copyright:String,
    @SerializedName("num_results")
    val num_results:Int,
    @SerializedName("results")
    val results:List<results>
)
