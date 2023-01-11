package com.example.pokedex.data.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface PokedexApiService {
}

class Container {
    private val BASE_URL = "https://pokeapi.co/api/v2/pokemon/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build()

    val retrofitService: PokedexApiService by lazy {
        retrofit.create(PokedexApiService::class.java)
    }
}