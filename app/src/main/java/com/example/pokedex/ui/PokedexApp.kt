package com.example.pokedex.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun PokedexApp(modifier: Modifier = Modifier) {
    Scaffold() { padding ->
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            modifier = modifier.padding(padding),
            startDestination = PokedexRoutes.HomeScreen.name
        ) {
            composable(route = PokedexRoutes.HomeScreen.name) {
                PokedexHomeScreen()
            }
            composable(route = PokedexRoutes.DetailsScreen.name) {
                PokedexDetailsScreen()
            }
        }

    }
}