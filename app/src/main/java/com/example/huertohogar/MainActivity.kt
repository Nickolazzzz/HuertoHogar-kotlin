package com.example.huertohogar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
// Importación crucial para calcular el tamaño de la ventana
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.ui.Modifier
import com.example.huertohogar.navigation.AppNavigation
import com.example.huertohogar.ui.theme.HuertoHogarTheme

class MainActivity : ComponentActivity() {

    // Anotación necesaria para usar calculateWindowSizeClass
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // 1. Calcular el WindowSizeClass aquí en la Activity
            val windowSizeClass = calculateWindowSizeClass(this)

            HuertoHogarTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // 2. Pasar el windowSizeClass a tu componente de navegación o pantalla principal
                    AppNavigation(windowSizeClass = windowSizeClass)
                }
            }
        }
    }
}
