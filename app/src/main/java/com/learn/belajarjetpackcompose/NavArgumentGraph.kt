package com.learn.belajarjetpackcompose

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun GraphNavArgument() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home") {
        composable(
            route = "Home"
        ) {
            HomeScreenNavArguments(navController)
        }
        composable(
            route = "Detail?name={name}&age={age}",
            arguments = listOf(
                navArgument(name = "name") {
                    type = NavType.StringType
//                    defaultValue = "user"
                },
                navArgument(name = "age") {
                    type = NavType.IntType
                    defaultValue = 0
//                    nullable = true
                }
            )
        ) { backstackEntry ->
            DetailScreenNavArguments(
                myName = backstackEntry.arguments?.getString("name"),
                myAge = backstackEntry.arguments?.getInt("age")
            )
        }
    }
}