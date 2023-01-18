package com.example.pokedex.data.database.models

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "pokemon"
)
data class PokedexPokemon(
    @PrimaryKey
    val id: Int,
    val name: String,
    val frontDefaultSprite: String,
    val height: Int,
    val weight: Int,
    val baseExperience: Int,

    )
