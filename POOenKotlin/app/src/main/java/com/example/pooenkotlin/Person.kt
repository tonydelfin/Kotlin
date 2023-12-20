package com.example.pooenkotlin

//formas de un constructor

//simple sin metodo
 open class Person(var name: String? = "Antonio", var passport: String? = null) {
 //open class me permite modificar el acceso, ya que estoy diciendo que esta clase no sera la final, tendra clases hijas

    //Constructor con un metodo
    fun Person(){
        name= "Juan"
        passport = "ASDASD"
    }
    var alive: Boolean = true

    fun die(){
        alive = false;
    }

    class Athlete(name: String?, passport: String?, var sport: String): Person(name, passport)
}