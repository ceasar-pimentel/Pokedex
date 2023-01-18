package com.example.pokedex.data

import com.example.pokedex.data.database.models.PokedexEntry
import com.example.pokedex.data.database.models.PokedexPokemon
import com.example.pokedex.util.PokedexResponse
import com.example.pokedex.util.Response
import kotlinx.coroutines.flow.Flow

interface Repository {

    suspend fun getPokemonList(page: Int, pageSize: Int): Response<List<PokedexEntry>>

    suspend fun getPokemonDetails(name: String): Response<PokedexPokemon>

}