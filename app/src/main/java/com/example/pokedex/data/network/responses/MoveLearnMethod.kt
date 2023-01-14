package com.example.pokedex.data.network.responses


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MoveLearnMethod(
    val name: String,
    val url: String
)