package com.example.pokedex.data.database.models

import androidx.room.Entity
import kotlinx.serialization.Serializable

@Entity(tableName = "Pokemon")
data class PokedexPokemon(
    val id: Int,
    val name: String,
    val frontDefaultSprite: String)
