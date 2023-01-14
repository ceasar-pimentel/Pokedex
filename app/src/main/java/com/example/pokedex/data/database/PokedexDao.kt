package com.example.pokedex.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.pokedex.data.database.models.Pokedex
import com.example.pokedex.data.database.models.PokedexPokemon
import kotlinx.coroutines.flow.Flow

@Dao
interface PokedexDao {
    @Query("SELECT * FROM POKEDEX")
    fun getPokemonList(): Flow<List<Pokedex>>

    @Query("SELECT * from Pokemon")
    fun getAll(): Flow<List<PokedexPokemon>>

    @Query("SELECT * FROM Pokemon WHERE id = :id")
    fun getPokemonById(id: Int)

    @Insert()
    suspend fun insertAll(pokemon: List<PokedexPokemon>)

    @Insert()
    suspend fun insertPokemon(pokemon: PokedexPokemon)

    @Delete()
    suspend fun deletePokemon(pokemon: PokedexPokemon)
}