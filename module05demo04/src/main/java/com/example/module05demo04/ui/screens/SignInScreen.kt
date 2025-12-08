package com.example.module05demo04.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

@Composable
fun SignInScreen(
    onClickToHome: (String) -> Unit
) {
    var signInValue by rememberSaveable() { mutableStateOf("") }

    Column {
        Text("Connectez-vous")
        TextField(
            value = signInValue,
            onValueChange = {
                signInValue = it
            },
            label = { Text("Sign in ?") }
        )
        Button(
            onClick = { onClickToHome(signInValue) }
        ) {
            Text(text = "Se connecter")
        }
    }
}