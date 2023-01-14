package com.example.pokedex.data.network.responses


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HeldItem(
    val item: Item,
    @SerialName("version_details")
    val versionDetails: List<VersionDetail>
)