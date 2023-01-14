package com.example.pokedex.data.database.models

import androidx.room.Entity

@Entity(tableName = "pokedex")
data class PokedexEntry(
    val id: Int,
    val name: String,
    val url: String,
    val imageUrl: String
)