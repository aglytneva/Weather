package com.example.weather_xml.feature.weather_screen.data.model.ModelApiHours

import com.google.gson.annotations.SerializedName

data class Weather(
    @SerializedName("description")
    val description: String,
    @SerializedName("icon")
    val icon: String,
    val id: Int,
    val main: String
)