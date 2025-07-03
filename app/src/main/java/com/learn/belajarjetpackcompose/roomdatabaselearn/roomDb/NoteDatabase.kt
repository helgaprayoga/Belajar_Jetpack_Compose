package com.learn.belajarjetpackcompose.roomdatabaselearn.roomDb

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Note::class],
    version = 1
)
abstract class NoteDatabase: RoomDatabase() {
    abstract val dao : RoomDao
}