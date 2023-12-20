package com.example.kotlinbasics.POO

open class Persona(val primerNombre:String, private val segundoNombre:String) {
    var tax:Float= 10.0f
        get() = 1- (field*0.01f)

    var salario: Float= 0f
        set(value){
            field = value

        }
        get() = field * tax
    fun getNombreCompleto():String = "$primerNombre $segundoNombre"

    open fun getTrabajo(): String{
        return "Cargando datos..."
    }



}