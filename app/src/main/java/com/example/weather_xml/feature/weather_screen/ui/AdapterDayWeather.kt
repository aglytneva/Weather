package com.example.weather_xml

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weather_xml.feature.weather_screen.ui.model.WeatherMainModel

class AdapterDayWeather : RecyclerView.Adapter<AdapterDayWeather.ViewHolder>() {

    private var data :List<WeatherMainModel> = emptyList()
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTemp :TextView

        init{
            tvTemp = view.findViewById(R.id.tvTempDay)
        }
    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_day_weather, viewGroup, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.tvTemp.text=data[position].temperature.toString()
    }
    override fun getItemCount() = data.size

    //создаем метод, который самостоятельно дергает дату
    fun setData (days :List <WeatherMainModel>) {
        data = days
        notifyDataSetChanged()

    }
}