package com.learn.belajarjetpackcompose.bottombarnestednav.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.learn.belajarjetpackcompose.bottombarnestednav.BottomBarScreen

@Composable
fun MainScreenNestedNavBottomBar() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomBarNestedNav(navController = navController)
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = BottomBarScreen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = BottomBarScreen.Home.route) {
                HomeScreenNestedNavBottomBar()
            }
            composable(route = BottomBarScreen.Shop.route) {
                ShopScreenNestedNavBottomBar()
            }
            composable(route = BottomBarScreen.Profile.route) {
                ProfileScreenNestedNavBottomBar()
            }
        }
    }
}