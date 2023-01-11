package com.example.pokedex.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Pokemon::class], version = 1)
abstract class PokedexDatabase: RoomDatabase() {
    abstract fun pokedexDao(): PokedexDao

    companion object {
        @Volatile
        var INSTANCE: PokedexDatabase? = null

        fun getDatabase(context: Context): PokedexDatabase {
            return INSTANCE ?: Room.databaseBuilder(context, PokedexDatabase::class.java, "pokedex_database")
                .fallbackToDestructiveMigration().build()        }
    }
}