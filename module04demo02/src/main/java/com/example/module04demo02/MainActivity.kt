package com.example.module04demo02

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.module04demo02.ui.theme.Module01DemonstrationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Module01DemonstrationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RockBandScreen()
                }
            }
        }
    }
}

@Composable
fun RockBandScreen(
    rockBandViewModel: RockBandViewModel = viewModel(factory = RockBandViewModel.Factory),
    modifier: Modifier = Modifier
) {
    val rockBands by rockBandViewModel.bands.collectAsState()

    Column {
        for (rockBand in rockBands) {
            Text(text = rockBand)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Module01DemonstrationTheme {
        RockBandScreen()
    }
}