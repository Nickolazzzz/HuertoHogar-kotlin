package com.example.huertohogar.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.huertohogar.viewmodel.UsuarioViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResumenScreen(
    usuarioViewModel: UsuarioViewModel
) {
    val usuario = usuarioViewModel.usuario

    Scaffold(
        topBar = { TopAppBar(title = { Text("Resumen del Registro") }) }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(text = "¡Registro Exitoso!", style = MaterialTheme.typography.headlineMedium)
            Divider(modifier = Modifier.padding(vertical = 8.dp))

            Text(text = "Nombre: ${usuario.nombre}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Email: ${usuario.email}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "RUT: ${usuario.rut}", style = MaterialTheme.typography.bodyLarge)
            Text(
                text = "Términos: ${if (usuario.terminosAceptados) "Aceptados" else "Declinados"}",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}