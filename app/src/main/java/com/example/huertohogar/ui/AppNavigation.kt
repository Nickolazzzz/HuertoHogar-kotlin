package com.example.huertohogar.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel

import com.example.huertohogar.ui.screens.RegistroScreen
import com.example.huertohogar.ui.screens.ResumenScreen
import com.example.huertohogar.viewmodel.UsuarioViewModel

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    val usuarioViewModel: UsuarioViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = "registro"
    ) {
        composable(route = "registro") {
            RegistroScreen(navController, usuarioViewModel)
        }

        composable(route = "resumen") {
            ResumenScreen(usuarioViewModel)
        }
    }
}