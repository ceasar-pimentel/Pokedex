package com.example.pokedex.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.pokedex.data.database.models.PokedexEntry
import com.example.pokedex.data.database.models.PokedexPokemon
import kotlinx.coroutines.flow.Flow

@Dao
interface PokedexDao {
    @Query("SELECT * FROM pokedex  WHERE id >= :start AND id <= :end")
    fun getPokedexList(start: Int, end: Int): List<PokedexEntry>

    @Query("SELECT * FROM pokemon WHERE id >= :start AND id <= :end")
    fun getPokemon(start: Int, end: Int): Flow<List<PokedexPokemon>>

    @Query("SELECT * FROM pokemon WHERE id = :id")
    fun getPokemonById(id: Int) : PokedexPokemon?

    @Query("SELECT * FROM pokemon WHERE name = :name")
    fun getPokemonByName(name: String) : PokedexPokemon?

    @Insert()
    suspend fun insertAllPokemon(pokemon: List<PokedexPokemon>)

    @Insert()
    suspend fun insertAllPokedexEntries(pokedex: List<PokedexEntry>)

    @Insert()
    suspend fun insertPokemon(pokemon: PokedexPokemon)

    @Delete()
    suspend fun deletePokemon(pokemon: PokedexPokemon)
}