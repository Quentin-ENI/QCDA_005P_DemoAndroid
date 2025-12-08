package com.example.module05demo04.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    signInValue: String,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = Modifier.padding(16.dp),
        text = "Bienvenue $signInValue sur votre espace"
    )
}