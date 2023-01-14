package com.example.pokedex.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.pokedex.data.Repository
import com.example.pokedex.data.network.responses.Pokemon
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokedexHomeViewModel @Inject constructor(private val repository: Repository): ViewModel() {

}