package com.example.module06demo03

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MusicViewModel(private val musicDAO: MusicDAO) : ViewModel() {
    private val _musics = MutableStateFlow<List<Music>>(emptyList())
    val musics: Flow<List<Music>> = _musics

    init {
        viewModelScope.launch {
            insertMusic(
                Music(
                    id = 0L,
                    title = "Stairway To Heaven",
                    author = "Led Zeppelin",
                    durationInSeconds = 300
                )
            )
            insertMusic(
                Music(
                    id = 0L,
                    title = "Nights In White Satin",
                    author = "The Moody Blues",
                    durationInSeconds = 280
                )
            )
            loadMusics()
        }
    }

    fun loadMusics() {
        viewModelScope.launch(Dispatchers.IO) {
            _musics.value = musicDAO.findAll()
        }
    }

    fun insertMusic(music: Music) {
        viewModelScope.launch(Dispatchers.IO) {
            musicDAO.insert(music)
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
                return MusicViewModel(
                    AppDatabase.getInstance(application.applicationContext).musicDao()
                ) as T
            }
        }
    }
}