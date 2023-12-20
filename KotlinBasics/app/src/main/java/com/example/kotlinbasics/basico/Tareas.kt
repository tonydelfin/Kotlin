package com.example.kotlinbasics.basico

//variable global
var username2: String = "JADS"

//variable constante global
const val Juego2: String = "Call of Duty"

const val SEPARADOR: String = "------------------------------"
const val SEPARDAR2: String = "--------"

fun main(){

    imprimirTitulo(titulo = "Tipos de Variables")
    //Tutulo de Variables
    var age = 22;
    println(age)

    age = 23;
    println("Cambio de edad " + age)

    val name = "Jorge"
    //name ="Antonio"
    println(name)

    val job:String
    job ="Developer"
    println(job)

    var edad: Byte
    edad = 21

    imprimirTitulo(titulo = "Template String")
    //Titulo de String templates
    //String Templates ${}
    println("Mi trabajo es $job y tengo $edad años")

    println(username2) //<- Variable global ya que esta afuera del metodo main
    println(Juego2)//<- Variable global constatnte

    imprimirTitulo(titulo = "Tipos de Datos")
    //Titulo de Ti´pos de datos
    var char: Char = 'J'
    var char2: Char = 'A'
    print(char)
    print(char2)
    println()

    var palabra: String = "JA"
    println(palabra)


    var mayor: Boolean = false
    println(mayor)



    //8 bits - 128 a 127
    val jobs: Byte =3
    println("$jobs Trabajos")

    // 16 bits
    val diasTrabajados: Short = 200
    println("$diasTrabajados dias trabajados")

    //32 bits
    val minutosTrabajados: Int = 288000
    println("$minutosTrabajados minutos trabajados")

    // 64 bits
    val segundoTrabajados: Long = 1728000000
    println("$segundoTrabajados segundos tarabajados")

    // 32 bits
    val altura: Float = 1.56f
    println("Atura: $altura")

    //64 bits
    val alturaDouble: Double = 1.56444444444444444
    println("Altura real: $alturaDouble")

    imprimirTitulo(titulo = "Uso de funciones")
    basic()
    FunconArgumentos(name)
    println(returnData())
    overload(edad)
    overload(job)
    overload(name,job, edad = 20)
}
fun imprimirTitulo(titulo: String){
    //println("------------------------------ $titulo ------------------------------")
    print("\n$SEPARADOR $titulo $SEPARADOR\n")

}
fun imprimirSubTitulo(titulo: String){
    print("\n$SEPARADOR $titulo\n")
}
fun imprimirSubTema(titulo: String){
    print("\n$SEPARDAR2 $titulo $SEPARDAR2\n")
}
