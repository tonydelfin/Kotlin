package com.example.kotlinbasics.POO

open class Alumno(val nombre: String, val apellido: String, val numControl: String) {

    private var diaFalta: Dias = Dias.JUEVES

    constructor():this("Jorge","Delfin Santos", "19010381")

    override fun toString(): String {
        return " El alumno: ${this.nombre} tiene el numero de control: $numControl"
    }

    fun getNombreCompleto(): String = "$nombre $apellido"

    fun setDiaFaltado(diaFaltado: Dias){
        this.diaFalta = diaFaltado
    }
    fun getDiaFaltado():String = diaFalta.dia
}