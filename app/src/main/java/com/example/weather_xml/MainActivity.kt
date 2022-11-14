package com.example.weather_xml

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.weather_xml.databinding.ActivityMainBinding
import com.example.weather_xml.feature.weather_screen.ui.DataEvent
import com.example.weather_xml.feature.weather_screen.ui.UiEvent
import com.example.weather_xml.feature.weather_screen.ui.ViewState
import com.example.weather_xml.feature.weather_screen.ui.WeatherScreenViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : ComponentActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: WeatherScreenViewModel by viewModel()

    //    private val tvTempMain: TextView by lazy {findViewById(R.id.tvTempMain)}
//    private val rvHourWeather: RecyclerView by lazy {findViewById(R.id.rvHourWeather)}
//    private val adapterHourWeather: AdapterHourWeather by lazy {AdapterHourWeather()}
//    private val rvDayWeather: RecyclerView by lazy {findViewById(R.id.rvDayWeather)}
        private val dayAdapter:AdapterDayWeather by lazy {AdapterDayWeather()}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.rvHourWeather.adapter = AdapterHourWeather()

        viewModel.viewState.observe(this, ::render)
        viewModel.processDataEvent(DataEvent.WeatherIsLoaded("Moscow"))
        binding.rvDayWeather.adapter =dayAdapter

    }

    private fun render(viewState: ViewState) {
        binding.tvTempMain.text = viewState.tempCurrent
        Glide
            .with(this)
            .load("http://openweathermap.org/img/wn/${viewState.iconCurrent}@2x.png")
            .into(binding.ivIcon)
        binding.tvCity.text = viewState.city
        binding.rvDayWeather.adapter
        dayAdapter.setData(viewState.weatherDayForecastList)

    }

}

