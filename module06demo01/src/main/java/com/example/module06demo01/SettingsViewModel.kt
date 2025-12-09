package com.example.module06demo01

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SettingsViewModel
    (private val userPreferenceRepository: UserPreferenceRepository): ViewModel() {

    val colors = MutableStateFlow<List<Color>>(
        listOf(
            Color.Red,
            Color.Green,
            Color.Blue,
            Color.Yellow,
            Color.White
        )
    )

    private val _userColor = MutableStateFlow<Color>(Color.White)
    val userColor : StateFlow<Color> = _userColor

    init {
        getBackgroundColor()
    }

    fun getBackgroundColor() {
        viewModelScope.launch {
            userPreferenceRepository.getBackgroundColor().collect { _userColor.value = it }
        }
    }

    fun setBackgroundColor(color: Color) {
        viewModelScope.launch {
            userPreferenceRepository.saveBackGroundColor(color)
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                val application = checkNotNull(extras[APPLICATION_KEY])
                return SettingsViewModel(
                    UserPreferenceRepository(application)
                ) as T
            }
        }
    }
}