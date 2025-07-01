package com.learn.belajarjetpackcompose.navigationnestednav

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.learn.belajarjetpackcompose.screensnestednav.HomeScreenNested
import com.learn.belajarjetpackcompose.screensnestednav.ScreenANested
import com.learn.belajarjetpackcompose.screensnestednav.ScreenBNested

fun NavGraphBuilder.appNestedGraph(navController: NavController) {
    navigation(startDestination = NestedNavScreens.ScreenHomeRoute.route, route = NestedNavScreens.AppRoute.route) {
        composable(route = NestedNavScreens.ScreenHomeRoute.route) {
            HomeScreenNested(navController = navController)
        }
        composable(route = NestedNavScreens.ScreenARoute.route) {
            ScreenANested(navController = navController)
        }
        composable(route = NestedNavScreens.ScreenBRoute.route) {
            ScreenBNested(navController = navController)
        }
    }
}