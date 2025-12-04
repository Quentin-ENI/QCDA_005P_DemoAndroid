package com.example.module04demo02

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class RockBandViewModel(
    val rockBandRepository: RockBandRepository
): ViewModel() {
    private val _bands = MutableStateFlow<List<String>>(emptyList())
//    val bands:  StateFlow<List<String>> = _bands
    val bands = _bands.asStateFlow()

    init {
        _bands.value = rockBandRepository.getAllRockBands()
    }

    // Define ViewModel factory in a companion object
    companion object {

        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                // Get the Application object from extras
//                val application = checkNotNull(extras[APPLICATION_KEY])
                // Create a SavedStateHandle for this ViewModel from extras
//                val savedStateHandle = extras.createSavedStateHandle()

                return RockBandViewModel(
                    RockBandRepository()
                ) as T
            }
        }
    }
}