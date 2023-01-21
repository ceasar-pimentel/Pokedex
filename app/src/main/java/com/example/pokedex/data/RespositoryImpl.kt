package com.example.pokedex.data

import com.example.pokedex.data.database.PokedexDao
import com.example.pokedex.data.database.models.PokedexEntry
import com.example.pokedex.data.database.models.PokedexPokemon
import com.example.pokedex.data.network.PokedexApiService
import com.example.pokedex.util.Response
import dagger.hilt.android.scopes.ActivityScoped
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import javax.inject.Inject

@ActivityScoped
class RepositoryImpl @Inject constructor(
    private val pokedexApi: PokedexApiService,
    private val pokedexDao: PokedexDao
) : Repository {


    // list is exposed with val pokemonList. new pokemon will be loaded here.
    override suspend fun getPokemonList(page: Int, pageSize: Int): Response<List<PokedexEntry>> {
        return try {
            val start  = page*pageSize + 1
            val end = page*pageSize + pageSize

            var pokedexList = pokedexDao.getPokedexList(start, end)

            // if not in cache query from the api
            if(pokedexList.isEmpty()) {
                val pokedexResults: List<PokedexEntry> =
                    pokedexApi.getPokemons(limit = pageSize, offset =page*pageSize).results.map {
                        it.toPokedex()
                    }
                pokedexDao.insertAllPokedexEntries(pokedexResults)
                pokedexList = pokedexDao.getPokedexList(start, end)
            }

            for(pokedexEntry in pokedexList) {
                Timber.d("id:${pokedexEntry.id} ${pokedexEntry.name} ")
            }

            Response.Success(pokedexList)
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