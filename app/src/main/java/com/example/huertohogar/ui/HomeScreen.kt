package com.example.huertohogar.ui

import androidx.compose.runtime.Composable
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text


import com.example.huertohogar.ui.screens.HomeScreenCompacta
import com.example.huertohogar.ui.screens.HomeScreenMediana
import com.example.huertohogar.ui.screens.HomeScreenExpandida


@Composable
fun HomeScreen(
    windowSizeClass: WindowSizeClass,
    modifier: Modifier = Modifier
) {
    // Usamos el ancho para determinar el layout de la pantalla
    when (windowSizeClass.widthSizeClass) {
        // Pantalla Compacta (Típicamente, teléfonos en modo vertical)
        WindowWidthSizeClass.Compact -> {
            HomeScreenCompacta(modifier = modifier)
        }
        // Pantalla Mediana (Típicamente, tablets en modo vertical)
        WindowWidthSizeClass.Medium -> {
            HomeScreenMediana(modifier = modifier)
        }
        // Pantalla Expandida (Típicamente, tablets en modo horizontal o pantallas grandes)
        WindowWidthSizeClass.Expanded -> {
            HomeScreenExpandida(modifier = modifier)
        }
        // Caso por defecto
        else -> {
            // Fallback en caso de que no se pueda determinar el tamaño
            HomeScreenCompacta(modifier = modifier)
        }
    }
}


@Composable
fun HomeScreenCompacta(modifier: Modifier = Modifier) {
    Text(text = "Versión Compacta", modifier = modifier.fillMaxSize())
}

@Composable
fun HomeScreenMediana(modifier: Modifier = Modifier) {
    Text(text = "Versión Mediana", modifier = modifier.fillMaxSize())
}

@Composable
fun HomeScreenExpandida(modifier: Modifier = Modifier) {
    Text(text = "Versión Expandida", modifier = modifier.fillMaxSize())
}
