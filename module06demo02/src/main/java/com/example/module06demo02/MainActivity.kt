package com.example.module06demo02

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.module06demo02.ui.theme.Module01DemonstrationTheme
import com.example.module06demo02.vm.ListBookViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Module01DemonstrationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BookScreen()
                }
            }
        }
    }
}

@Composable
fun BookScreen(
    bookViewModel: ListBookViewModel = viewModel(factory = ListBookViewModel.Factory),
    modifier: Modifier = Modifier
) {
    val books by bookViewModel.books.collectAsState()

    LazyColumn {
        items(books) { book ->
            Text(text = "Name: ${book.name}, Author: ${book.author}")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Module01DemonstrationTheme {
    }
}