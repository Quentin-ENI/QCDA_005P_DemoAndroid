package com.example.module04demo01.vm

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class UserViewModel : ViewModel() {
    val _name = MutableStateFlow("Michel")
    val name : StateFlow<String> = _name

    fun updateName(name: String) {
        _name.value = name
    }
}