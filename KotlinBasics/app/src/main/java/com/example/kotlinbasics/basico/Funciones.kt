package com.example.kotlinbasics.basico

/**
 * Las funciones son metodo que se pueden implemtar porpartes hacendo nuestro codigo modular
 * aquellas funciones que resiban daso se les conoce como parametros o arguemntos
 * return es una palabra reservada la cual devuelve el valor final de nuestra fucnion
 * -----------------------------------------------------------------------------------------
 * SobreCarga
 * Se refeire a utlizar la misma fucion pero con diferentes tipos de datos o parametros
 */
fun main(){
    println("Hola Soy la funcion principal")
    var name: String = "Jorge"
    var edad: Byte = 22
    var job: String ="Developer"

    basic()
    FunconArgumentos(name)
    println(returnData())
    overload(edad)
    overload(job)
    overload(name,job, edad = 20)

}


fun overload(name: String, job: String, edad: Byte) {
    println("Hola me llamo $name, mi trabajo es: $job y tengo $edad años")
}

fun overload(job: String) {
    println("Mi trabajo es: $job")
}

fun overload(edad: Byte) {
    println("Mi edad es de: ${edad} años")
}

fun returnData(): String {
    return "Datos retornados"
}

fun FunconArgumentos(name: String) {
    println("Hola: $name")
}

fun basic(){
    println("Hola Soy la funcion basica creada")
}
