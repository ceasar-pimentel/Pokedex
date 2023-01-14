package com.example.pokedex.data.network.responses


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Stat(
    @SerialName("base_stat")
    val baseStat: Int,
    val effort: Int,
    val stat: StatX
)