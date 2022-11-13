package com.example.weather_xml.feature.weather_screen.ui.model

data class WeatherMainModel(
    val description: String,
    val icon: String,
    val temperature: Double,
    val maxTemperature: Double,
    val minTemperature: Double,
    val windDeg: String,
    val windSpeed: String,
    val allDateWeather: String,
    val weekDay: String,
    val numberMonthDay: String,
    var time: String,
    val rainProbability:String
)



