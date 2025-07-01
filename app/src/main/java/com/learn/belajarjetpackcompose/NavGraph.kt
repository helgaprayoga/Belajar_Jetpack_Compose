package com.learn.belajarjetpackcompose

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Nav() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "A") {

        composable(route = "A") {
            ScreenANavigation(navController)
        }
        composable(route = "B") {
            ScreenBNavigation(navController)
        }
        composable(route = "C") {
            ScreenCNavigation(navController)
        }
    }
}