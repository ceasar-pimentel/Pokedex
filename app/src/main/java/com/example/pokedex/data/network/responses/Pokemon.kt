package com.example.pokedex.data.network.responses


import androidx.compose.ui.Modifier
import com.example.pokedex.data.database.models.PokedexPokemon
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Pokemon(
    val abilities: List<Ability>,
    @SerialName("base_experience")
    val baseExperience: Int,
    val forms: List<Form>,
    @SerialName("game_indices")
    val gameIndices: List<GameIndice>,
    val height: Int,
    @SerialName("held_items")
    val heldItems: List<HeldItem>,
    @SerialName("is_default")
    val isDefault: Boolean,
    @SerialName("location_area_encounters")
    val locationAreaEncounters: String,
    val id: Int,
    val moves: List<Move>,
    val name: String,
    val order: Int,
    @SerialName("past_types")
    val pastTypes: List<PastType>,
    val species: Species,
    val sprites: Sprites,
    val stats: List<Stat>,
    val types: List<Type>,
    val weight: Int
){
    fun toPokedexPokemon() : PokedexPokemon {
        return PokedexPokemon(name = name, id = id, frontDefaultSprite = sprites.frontDefault, height = height, weight = weight, baseExperience = baseExperience)
    }
}