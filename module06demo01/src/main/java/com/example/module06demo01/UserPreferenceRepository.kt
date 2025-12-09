package com.example.module06demo01

import android.content.Context
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserPreferenceRepository(private val context: Context) {
    private val Context.dataStore by preferencesDataStore(
        name = "user_preferences"
    )
    private val KEY_BACKGROUND_COLOR_SELECTED = intPreferencesKey("KEY_BACKGROUND_COLOR_SELECTED")

    suspend fun saveBackGroundColor(color: Color) {
        context.dataStore.edit { pref ->
            pref[KEY_BACKGROUND_COLOR_SELECTED] = color.toArgb()
        }
    }

    fun getBackgroundColor(): Flow<Color> {
        return context.dataStore.data.map { pref ->
            Color(pref[KEY_BACKGROUND_COLOR_SELECTED] ?: Color.White.toArgb())
        }
    }
}
