package com.learn.belajarjetpackcompose.navigationnestednav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.learn.belajarjetpackcompose.screensnestednav.ForgotPassNested
import com.learn.belajarjetpackcompose.screensnestednav.HomeScreenNested
import com.learn.belajarjetpackcompose.screensnestednav.LoginScreenNested
import com.learn.belajarjetpackcompose.screensnestednav.RegisterScreenNested
import com.learn.belajarjetpackcompose.screensnestednav.ScreenANested
import com.learn.belajarjetpackcompose.screensnestednav.ScreenBNested

@Composable
fun NestedNavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NestedNavScreens.AuthRoute.route) {

        authNestedGraph(navController)

        appNestedGraph(navController)

    }
}