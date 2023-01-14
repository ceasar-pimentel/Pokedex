package com.example.pokedex.data

import com.example.pokedex.data.database.models.PokedexEntry
import com.example.pokedex.data.database.models.PokedexPokemon
import com.example.pokedex.util.PokedexResponse
import com.example.pokedex.util.Response
import kotlinx.coroutines.flow.Flow

interface Repository {
    val pokedexList: Flow<List<PokedexEntry>>

    suspend fun getPokemonList(limit: Int, offset: Int): Response<List<PokedexEntry>>

    suspend fun getPokemonDetails(name: String): Response<PokedexPokemon>
}