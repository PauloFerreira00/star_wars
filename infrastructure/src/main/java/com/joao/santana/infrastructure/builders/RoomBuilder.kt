package com.joao.santana.infrastructure.builders

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [], version = 1, exportSchema = false)
abstract class RoomBuilder : RoomDatabase() {

    companion object {
        const val DATABASE_NAME: String = "star_wars_db"
    }
}