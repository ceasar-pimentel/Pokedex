package com.example.pokedex.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun PokedexHomeScreen() {
    Column() {
        Text(text = "What Pokemon are you looking for")
    }
}

@Composable
fun PreviewPokedexHomeScreen() {
    PokedexHomeScreen()
}