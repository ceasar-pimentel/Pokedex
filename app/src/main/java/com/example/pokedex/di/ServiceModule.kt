package com.example.pokedex.di

import com.example.pokedex.data.network.PokedexApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import javax.inject.Singleton

@OptIn(ExperimentalSerializationApi::class)
@InstallIn(SingletonComponent::class)
@Module
object ServiceModule {
    private val BASE_URL = "https://pokeapi.co/api/v2/"

    @Provides
    @Singleton
    fun providePokedexService(): PokedexApiService {
        val retrofit: Retrofit = Retrofit.Builder()
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .baseUrl(BASE_URL)
            .build()
        return retrofit.create(PokedexApiService::class.java)
    }
}