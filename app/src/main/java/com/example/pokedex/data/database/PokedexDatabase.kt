package com.example.pokedex.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pokedex.data.database.models.PokedexEntry
import com.example.pokedex.data.database.models.PokedexPokemon


@Database(entities = [PokedexPokemon::class, PokedexEntry::class], version = 1, exportSchema = false)
abstract class PokedexDatabase: RoomDatabase() {
    abstract fun pokedexDao(): PokedexDao

}