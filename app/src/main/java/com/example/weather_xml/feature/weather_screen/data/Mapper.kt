package com.example.weather_xml.feature.weather_screen.data

import com.example.weather_xml.feature.weather_screen.data.model.ModelApiHours.WeatherHourRemoteModel
import com.example.weather_xml.feature.weather_screen.ui.model.WeatherMainModel
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

fun WeatherHourRemoteModel.toDomain() = WeatherMainModel(
    temperature = main.temp,
    description = weather
        .map { it.description }
        .toString()
        .removeSurrounding("[", "]")
        .capitalize(),
    icon = weather
        .map { it.icon }
        .toString()
        .removeSurrounding("[", "]"),
    windDeg = toTextualDescription(wind.deg.toString()),
    windSpeed = wind.speed.toString().substringBefore("."),
    allDateWeather = dt_txt,
    weekDay = formatToDayName(dt_txt),
    numberMonthDay = formatToDayMonth(dt_txt)  ,
    time = formateToHour(dt_txt),
    rainProbability = "",
    maxTemperature = main.temp_max,
    minTemperature = main.temp_min

    )

fun toTextualDescription(windDeg: String): String {
    if (windDeg.toFloat() > 337.5) return "С"
    if (windDeg.toFloat() > 292.5) return "СЗ"
    if (windDeg.toFloat() > 247.5) return "З"
    if (windDeg.toFloat() > 202.5) return "ЮЗ"
    if (windDeg.toFloat() > 157.5) return "Ю"
    if (windDeg.toFloat() > 122.5) return "ЮВ"
    if (windDeg.toFloat() > 67.5) return "В"
    if (windDeg.toFloat() > 22.5)  return "СВ"
    return ""

}
val firstApiFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

fun formatToDayName(date: String): String {
    val formatedDay = LocalDate.parse(date, firstApiFormat).dayOfWeek.toString()
    return dayToRusLang(formatedDay)
}

fun formatToDayMonth(date: String): String {
    return "${LocalDate.parse(date, firstApiFormat).dayOfMonth.toString()}/${LocalDate.parse(date, firstApiFormat).monthValue.toString()}"
}

fun dayToRusLang(day: String): String {
    if (day == "MONDAY") return "ПН"
    if (day == "TUESDAY") return "ВТ"
    if (day == "WEDNESDAY") return "СР"
    if (day == "THURSDAY") return "ЧТ"
    if (day == "FRIDAY") return "ПТ"
    if (day == "SATURDAY") return "СБ"
    if (day == "SUNDAY") return "ВС"
    return ""
}

fun formateToHour(date: String): String {
    return "${LocalTime.parse(date, firstApiFormat).hour}:00"
}

