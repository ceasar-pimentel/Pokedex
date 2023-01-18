package com.example.pokedex.ui

import androidx.lifecycle.ViewModel
import com.example.pokedex.data.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokedexDetailsViewModel @Inject constructor(private val repository: Repository)  : ViewModel() {
}