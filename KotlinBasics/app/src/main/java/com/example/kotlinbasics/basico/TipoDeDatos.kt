package com.example.kotlinbasics.basico

fun main(){

    /**
     * Char
     * Los chars es similar al String ya que almacena caracteres y el string es una cadena de caracteres
     * PARA ESTO SE UTLIZAN COMILLAS SIMPLES ('')
     */
    var char: Char = 'J'
    var char2: Char = 'A'
    print(char)
    print(char2)
    println()

    /**
     * String
     * es una cadena de caracteres
     * Para eso usamos comillas ("")
     */
    var palabra: String = "JA"
    println(palabra)

    /**
     * Boolean
     * Los boleanos son un tipo de dato que solo puede tener dos valores 0 o 1, true o false
     * True = 1
     * False = 0
     */

    var mayor: Boolean = false
    println(mayor)

    /**
     * Valores numericos
     * Nota: Solo para los floats se coloco una f al final de los digitos numericos
     *
     * cada uno tiene un rango de tamaño dependiendo los bits, este puede almacenar cantidades mas grandes
     */

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
}