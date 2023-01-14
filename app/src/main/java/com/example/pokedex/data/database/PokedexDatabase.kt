package com.example.pokedex.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pokedex.data.database.models.PokedexPokemon


@Database(entities = [PokedexPokemon::class], version = 1)
abstract class PokedexDatabase: RoomDatabase() {
    abstract fun pokedexDao(): PokedexDao

}