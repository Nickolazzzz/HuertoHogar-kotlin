package com.example.huertohogar.ui.screens // ¡Asegúrate de que el paquete sea 'ui.screens'!

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.huertohogar.R // Para acceder a tus recursos (imagen)

// Opcional: Si usas otros imports de tu theme, agrégalos aquí también.


@OptIn(ExperimentalMaterial3Api::class)
@Composable
// ¡Nombre de la función cambiado de HomeScreen() a HomeScreenCompacta()!
fun HomeScreenCompacta(){
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Huerto Hogar")})
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Text(text = "¡Bienvenido! a Hueto Hogar")
            Button(onClick = {}) {
                Text("Presioname")
            }
            Image(
                painter = painterResource(id = R.drawable.logo_huerto_hogar), // Usa el nombre de tu imagen
                contentDescription = "Logo App",
                modifier = Modifier
                    .width(250.dp)
                    .wrapContentHeight(),
                contentScale = ContentScale.Fit
            )
        }
    }
}

// Agrega el Preview de la Guía 9 para probar esta vista de forma individual [cite: 268]
@Preview(name = "Compact Preview", widthDp = 360, heightDp = 800)
@Composable
fun HomeScreenCompactaPreview() {
    // Llama a la versión Compacta
    HomeScreenCompacta()
}