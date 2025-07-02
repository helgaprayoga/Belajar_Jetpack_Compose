package com.learn.belajarjetpackcompose.lazycolumnnavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.learn.belajarjetpackcompose.R
import com.learn.belajarjetpackcompose.lazycolumnnavigation.screens.DetailScreenLazyColumnNav
import com.learn.belajarjetpackcompose.lazycolumnnavigation.screens.LazyColumnImageApp

class LazyColumnNavigationMainScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            setContent {
                com.learn.belajarjetpackcompose.ui.theme.BelajarJetpackComposeTheme {
                    Surface(
                        modifier = Modifier
                            .fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        val imageId = arrayOf(
                            R.drawable.indomie_goreng,
                            R.drawable.indomie_rendang,
                            R.drawable.indomie_cabe_ijo,
                            R.drawable.indomie_chicken,
                            R.drawable.indomie_chicken_curry,
                            R.drawable.indomie_special_chicken
                        )

                        val names = arrayOf(
                            "Indomie Goreng",
                            "Indomie Rendang",
                            "Indomie Cabe Ijo",
                            "Indomie Kuah Ayam",
                            "Indomie Kuah Kari Ayam",
                            "Indomie Kuah Ayam Spesial"
                        )

                        val description = arrayOf(
                            "Indomie Goreng",
                            "Indomie Rendang",
                            "Indomie Cabe Ijo",
                            "Indomie Kuah Ayam",
                            "Indomie Kuah Kari Ayam",
                            "Indomie Kuah Ayam Spesial"
                        )

                        val navController = rememberNavController()
                        NavHost(
                            navController = navController,
                            startDestination = "MainScreen"
                        ) {
                            composable(route = "MainScreen") {
                                LazyColumnImageApp(imageId, names, description, navController)
                            }
                            composable(
                                route = "DetailScreen/{index}",
                                arguments = listOf(
                                    navArgument(name = "index") {
                                        type = NavType.IntType
                                    }
                                )
                            ) { index ->
                                DetailScreenLazyColumnNav(
                                    photos = imageId,
                                    names = names,
                                    description = description,
                                    itemIndex = index.arguments?.getInt("index")
                                )
                            }
                        }

                    }
                }
            }
        }
    }
}
