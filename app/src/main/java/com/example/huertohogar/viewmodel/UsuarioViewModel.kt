package com.example.huertohogar.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.huertohogar.data.Usuario
import java.util.regex.Pattern

class UsuarioViewModel : ViewModel() {

    var usuario by mutableStateOf(Usuario())
        private set

    var nombreError by mutableStateOf(false)
        private set
    var emailError by mutableStateOf(false)
        private set
    var rutError by mutableStateOf(false)
        private set
    var terminosError by mutableStateOf(false)
        private set

    private val emailRegex = Pattern.compile(
        "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$"
    )

    fun onNombreChanged(nuevoNombre: String) {
        usuario = usuario.copy(nombre = nuevoNombre)
        nombreError = false
    }

    fun onEmailChanged(nuevoEmail: String) {
        usuario = usuario.copy(email = nuevoEmail)
        emailError = false
    }

    fun onRutChanged(nuevoRut: String) {
        usuario = usuario.copy(rut = nuevoRut.replace(".", "").replace("-", ""))
        rutError = false
    }

    fun onTerminosChanged(aceptado: Boolean) {
        usuario = usuario.copy(terminosAceptados = aceptado)
        terminosError = false
    }

    fun validarCampos(): Boolean {
        nombreError = usuario.nombre.length < 3

        emailError = !emailRegex.matcher(usuario.email).matches()

        rutError = usuario.rut.length < 8

        terminosError = !usuario.terminosAceptados

        return !nombreError && !emailError && !rutError && !terminosError
    }
}