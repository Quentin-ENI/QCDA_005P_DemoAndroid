package com.example.module06demo01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.module06demo01.ui.theme.Module01DemonstrationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Module01DemonstrationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SettingsScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun SettingsScreen(
    settingsViewModel: SettingsViewModel = viewModel(factory = SettingsViewModel.Factory),
    modifier: Modifier = Modifier
) {
    val colors by settingsViewModel.colors.collectAsState()
    val userColor by settingsViewModel.userColor.collectAsState()

    Scaffold(containerColor = userColor) {
        Column {
            colors.forEach { color ->
                Spacer(
                    modifier = Modifier
                        .background(color)
                        .height(50.dp)
                        .fillMaxWidth()
                        .border(1.dp, Color.Black)
                        .clickable {
                            settingsViewModel.setBackgroundColor(color)
                        }
                )
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    Module01DemonstrationTheme {
//        SettingsScreen()
//    }
//}