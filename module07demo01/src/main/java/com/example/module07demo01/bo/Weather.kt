package com.example.module07demo01.bo

data class WeatherResponse (
    val hourly: HourlyData
)

data class HourlyData (
    val time: List<String>,
    val temperature_2m: List<Double>
)