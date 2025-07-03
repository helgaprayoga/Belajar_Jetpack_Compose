package com.learn.belajarjetpackcompose.roomdatabaselearn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.learn.belajarjetpackcompose.roomdatabaselearn.roomDb.Note
import com.learn.belajarjetpackcompose.roomdatabaselearn.roomDb.NoteDatabase
import com.learn.belajarjetpackcompose.roomdatabaselearn.ui.theme.BelajarJetpackComposeTheme
import com.learn.belajarjetpackcompose.roomdatabaselearn.viewModel.NoteViewModel
import com.learn.belajarjetpackcompose.roomdatabaselearn.viewModel.Repository

class RoomDatabaseMainActivity : ComponentActivity() {
    private val db by lazy {
        Room.databaseBuilder(
            applicationContext,
            NoteDatabase::class.java,
            name = "note.db"
        ).build()
    }
    private val viewModel by viewModels<NoteViewModel> (
        factoryProducer = {
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return NoteViewModel(Repository(db)) as T
                }
            }
        }
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BelajarJetpackComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var name by remember {
                        mutableStateOf("")
                    }
                    var body by remember {
                        mutableStateOf("")
                    }
                    val note = Note(
                        name,
                        body
                    )
                    var noteList by remember {
                        mutableStateOf(listOf<Note>())
                    }
                    viewModel.getNotes().observe(this) {
                        noteList = it
                    }
                    Column(
                        modifier = Modifier.padding(12.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Button(
                            onClick = {
                                viewModel.upsertNote(note)
                            }
                        ) {
                            Text(text = "Set Data")
                        }
                        TextField(value = name, onValueChange = {name = it}, placeholder = { Text(
                            text = "name"
                        )})
                        TextField(value = body, onValueChange = {body = it}, placeholder = { Text(
                            text = "body"
                        )})

                        LazyColumn {
                            items(noteList) { note ->
                                Column(
                                    Modifier.clickable {
                                        viewModel.deleteNote(note)
                                    }
                                ) {
                                    Text(text = "Name = ${note.noteName}")
                                    Spacer(modifier = Modifier.height(6.dp))
                                    Text(text = "Body = ${note.noteBody}")
                                    Divider(Modifier.fillMaxWidth().padding(6.dp))
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}