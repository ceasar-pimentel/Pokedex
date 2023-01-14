package com.example.pokedex.di

import com.example.pokedex.data.Repository
import com.example.pokedex.data.RepositoryImpl
import com.example.pokedex.data.database.PokedexDao
import com.example.pokedex.data.network.PokedexApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun providePokedexRepository(
        pokedexApiService: PokedexApiService,
        pokedexDao: PokedexDao
    ): Repository {
        return RepositoryImpl(pokedexApiService, pokedexDao)
    }
}