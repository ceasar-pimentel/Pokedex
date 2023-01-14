package com.example.pokedex.data.network.responses


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonList(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<Result>
)