package com.example.huertohogar.navigation

import androidx.compose.runtime.Composable
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.huertohogar.ui.HomeScreen

/**
 * Define las rutas de navegación de la aplicación.
 *
 * @param windowSizeClass La clase de tamaño de ventana para la adaptabilidad de la UI.
 */
@Composable
fun AppNavigation(windowSizeClass: WindowSizeClass) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            // Inyectamos el windowSizeClass en la pantalla
            HomeScreen(windowSizeClass = windowSizeClass)
        }
        // Aquí puedes añadir más composables de navegación (formulario, resumen, etc.)
    }
}
