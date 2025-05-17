package com.learn.belajarjetpackcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import coil3.request.ImageRequest
import com.learn.belajarjetpackcompose.ui.theme.BelajarJetpackComposeTheme

class CustomAlertDialogExample : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var dialogState by remember {
                mutableStateOf(false)
            }

            Button(
                modifier = Modifier.padding(20.dp),
                onClick = {
                    dialogState = true
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red,
                    contentColor = Color.White
                )
            ) {
                Text(text = "Toogle Dialog")
            }

            CustomAlertDialog(dialogState = dialogState, onDismissRequest = {
              dialogState = !it
            })
        }
    }
}

@Composable
fun CustomAlertDialog(
    dialogState: Boolean,
    onDismissRequest: (dialogState: Boolean) -> Unit
) {
    if(dialogState) {
        AlertDialog(
            containerColor = Color.DarkGray,
            onDismissRequest = {
                onDismissRequest(dialogState)
            },
            title = null,
            text = null,
            confirmButton = {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.padding(vertical = 16.dp))

                    Image(
                        painter = painterResource(id = R.drawable.jetpack_compose_icon),
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(200.dp)
                    )

                    Spacer(modifier = Modifier.padding(vertical = 20.dp))

                    Text(
                        text = "Belajar Jetpack Compose",
                        fontSize = 16.sp,
                        color = Color.White
                    )

                    Text(
                        text = "Hello Hello",
                        fontSize = 12.sp,
                        color = Color.LightGray
                    )

                    Spacer(modifier = Modifier.padding(vertical = 16.dp))

                    HorizontalDivider(
                        modifier = Modifier.padding(horizontal = 16.dp), thickness = 0.8.dp,
                        color = Color.White
                    )

                    Row(
                      modifier = Modifier
                          .fillMaxWidth()
                          .padding(10.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        val context = LocalContext.current

                        TextButton(
                            modifier = Modifier.height(40.dp).weight(1f),
                            onClick = {
                                onDismissRequest(dialogState)
                                Toast.makeText(context, "nice", Toast.LENGTH_SHORT).show()
                            },
                            colors = ButtonDefaults.textButtonColors(
                                containerColor = Color.Red,
                                contentColor = Color.White
                            )
                        ) {
                            Text(text = "Hello")
                        }

                        Spacer(modifier = Modifier.padding(horizontal = 10.dp))

                        TextButton(
                            modifier = Modifier.height(40.dp).weight(1f),
                            onClick = {
                                onDismissRequest(dialogState)
                                Toast.makeText(context, "-_-", Toast.LENGTH_SHORT).show()
                            },
                            colors = ButtonDefaults.textButtonColors(
                                containerColor = Color.DarkGray,
                                contentColor = Color.LightGray
                            )
                        ) {
                            Text(text = "Cancel")
                        }
                    }
                }
            },
            properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false),

        )
    }
}

@Preview(showBackground = true)
@Composable
fun CustomAlertDialogPreview() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
    }
}