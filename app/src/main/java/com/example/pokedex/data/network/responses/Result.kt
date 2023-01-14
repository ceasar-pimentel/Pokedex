package com.example.pokedex.data.network.responses


import com.example.pokedex.data.database.models.Pokedex
import kotlinx.serialization.Serializable

@Serializable
data class Result(
    val name: String,
    val url: String
) {
    fun toPokedex(): Pokedex {
        return Pokedex(name = name, url = url, imageUrl = getImageUrlFromPokemonUrl(), id = getId())
    }

    private fun getImageUrlFromPokemonUrl(): String {
        val number: String = if (url.endsWith("/")) {
            url.dropLast(1).takeLastWhile { it.isDigit() }
        } else {
            url.takeLastWhile { it.isDigit() }
        }
        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${number}.png"
    }

    private fun getId(): Int {
        val number: String = if (url.endsWith("/")) {
            url.dropLast(1).takeLastWhile { it.isDigit() }
        } else {
            url.takeLastWhile { it.isDigit() }
        }
        return number.toInt()
    }
}