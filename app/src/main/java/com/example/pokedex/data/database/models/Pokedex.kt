package com.example.pokedex.data.database.models

import androidx.room.Entity

@Entity(tableName = "pokedex")
data class Pokedex(
    val id: Int,
    val name: String,
    val url: String,
    val imageUrl: String
) {
    companion object {
        fun getImageUrlFromPokemonUrl(url: String): String {
            val number: String = if (url.endsWith("/")) {
                url.dropLast(1).takeLastWhile { it.isDigit() }
            } else {
                url.takeLastWhile { it.isDigit() }
            }
            return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${number}.png"
        }
    }
}