package com.example.pokedex.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.pokedex.data.models.Pokemon


@Database(entities = [Pokemon::class], version = 1)
abstract class PokedexDatabase: RoomDatabase() {
    abstract fun pokedexDao(): PokedexDao

}