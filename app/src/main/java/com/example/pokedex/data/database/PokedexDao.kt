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
    @Query("SELECT * FROM POKEDEX")
    fun getPokedexPokemonList(): Flow<List<PokedexEntry>>

    @Query("SELECT * from Pokemon")
    fun getAllPokemon(): Flow<List<PokedexPokemon>>

    @Query("SELECT * FROM Pokemon WHERE id = :id")
    fun getPokemonById(id: Int) : PokedexPokemon?

    @Query("SELECT * FROM Pokemon WHERE name = :name")
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