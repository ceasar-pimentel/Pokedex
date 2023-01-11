package com.example.pokedex.data.local

import androidx.room.Entity

@Entity(tableName = "Pokemon")
data class Pokemon (val id: Int, val name: String)