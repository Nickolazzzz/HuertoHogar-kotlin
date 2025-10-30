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
import com.example.huertohogar.ui.theme.HuertoHogarTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenMediana() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Huerto Hogar - Vista Mediana") })
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(32.dp),
            verticalArrangement = Arrangement.spacedBy(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "¡Gestión optimizada para tu Huerto!",
                style = MaterialTheme.typography.headlineMedium
            )
            Image(
                painter = painterResource(id = R.drawable.logo_huerto_hogar),
                contentDescription = "Logo App Mediana",
                modifier = Modifier
                    .size(300.dp), // Logo más grande
                contentScale = ContentScale.Fit
            )
            Button(
                onClick = {},
                modifier = Modifier.fillMaxWidth(0.6f)
            ) {
                Text("Ir a Tareas Pendientes")
            }
        }
    }
}

@Preview(name = "Medium Preview", widthDp = 600, heightDp = 1000, showBackground = true)
@Composable
fun HomeScreenMedianaPreview() {
    HuertoHogarTheme {
        HomeScreenMediana()
    }
}