package com.example.pokedex.data

import com.example.pokedex.data.database.PokedexDao
import com.example.pokedex.data.database.models.PokedexEntry
import com.example.pokedex.data.database.models.PokedexPokemon
import com.example.pokedex.data.network.PokedexApiService
import com.example.pokedex.util.Response
import dagger.hilt.android.scopes.ActivityScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ActivityScoped
class RepositoryImpl @Inject constructor(
    private val pokedexApi: PokedexApiService,
    private val pokedexDao: PokedexDao
) : Repository {

    // this is how the google code lab implements this with live data.
    // I'm not quite sure if there is a better way
    override val pokedexList: Flow<List<PokedexEntry>>
        get() = pokedexDao.getPokedexPokemonList()

    override suspend fun getPokemonList(limit: Int, offset: Int): Response<List<PokedexEntry>> {
        return try {
            val pokedexResults: List<PokedexEntry> =
                pokedexApi.getPokemons(limit, offset).results.map {
                    it.toPokedex()
                }

            pokedexDao.insertAllPokedexEntries(pokedexResults)
            Response.Success()

        } catch (e: Exception) {
            Response.Error(message = e.message ?: "unknown exception occurred")
        }
    }

    // the pokemon details are exposed by returning it in the response.
    override suspend fun getPokemonDetails(name: String): Response<PokedexPokemon> {
        return try {
            var pokemon: PokedexPokemon? = pokedexDao.getPokemonByName(name)

            // if it doesn't exist in the database
            if (pokemon == null) {
                pokemon = pokedexApi.getPokemon(name).toPokedexPokemon()
                pokedexDao.insertPokemon(pokemon)
            }

            Response.Success(pokemon)
        } catch (e: Exception) {
            Response.Error(message = e.message ?: "unknown exception occurred")
        }
    }
}