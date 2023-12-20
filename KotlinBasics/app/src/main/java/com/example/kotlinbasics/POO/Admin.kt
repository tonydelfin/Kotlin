package com.example.kotlinbasics.POO

class Admin( primerNombre:String,  segundoNombre:String,val numOficcina: Short): Persona(primerNombre, segundoNombre) {


    override fun getTrabajo(): String {
        return "Agendando... ${super.getTrabajo() + "en la officina numero: $numOficcina"} "
    }
}