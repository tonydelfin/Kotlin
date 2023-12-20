package com.example.pooenkotlin

//Esto es una clase de datos solo almacena atributos de algun objeto
data class Star(
    val name: String = "",
    val radius: Float = 0.0f,
    var galaxy: String =""
){
    val alive = true;
}
