package com.learn.belajarjetpackcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.Indication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.ripple
import com.learn.belajarjetpackcompose.ui.theme.BelajarJetpackComposeTheme

class CardExampleActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BelajarJetpackComposeTheme {
                Cardexample()
            }
        }
    }
}

@Composable
fun CardExample1() {
    val context = LocalContext.current

    Card(
       modifier = Modifier
           .fillMaxWidth()
           .padding(16.dp)
           .clickable (
               interactionSource = CreateMutableInteractionSource(),
               indication = ripple(bounded = true, color = Color.Gray),
               onClick = {
                   Toast
                       .makeText(context, "Card Example 1", Toast.LENGTH_SHORT)
                       .show()
               }
           ),
        colors = CardDefaults.cardColors(Color.Cyan),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Text(
            modifier = Modifier.padding(16.dp),
            text = "Hello World"
        )
    }
}

@Composable
fun CardExample2() {
    val context = LocalContext.current

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable (
                interactionSource = CreateMutableInteractionSource(),
                indication = ripple(bounded = true, color = Color.Gray),
                onClick = {
                    Toast
                        .makeText(context, "Card Example 2", Toast.LENGTH_SHORT)
                        .show()
                }
            ),
        colors = CardDefaults.cardColors(Color.Cyan),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.jetpack_compose_icon),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(70.dp)
                    .clip(CircleShape)
            )
        }
    }
}

@Composable
fun CardExample3() {
    val context = LocalContext.current

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable (
                interactionSource = CreateMutableInteractionSource(),
                indication = ripple(bounded = true, color = Color.Gray),
                onClick = {
                    Toast
                        .makeText(context, "Card Example 3", Toast.LENGTH_SHORT)
                        .show()
                }
            ),
        colors = CardDefaults.cardColors(Color.Cyan),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.jetpack_compose_icon),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(70.dp)
                    .clip(CircleShape)
            )

            Column {
                Text(
                    buildAnnotatedString {
                        append("Hello ")
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Red)) {
                            append("World")
                        }
                    }
                )
                
                Spacer(modifier = Modifier.padding(vertical = 3.dp))

                Text(
                    buildAnnotatedString {
                        append("Learn ")
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                            append("Jetpack Compose")
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun CreateMutableInteractionSource() : MutableInteractionSource = remember {
    MutableInteractionSource()
}

@Composable
fun Cardexample() {
    Column {
        CardExample1()
        SpaceLine()
        CardExample2()
        SpaceLine()
        CardExample3()
    }
}

@Preview(showBackground = true)
@Composable
fun CardExamplePreview() {
    Cardexample()
}