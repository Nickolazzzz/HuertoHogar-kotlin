package com.example.huertohogar.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.huertohogar.R
import com.example.huertohogar.ui.theme.HuertoHogarTheme // O el nombre de tu tema

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenExpandida() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Huerto Hogar - Vista Expandida") })
        }
    ) { innerPadding ->
        Row(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(32.dp),

            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(0.5f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo_huerto_hogar),
                    contentDescription = "Logo Huerto Hogar Expandido",
                    modifier = Modifier
                        .size(250.dp),
                    contentScale = ContentScale.Fit
                )
            }

            Column(
                modifier = Modifier
                    .weight(0.5f)
                    .padding(start = 24.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "¡Bienvenido a tu Jardín Digital!",
                    style = MaterialTheme.typography.headlineLarge,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "En la vista Expandida, puedes ver el catálogo y tus tareas lado a lado. ¡A cultivar!",
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.height(24.dp))
                Button(onClick = { /* Acción para ir al catálogo */ }) {
                    Text(text = "Explorar Catálogo")
                }
            }
        }
    }
}

@Preview(name = "Expanded Preview", widthDp = 840, heightDp = 1200, showBackground = true)
@Composable
fun HomeScreenExpandidaPreview() {
    HuertoHogarTheme {
        HomeScreenExpandida()
    }
}