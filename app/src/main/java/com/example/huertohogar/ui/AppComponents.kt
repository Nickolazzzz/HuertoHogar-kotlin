package com.example.huertohogar.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun CampoDeTextoValidable(
    valor: String,
    etiqueta: String,
    placeholder: String,
    enValorCambiado: (String) -> Unit,
    tieneError: Boolean,
    mensajeError: String,
    opcionesTeclado: KeyboardOptions = KeyboardOptions.Default,
    transformacionVisual: VisualTransformation = VisualTransformation.None
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        OutlinedTextField(
            value = valor,
            onValueChange = enValorCambiado,
            label = { Text(etiqueta) },
            placeholder = { Text(placeholder) },
            isError = tieneError,
            keyboardOptions = opcionesTeclado,
            visualTransformation = transformacionVisual,
            trailingIcon = {
                if (tieneError) {
                    Icon(
                        imageVector = Icons.Filled.Info,
                        contentDescription = "Error",
                        tint = MaterialTheme.colorScheme.error
                    )
                }
            },
            modifier = Modifier.fillMaxWidth()
        )

        if (tieneError) {
            Text(
                text = mensajeError,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}