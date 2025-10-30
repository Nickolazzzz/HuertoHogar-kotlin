package com.example.huertohogar.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

// --- 1. Tema de Color Claro (Usa los valores de Color.kt) ---
private val LightColorScheme = lightColorScheme(
    primary = PrimaryGreen, // Verde principal (0xFF388E3C)
    onPrimary = OnPrimary, // Texto blanco
    secondary = SecondaryGreen, // Verde secundario (0xFF66BB6A)
    onSecondary = OnSecondary, // Texto negro
    background = BackgroundBeige, // Fondo beige claro (0xFFFFFBE6)
    surface = SurfaceLight, // Superficie blanca (0xFFFFFFFF)
    onSurface = OnSurfaceLight, // Texto principal oscuro
    error = Color(0xFFB00020),
    onError = Color.White
)

// --- 2. Tema de Color Oscuro (Usa los valores de Color.kt) ---
private val DarkColorScheme = darkColorScheme(
    primary = DarkPrimary, // Verde claro (0xFFA5D6A7)
    onPrimary = DarkSurface,
    secondary = SecondaryGreen,
    onSecondary = OnSecondary,
    background = DarkBackground, // Fondo muy oscuro (0xFF0D1213)
    surface = DarkSurface, // Superficies oscuras (0xFF1D2627)
    onSurface = DarkOnSurface, // Texto principal blanco
    error = Color(0xFFCF6679),
    onError = Color.Black
)

@Composable
fun HuertoHogarTheme(
    // Determina si el sistema está en modo oscuro
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Desactivamos Dynamic Color para usar SIEMPRE nuestra paleta personalizada
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    // Selecciona el esquema de color apropiado
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    // 3. Configuración de la Barra de Estado del Sistema
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            // Establece el color de la barra de estado
            window.statusBarColor = colorScheme.surface.toArgb()
            // Controla si los íconos de la barra de estado deben ser oscuros o claros
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    // 4. Aplicación del Tema
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography, // Asume que Type.kt ya está definido e importado
        content = content
    )
}