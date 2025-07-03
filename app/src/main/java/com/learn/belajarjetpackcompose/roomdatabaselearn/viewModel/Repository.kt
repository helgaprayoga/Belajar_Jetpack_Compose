package com.learn.belajarjetpackcompose.roomdatabaselearn.viewModel

import com.learn.belajarjetpackcompose.roomdatabaselearn.roomDb.Note
import com.learn.belajarjetpackcompose.roomdatabaselearn.roomDb.NoteDatabase

class Repository(private val db : NoteDatabase) {
    suspend fun upsertNote(note: Note) {
        db.dao.upsertNote(note)
    }

    suspend fun deleteNote(note: Note) {
        db.dao.deleteNote(note)
    }

    fun getAllNotes() = db.dao.getAllNotes()
}