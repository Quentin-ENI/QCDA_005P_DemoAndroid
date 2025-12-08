package com.example.module05demo04

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.module05demo04.ui.screens.HomeScreen
import com.example.module05demo04.ui.screens.SignInScreen
import com.example.module05demo04.ui.theme.Module01DemonstrationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Module01DemonstrationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    DemoApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun DemoApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = SignInDestination.route
    ) {
        composable(
            route = SignInDestination.route
        ) {
            SignInScreen(onClickToHome = {
                navController.navigate("${HomeDestination.route}/$it")
            })
        }
        composable(
            route = HomeDestination.routeWithArgs,
            arguments = HomeDestination.args
        ) {
            navBackStackEntry ->
                val signInValue = navBackStackEntry
                    .arguments?.getString(HomeDestination.signInValueArgName) ?: "Michel"
                HomeScreen(signInValue)
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    Module01DemonstrationTheme {}
//}