package com.example.weather_xml.feature.weather_screen.data

import com.example.weather_xml.feature.weather_screen.ui.model.WeatherMainModel


interface WeatherRepo {
    suspend fun getAllWeather(city: String):List<WeatherMainModel>
}