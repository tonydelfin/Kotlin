package com.example.kotlinbasics.POO

/**
 * Una calse puede tener metodos y atributos
 */

/**
 * Constructor, es la forma en que inicializamos las variables de nuestro objeto
 * y exigimos que se tomen en cuenta o se inicialicen con algun valor por defecto
 *
 * Se puede tener mas de uno
 */
data class Escuela (var nombre: String, var direccion: String, val activa:Boolean = true, var clave: String =""){

    var personal : MutableList<Persona>
    private var tipoEscuala:tipoEscuela = tipoEscuela.PUBLICA

    init {
        personal = mutableListOf()
    }

    constructor():this("","")

    constructor(nombre: String, direccion: String, personal:MutableList<Persona>): this(nombre,direccion){
        this.personal = personal
    }



    /*fun hola(){
        println("Hola POO")
    }

     */

    /**
     * Overrride sirve para sobreescribir funciones o metodos que ya estaban definidos

    override fun toString(): String {
        if (activa){
            return if (personal.size > 0){
                 "Nombre: $nombre, dirección: $direccion, clave: $clave, con ${personal.size} miembros"
            }
            else{
                 "Nombre: $nombre, dirección: $direccion, clave: $clave"
            }

        }else{
            return "Escuela inactiva"
        }

    }
    */
    fun setTipo(tipoEscu: tipoEscuela) {
        this.tipoEscuala = tipoEscu

    }
    fun getTipo():String = tipoEscuala.tipo

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Escuela

        if (clave != other.clave) return false

        return true
    }

    override fun hashCode(): Int {
        return clave.hashCode()
    }


    companion object{
        const val ACTIVA= true
        const val INACTIVA = false
    }
}