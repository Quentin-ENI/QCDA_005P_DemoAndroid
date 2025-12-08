package com.example.module05demo02

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat.startActivity
import com.example.module05demo02.ui.theme.Module01DemonstrationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Module01DemonstrationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GeoLocation(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun GeoLocation(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Column {
        Button(
            onClick = {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:48.039, -1.692"))
                context.startActivity(intent)
            }
        ) {
            Text(text="GO!")
        }
        val requestPermissionLauncher = rememberLauncherForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted ->
            if (isGranted) {
                val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:0601020304"))
                context.startActivity(intent)
            } else {
                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:0601020304"))
                context.startActivity(intent)
            }
        }
        Button(
            onClick = {
                requestPermissionLauncher.launch(android.Manifest.permission.CALL_PHONE)
            }
        ) {
            Text(text="Appeler un ami")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Module01DemonstrationTheme {
        GeoLocation()
    }
}