package fr.eni.ecole.module01demonstration

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.eni.ecole.module01demonstration.ui.theme.Module01DemonstrationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Module01DemonstrationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    Column {
                        MyFirstComponent(
                            modifier = Modifier.padding(innerPadding)
                        )
                        MySecondComponent(
                            modifier = Modifier
                        )
                    }



                }
            }
        }
    }
}

@Composable
fun MyFirstComponent(modifier: Modifier = Modifier) {
    Row {
        Box(
            contentAlignment = Alignment.BottomEnd
        ) {
            Image(
                painter = painterResource(id = R.drawable.chien),
                contentDescription = "Image ancienne"
            )
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = "Icône favorite",
                tint = Color.Red
            )
        }
        Column {
            Text(
                text = "Alfred Sisley",
                fontWeight = FontWeight.Bold,
                modifier = modifier
            )
            Text(
                text = "3 minutes ago",
                color = Color.Gray
            )
        }
    }
}

@Composable
fun MySecondComponent(modifier: Modifier = Modifier) {
    Row {
        Icon(
            imageVector = Icons.Filled.Email,
            contentDescription = "Email"
        )
        Spacer(modifier = modifier.weight(1F))
        Text(text = "john@doe.fr")
        Spacer(modifier = modifier.weight(3F))
        Text(text="A envoyer")

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Module01DemonstrationTheme {
        MySecondComponent()
    }
}