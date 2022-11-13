package com.example.weather_xml

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class AdapterDayWeather : RecyclerView.Adapter<AdapterDayWeather.ViewHolder>() {

    private var data = arrayOf(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16)
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_day_weather, viewGroup, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: AdapterDayWeather.ViewHolder, position: Int) {

    }
    override fun getItemCount() = data.size


}