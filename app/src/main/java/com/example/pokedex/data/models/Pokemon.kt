package com.example.pokedex.data.models

import androidx.room.Entity
import kotlinx.serialization.Serializable

@Entity(tableName = "Pokemon")
@Serializable
data class Pokemon (val id: Int, val name: String)