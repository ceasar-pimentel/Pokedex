package com.example.pokedex.data.database.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokedex")
data class PokedexEntry(
    @PrimaryKey
    val id: Int,
    val name: String,
    val url: String,
    val imageUrl: String
)