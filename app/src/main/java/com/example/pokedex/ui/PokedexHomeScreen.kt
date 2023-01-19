package com.example.pokedex.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.pokedex.data.Repository
import com.example.pokedex.data.database.models.PokedexEntry
import com.example.pokedex.data.database.models.PokedexPokemon
import com.example.pokedex.util.Response

@Composable
fun PokedexHomeScreen(viewModel: PokedexHomeViewModel = hiltViewModel()) {
    val scrollState = rememberLazyListState()

    LazyColumn(state = scrollState ,modifier = Modifier.fillMaxSize()) {
        // when the last item enters the composition (is visible on the screen) the item number will be
        itemsIndexed(viewModel.pokedexEntryList) { index: Int, item: PokedexEntry ->
            if(index == viewModel.pokedexEntryList.count()) {
                viewModel.loadPokedexEntries()
            }
            PokedexEntryRow(pokemonName = item.name)
        }
    }
}

@Composable
fun PokedexEntryRow(pokemonName: String) {
    Row() {
        Text(text = pokemonName)
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewPokedexHomeScreen() {
    val repo = object : Repository {
        override suspend fun getPokemonList(
            page: Int,
            pageSize: Int
        ): Response<List<PokedexEntry>> {
            TODO("Not yet implemented")
        }

        override suspend fun getPokemonDetails(name: String): Response<PokedexPokemon> {
            TODO("Not yet implemented")
        }
    }

    PokedexHomeScreen(PokedexHomeViewModel(repository = repo))
}

@Composable
@Preview(showBackground = true)
fun PreviewPokedexEntryRow() {
    PokedexEntryRow(pokemonName = "test")
}