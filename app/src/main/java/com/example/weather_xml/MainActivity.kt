package com.example.weather_xml

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.RecyclerView


class MainActivity : ComponentActivity() {

    private val rvHourWeather: RecyclerView by lazy {findViewById(R.id.rvHourWeather)}
    private val adapterHourWeather: AdapterHourWeather by lazy {AdapterHourWeather()}
    private val rvDayWeather: RecyclerView by lazy {findViewById(R.id.rvDayWeather)}
    private val adapterDayWeather: AdapterDayWeather by lazy {AdapterDayWeather()}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvHourWeather.adapter=adapterHourWeather
        rvDayWeather.adapter=adapterDayWeather

    }

}

