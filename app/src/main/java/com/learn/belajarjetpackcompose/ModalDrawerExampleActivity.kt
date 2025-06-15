package com.learn.belajarjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.learn.belajarjetpackcompose.ui.theme.BelajarJetpackComposeTheme
import kotlinx.coroutines.launch

class ModalDrawerExampleActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BelajarJetpackComposeTheme {
                ModalDrawerExample()
            }
        }
    }
}

@Composable
fun ModalDrawerExample() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                Text("Menu 1", modifier = Modifier.padding(16.dp))
                Text("Menu 2", modifier = Modifier.padding(16.dp))
                Button(
                    onClick = {
                        scope.launch { drawerState.close() }
                    }
                ) {
                    Text("Tutup Drawer")
                }
            }
        },
        drawerState = drawerState,
        scrimColor = MaterialTheme.colorScheme.inverseSurface
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text("Konten Utama")

            Button(
                onClick = {
                    scope.launch { drawerState.open() }
                }
            ) {
                Text("Buka Drawer")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ModalDrawerPreview() {
    ModalDrawerExample()
}