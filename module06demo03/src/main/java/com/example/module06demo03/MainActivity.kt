package com.example.module06demo03

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.module06demo03.ui.theme.Module01DemonstrationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Module01DemonstrationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MusicScreen()
                }
            }
        }
    }
}

@Composable
fun MusicScreen(
    viewModel: MusicViewModel = viewModel(factory = MusicViewModel.Factory),
    modifier: Modifier = Modifier
) {
    val musics by viewModel.musics.collectAsState(initial = emptyList())
    LazyColumn(
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize()
    ) {
        items(musics) { music ->
            Text(text = "Name : ${music.title}, author : ${music.author}")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Module01DemonstrationTheme {
    }
}