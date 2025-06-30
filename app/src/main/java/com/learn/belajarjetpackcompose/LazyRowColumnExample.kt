package com.learn.belajarjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.learn.belajarjetpackcompose.ui.theme.BelajarJetpackComposeTheme
import org.intellij.lang.annotations.Language

class LazyRowColumnExample : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BelajarJetpackComposeTheme {
                val languages = listOf(
                    "Kotlin",
                    "Java",
                    "Java Script",
                    "Python",
                    "Ruby",
                    "Dart",
                    "PHP",
                    "Swift"
                )

                LazyRowColumnApp(modifier = Modifier, languages)
            }
        }
    }
}

@Composable
fun LazyRowColumnApp(modifier: Modifier, languages: List<String>) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyRow {
            items(items = languages) { item ->
                RowItem(modifier = modifier, languagesName = item)
            }
        }

        LazyColumn {
            items(items = languages) { item ->
                ColumnItem(modifier = modifier, languagesName = item)
            }
        }
    }
}

@Composable
fun RowItem(modifier: Modifier, languagesName: String) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .height(100.dp)
            .aspectRatio(1.5f),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Box(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = languagesName, fontSize = 22.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun ColumnItem(modifier: Modifier, languagesName: String) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .aspectRatio(3f),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Box(
            modifier = modifier
                .padding(10.dp)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = languagesName, fontSize = 22.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LazyRowColumnPreview() {
    val languages = listOf(
        "Kotlin",
        "Java",
        "Java Script",
        "Python",
        "Ruby",
        "Dart",
        "PHP",
        "Swift"
    )

    LazyRowColumnApp(modifier = Modifier, languages)
}