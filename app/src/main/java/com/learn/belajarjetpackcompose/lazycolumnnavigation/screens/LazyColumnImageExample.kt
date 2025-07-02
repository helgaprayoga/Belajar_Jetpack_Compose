package com.learn.belajarjetpackcompose.lazycolumnnavigation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.learn.belajarjetpackcompose.R

@Composable
fun LazyColumnImageApp(
    imageId: Array<Int>,
    names: Array<String>,
    description: Array<String>,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyRow(
            contentPadding = PaddingValues(16.dp)
        ) {
            val itemCount = imageId.size
            items(itemCount) { item ->
                ColumnItem(
                    itemIndex = item,
                    painter = imageId,
                    title = names,
                    description = description,
                    modifier,
                    navController = navController
                )
            }
        }
        LazyColumn(
            contentPadding = PaddingValues(16.dp)
        ) {
            val itemCount = imageId.size
            items(itemCount) { item ->
                ColumnItem(
                    itemIndex = item,
                    painter = imageId,
                    title = names,
                    description = description,
                    modifier,
                    navController = navController
                )
            }
        }
    }
}

@Composable
private fun ColumnItem(
    itemIndex: Int,
    painter: Array<Int>,
    title: Array<String>,
    description: Array<String>,
    modifier: Modifier,
    navController: NavController
) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .wrapContentSize()
            .clickable {
                navController.navigate(
                    route = "DetailScreen/$itemIndex"
                )
            },
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(start = 15.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Image(
                painter = painterResource(id = painter[itemIndex]),
                contentDescription = title[itemIndex],
                modifier.size(140.dp)
            )
            Column(
                modifier.padding(12.dp)
            ) {
                Text(text = title[itemIndex],
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Text(text = description[itemIndex],
                    fontSize = 12.sp,
                    color = Color.Black
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LazyColumnImagePreview() {
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
        LazyColumnImageApp(imageId, names, description, navController)
    }
}