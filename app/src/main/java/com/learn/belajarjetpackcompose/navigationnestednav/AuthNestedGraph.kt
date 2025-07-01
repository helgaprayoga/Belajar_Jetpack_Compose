package com.learn.belajarjetpackcompose.navigationnestednav

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.learn.belajarjetpackcompose.screensnestednav.ForgotPassNested
import com.learn.belajarjetpackcompose.screensnestednav.LoginScreenNested
import com.learn.belajarjetpackcompose.screensnestednav.RegisterScreenNested

fun NavGraphBuilder.authNestedGraph(navController: NavController) {
    navigation(startDestination = NestedNavScreens.ScreenLoginRoute.route, route = NestedNavScreens.AuthRoute.route) {
        composable(route = NestedNavScreens.ScreenLoginRoute.route) {
            LoginScreenNested(navController = navController)
        }
        composable(route = NestedNavScreens.ScreenForgotPassRoute.route) {
            ForgotPassNested(navController = navController)
        }
        composable(route = NestedNavScreens.ScreenRegisterRoute.route) {
            RegisterScreenNested(navController = navController)
        }
    }
}