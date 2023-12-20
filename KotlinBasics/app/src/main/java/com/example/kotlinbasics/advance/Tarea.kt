package com.example.kotlinbasics.advance

import com.example.kotlinbasics.basico.imprimirSubTema
import java.lang.NumberFormatException

fun main(){
    //Tarea
    imprimirSubTema("Tarea Kotlin Advance")

    var num: Any?
    num = 5.0
    safeTask(num)

    num = null
    safeTask(num)

    num = "J"
    safeTask(num)
}

fun safeTask(num: Any?) {
    try {
        println("num: ${num.toString().toDouble()}")
    }catch (e:NumberFormatException){
        println(e)
    }
}


