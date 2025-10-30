package com.example.huertohogar.data

data class Usuario(
    val nombre: String = "",
    val email: String = "",
    val rut: String = "",
    val terminosAceptados: Boolean = false
)