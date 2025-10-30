package com.example.huertohogar.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.huertohogar.ui.CampoDeTextoValidable
import com.example.huertohogar.viewmodel.UsuarioViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistroScreen(
    navController: NavController,
    usuarioViewModel: UsuarioViewModel
) {
    val usuarioState = usuarioViewModel.usuario

    Scaffold(
        topBar = { TopAppBar(title = { Text("Formulario de Registro") }) }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp, vertical = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            CampoDeTextoValidable(
                valor = usuarioState.nombre,
                etiqueta = "Nombre Completo",
                placeholder = "Ingresa tu nombre",
                enValorCambiado = usuarioViewModel::onNombreChanged,
                tieneError = usuarioViewModel.nombreError,
                mensajeError = "El nombre debe tener al menos 3 caracteres."
            )

            CampoDeTextoValidable(
                valor = usuarioState.email,
                etiqueta = "Correo Electrónico",
                placeholder = "ejemplo@dominio.cl",
                enValorCambiado = usuarioViewModel::onEmailChanged,
                tieneError = usuarioViewModel.emailError,
                mensajeError = "Ingresa un formato de correo válido.",
                opcionesTeclado = KeyboardOptions(keyboardType = KeyboardType.Email)
            )

            CampoDeTextoValidable(
                valor = usuarioState.rut,
                etiqueta = "RUT (sin puntos ni guiones)",
                placeholder = "Ej: 112223334",
                enValorCambiado = usuarioViewModel::onRutChanged,
                tieneError = usuarioViewModel.rutError,
                mensajeError = "Ingresa un RUT válido (mín. 8 dígitos).",
                opcionesTeclado = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = usuarioState.terminosAceptados,
                    onCheckedChange = usuarioViewModel::onTerminosChanged
                )
                Text(text = "Acepto los términos y condiciones")
            }

            // Muestra error de Términos
            if (usuarioViewModel.terminosError) {
                Text(
                    text = "Debes aceptar los términos y condiciones.",
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.align(Alignment.Start)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = {
                    if (usuarioViewModel.validarCampos()) {
                        navController.navigate("resumen")
                    }
                },
                modifier = Modifier.fillMaxWidth().height(50.dp)
            ) {
                Text("Registrar", style = MaterialTheme.typography.titleMedium)
            }
        }
    }
}