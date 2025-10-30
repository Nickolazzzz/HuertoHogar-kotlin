package com.example.huertohogar.ui

import androidx.compose.material3.adaptive.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import com.example.huertohogar.ui.utils.obtenerWindowSizeClass

import com.example.huertohogar.ui.screens.HomeScreenCompacta
import com.example.huertohogar.ui.screens.HomeScreenMediana
import com.example.huertohogar.ui.screens.HomeScreenExpandida

@Composable
fun HomeScreen(){

    val windowSizeClass = obtenerWindowSizeClass()

    when (windowSizeClass.widthSizeClass) {
        WindowWidthSizeClass.Compact -> HomeScreenCompacta()
        WindowWidthSizeClass.Medium -> HomeScreenMediana()
        WindowWidthSizeClass.Expanded -> HomeScreenExpandida()
    }
}
// Elimina todo lo que sea Scaffold, Column, Button, Image de este archivo.