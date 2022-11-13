package com.example.weather_xml.feature.weather_screen

import com.example.weather_xml.base.Either
import com.example.weather_xml.base.attempt
import com.example.weather_xml.feature.weather_screen.data.WeatherRepo
import com.example.weather_xml.feature.weather_screen.ui.model.WeatherMainModel

class WeatherInteractor(private val weatherRepo: WeatherRepo) {

    suspend fun getWeather(city: String): Either<Throwable, List<WeatherMainModel>> {
        return attempt { weatherRepo.getAllWeather(city = city) }
    }

}