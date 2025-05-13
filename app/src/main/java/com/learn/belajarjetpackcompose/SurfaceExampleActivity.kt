package com.learn.belajarjetpackcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.ripple
import com.learn.belajarjetpackcompose.ui.theme.BelajarJetpackComposeTheme

class SurfaceExampleActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BelajarJetpackComposeTheme {
                SurfaceExample()
            }
        }
    }
}

@Composable
fun SurfaceExample1() {
    val context = LocalContext.current
    val interactionSource = remember { MutableInteractionSource()}

    Surface(
        shape = RoundedCornerShape(8.dp),
        shadowElevation = 5.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        color = MaterialTheme.colorScheme.surface
    ) {
        Column(
            modifier = Modifier
                .clickable(
                    interactionSource = interactionSource,
                    indication = ripple(bounded = true, color = Color.Red),
                    onClick = {
                        Toast.makeText(context, "Surface Example 1", Toast.LENGTH_SHORT).show()
                    }
                ).padding(15.dp)
        ) {
            Text(
                buildAnnotatedString {
                    append("Hello ")
                    withStyle(
                        style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Blue)
                    ) {
                        append("World")
                    }
                }
            )

            Spacer(modifier = Modifier.padding(vertical = 3.dp))

            Text(
                buildAnnotatedString {
                    append("Hello Hello")
                    withStyle(
                        style = SpanStyle(fontFamily = FontFamily.Monospace, color = Color.Cyan)
                    ) {
                        append("\nWorld World")
                    }
                }
            )
        }
    }
}

@Composable
fun SurfaceExample2() {
    val context = LocalContext.current
    val interactionSource = remember { MutableInteractionSource() }

    Surface(
        shape = RoundedCornerShape(8.dp),
        shadowElevation = 5.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .clickable (
                    interactionSource = interactionSource,
                    indication = ripple(bounded = true, color = Color.Green),
                    onClick = {
                        Toast.makeText(context, "Surface Example 2", Toast.LENGTH_SHORT).show()
                    }
                ).padding(15.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.jetpack_compose_icon),
                contentDescription = "Jetpack Compose Icon",
                modifier = Modifier
                    .size(90.dp)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    buildAnnotatedString {
                        append("Jetpack ")
                        withStyle(
                            style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Green)
                        ) {
                            append("Compose")
                        }
                    },
                    style = MaterialTheme.typography.titleLarge
                )

                Spacer(modifier = Modifier.padding(vertical = 3.dp))

                Text(
                    buildAnnotatedString { 
                        append("Belajar")
                        withStyle(
                            style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Blue)
                        ) {
                            append("Jetpack Compose")
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun SurfaceExample() {
    Column {
        SurfaceExample1()
        SpaceLine()
        SurfaceExample2()
    }
}

@Preview(showBackground = true)
@Composable
fun SurfaceExamplePreview() {
    SurfaceExample()
}