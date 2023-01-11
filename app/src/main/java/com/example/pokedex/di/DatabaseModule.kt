package com.example.pokedex.di

import android.content.Context
import androidx.room.Room
import com.example.pokedex.data.database.PokedexDao
import com.example.pokedex.data.database.PokedexDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {
    @Provides
    fun providePokemonDao(database: PokedexDatabase): PokedexDao {
        return database.pokedexDao()
    }

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): PokedexDatabase {
        return Room.databaseBuilder(appContext, PokedexDatabase::class.java, "pokedex_database")
            .fallbackToDestructiveMigration().build()
    }
}