package com.example.module07demo01.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.module07demo01.bo.HourlyData
import com.example.module07demo01.network.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {

    private val _weather = MutableStateFlow<HourlyData?>(null)
    val weather: Flow<HourlyData?> = _weather

    init {
        fetchWeather()
    }

    private fun fetchWeather() {
        viewModelScope.launch(Dispatchers.IO) {
            _weather.value = RetrofitClient.weatherApiService.getWeatherData(
                latitude=47.224152,
                longitude=-1.6322685,
                current="temperature_2m,wind_speed_10m",
                hourly="temperature_2m"
            ).hourly
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                return WeatherViewModel() as T
            }
        }
    }
}