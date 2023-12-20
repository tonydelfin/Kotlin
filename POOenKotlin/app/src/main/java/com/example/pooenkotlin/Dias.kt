package com.example.pooenkotlin

enum class Dias(val laboral: Boolean, val jornada: Int) {
    LUNES(true, 8),
    MARTES(true, 8),
    MIERCOLES(true, 5),
    JUEVES(true, 5),
    VIERNES(true, 4),
    SABADO(false, 0),
    DOMINGO(false, 0);

    fun saludo(): String {
        when (this) {
            LUNES -> return "Hoy es lunes"
            MARTES -> return "Hoy es lunes"
            MIERCOLES -> return "Hoy es lunes"
            JUEVES -> return "Hoy es lunes"
            VIERNES -> return "Hoy es lunes"
            SABADO -> return "Hoy es lunes"
            DOMINGO -> return "Hoy es lunes"
            else -> return "SABE QUE SEA HOY"
        }
    }

}