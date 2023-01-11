package com.example.pokedex.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PokedexDao {
    @Query("SELECT * from Pokemon")
    fun getAll(): Flow<List<Pokemon>>

    @Query("SELECT * FROM Pokemon WHERE id = :id")
    fun getPokemonById(id: Int)

    @Insert()
    suspend fun insertAll(pokemon: List<Pokemon>)

    @Insert()
    suspend fun insertPokemon(pokemon: Pokemon)

    @Delete()
    suspend fun deletePokemon(pokemon: Pokemon)
}