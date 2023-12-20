package com.example.kotlinbasics.POO

class Amigo( nombre: String,  apellido: String,  numControl: String, var numAmigos:Short) : Alumno(nombre, apellido, numControl){

    override fun toString(): String {
        return "Hola soy $nombre mi numero de control es $numControl"
    }

    fun getCantidadAmigos(): String = "Mis amigos son un total de $numAmigos"
}