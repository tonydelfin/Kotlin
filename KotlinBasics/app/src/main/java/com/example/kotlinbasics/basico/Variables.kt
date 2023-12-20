package com.example.kotlinbasics.basico

//variable global
var username: String = "JADS"

//variable constante global
const val Juego: String = "Call of Duty"

fun main(){
    /**
    Variables
    estructura basicas:
    var: palabra reservada, el valor que almacene puede ser modificado con el tiempo
    nombre de la variable
    =
    valor de la variable
     ejemplo:
     var edad = 21;
     edad =22 <- reasigancion del valor

     ------------------------------------------------------------------------------------------------
     val: palabra reservada, el valor que almacene no puede ser modificado
     Nombre de la variable
     =
     valor

     ejemplo:
     val edad = 20
     edad = 21 <-- X marcaria error en tiempo de compilacion
     **/


    var age = 22;
    println(age)

    age = 23;
    println("Cambio de edad " + age)

    val name = "Jorge"
    //name ="Antonio"
    println(name)

    /**
     *Formas de declarar
     * Kotlin es un lenguaje tipado asiq ue se nececita especificar el tipo de dato de las varibales
     * Si se desae declar una variable sin inicializar se puede hacer solo espesificando el tipo de dato que es
     * ejemplo:
     * var nombre: String
     * nombre = "Jorge"
     *
     * Esto es usado con cualquier tipo de dato, String, Int, Boleano, Etc
     *
     */

    val job:String
    job ="Developer"

    println(job)

    var edad: Int
    edad = 21

    //String Templates ${}
    println("Mi trabajo es $job y tengo $edad años")

    /**
     * Variable Global
     * Es aquella que podemos usar dentro o fuera de cualquier metodo
     *
     * Variable Constate
     * Se declara como global, ademas de ser val, ya que su valor no puede ser cambiado
     *
     * ---------------------------------------------------------------------------------------------
     *
     * ¿Cuando usar una o otra?
     * Si se sabe el valor que tendra una variable y no va a cambiar con el tiempo se usa const val
     * Si se sabe que el valor no va a cambiar, pero aun no se sabe que valor sere se usa val
     * Si se sabe que el valor de la variable va a cambiar con el tiempo se usa var
     */

    println(username) //<- Variable global ya que esta afuera del metodo main
    println(Juego)//<- Variable global constatnte
}