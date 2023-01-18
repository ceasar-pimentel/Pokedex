package com.example.pokedex.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pokedex.data.RepositoryImpl

@Composable
fun PokedexHomeScreen(viewModel: PokedexHomeViewModel = hiltViewModel()) {
    Column() {
        Text(text = "What Pokemon are you looking for")
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewPokedexHomeScreen() {
    PokedexHomeScreen()
}