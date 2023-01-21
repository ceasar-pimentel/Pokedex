package com.example.pokedex.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.data.Repository
import com.example.pokedex.data.database.models.PokedexEntry
import com.example.pokedex.data.network.responses.Pokemon
import com.example.pokedex.util.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class PokedexHomeViewModel @Inject constructor(private val repository: Repository): ViewModel() {

    private var currentPage: Int = 0
    private val pageSize: Int = 10

    var pokedexEntryList = mutableStateOf<List<PokedexEntry>>(listOf())

    init {
        Timber.d("PokedexHomeViewModel created")
        loadPokedexEntries()
    }

    fun loadPokedexEntries() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                when (val response: Response<List<PokedexEntry>> =
                    repository.getPokemonList(currentPage, pageSize)) {
                    is Response.Success -> {
                        response.data?.let { data ->
                            Timber.d("loading this amount${data.count()} curr page $currentPage")
                            withContext(Dispatchers.Main) {
                                pokedexEntryList.value = pokedexEntryList.value + data
                            }
                            currentPage++
                        }
                    }
                    is Response.Error -> {
                        Timber.d(response.message)
                    }
                }
            }
        }
    }
}