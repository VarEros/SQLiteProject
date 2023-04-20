package com.example.sqliteproject.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.sqliteproject.entities.Person

// Annotates class to be a Room Database with a table (entity) of the Word class
@Database(entities = arrayOf(Person::class), version = 1, exportSchema = false)
public abstract class RoomDB : RoomDatabase() {

    abstract fun PersonDao(): Person

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: RoomDB? = null

        fun getDatabase(context: Context): RoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RoomDB::class.java,
                    "SQLiteProjectDB"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}
