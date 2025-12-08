package com.example.module05demo04

import androidx.navigation.NavType
import androidx.navigation.navArgument

object SignInDestination {
    val route: String = "signIn"
}

object HomeDestination {
    val route: String = "home"

    val signInValueArgName = "signInValue"

    val args = listOf(
        navArgument(signInValueArgName) {
            type = NavType.StringType
        }
    )

    val routeWithArgs = "$route/{$signInValueArgName}"
}