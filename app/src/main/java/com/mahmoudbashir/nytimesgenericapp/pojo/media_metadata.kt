package com.mahmoudbashir.nytimesgenericapp.pojo

import com.google.gson.annotations.SerializedName

data class media_metadata(
    @SerializedName("url")
    val url:String,
    @SerializedName("format")
    val format:String,
    @SerializedName("height")
    val height:Int,
    @SerializedName("width")
    val width:Int,
)
