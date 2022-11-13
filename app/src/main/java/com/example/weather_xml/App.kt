package com.example.weather_xml

import android.app.Application
import com.example.weather_xml.feature.weather_screen.di.weatherScreenModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        // Start Koin
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(weatherScreenModule)
        }


    }
}