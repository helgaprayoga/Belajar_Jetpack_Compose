package com.learn.belajarjetpackcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.compose.rememberAsyncImagePainter
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.learn.belajarjetpackcompose.ui.theme.BelajarJetpackComposeTheme

class ImageExampleActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BelajarJetpackComposeTheme {
                ImageExample()
            }
        }
    }
}

@Composable
fun ImageExample() {
    Column() {
        ImageResource()
        SpaceLine()
        ShapeImage()
        SpaceLine()
        ImageUrl()
        SpaceLine()
        ImageSurfaceShape()
    }
}

@Composable
fun ImageResource() {
    Column {
        Image(
            painter = painterResource(id = R.drawable.jetpack_compose_icon),
            contentDescription = "Jetpack Compose Icon",
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.padding(vertical = 3.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.jetpack_compose_icon),
                contentDescription = "Jetpack Compose Icon",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .height(120.dp)
                    .width(70.dp)
                    .background(Color.Green)
            )

            Spacer(modifier = Modifier.padding(horizontal = 3.dp))

            Image(
                painter = painterResource(id = R.drawable.jetpack_compose_icon),
                contentDescription = "Jetpack Compose Icon",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(120.dp)
                    .width(70.dp)
                    .background(Color.Green)
            )
        }
    }
}

@Composable
fun ShapeImage() {
    val context = LocalContext.current

    Image(
        painter = painterResource(id = R.drawable.jetpack_compose_icon),
        contentDescription = "Jetpack Compose Icon",
        contentScale = ContentScale.Fit,
        modifier = Modifier
            .size(50.dp)
            .clip(CircleShape)
            .clickable {
                Toast.makeText(context, "Jetpack Compose", Toast.LENGTH_SHORT).show()
            }
    )
}

@Composable
fun ImageUrl() {
    AsyncImage(
        model = "https://developer.android.com/static/images/brand/android-head_flat.png",
        contentDescription = "Android Logo",
        modifier = Modifier.size(150.dp)
    )
}

@Composable
fun ImageSurfaceShape() {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Surface(
            shape = CircleShape,
            color = Color.Magenta
        ) {
            Image(
                painter = painterResource(id = R.drawable.jetpack_compose_icon),
                contentDescription = "Jetpack Compose Icon",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.size(50.dp)
            )
        }

        Spacer(modifier = Modifier.padding(horizontal = 3.dp))

        Surface(
            shape = CircleShape,
            border = BorderStroke(5.dp, Color.Cyan)
        ) {
            Image(
                painter = painterResource(id = R.drawable.jetpack_compose_icon),
                contentDescription = "Jetpack Compose Icon",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.size(50.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ImagePreview() {
    ImageExample()
}