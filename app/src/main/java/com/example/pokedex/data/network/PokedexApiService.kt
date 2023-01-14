package com.example.pokedex.data.network

import com.example.pokedex.data.network.responses.Pokemon
import com.example.pokedex.data.network.responses.PokemonList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokedexApiService {

    @GET("pokemon")
    suspend fun getPokemons(@Query("limit")limit: Int, @Query("offset")offset: Int) : PokemonList

    @GET("pokemon/{name}")
    suspend fun getPokemon(@Path("name")name: String) : Pokemon
}

