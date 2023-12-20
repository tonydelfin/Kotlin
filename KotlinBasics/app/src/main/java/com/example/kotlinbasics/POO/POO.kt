package com.example.kotlinbasics.POO

import android.print.PrinterInfo
import com.example.kotlinbasics.basico.imprimirSubTema
import com.example.kotlinbasics.basico.imprimirTitulo

fun main(){
    imprimirTitulo("POO")
    imprimirSubTema("Clase (class)")

    /**
     * Se instancia la clase; es como dar vida a la clase para ello lleva los parentecis
     */
    println(Escuela())

    imprimirSubTema("Constructor")
    val escuela = Escuela("ITSZN2", "Calle Gonazales2")
    println(escuela)

    imprimirSubTema("Overiide")
    val escuelaInactiva = Escuela("ITSZN", "Calle Gonazales",false, "0001")
    println(escuelaInactiva)

    imprimirSubTema("This (.this)")
    /**
     * Hace referencia a las variables de la clase
     */
    val secundaria = Escuela("Secundaria", "La almoloya", mutableListOf(Persona("Jorge","Antonio")) )
    println(secundaria)

    imprimirSubTema("Metodos y Propiedades")
    /**
     * Hace referencia a descripciones de mi objeto y acciones que puede realizar
     */
    val persona: Persona = Persona("Jorge", "Antonio")
    println(persona.getNombreCompleto())
    println(persona.getTrabajo())
    persona.salario =1000.0f
    println(persona.salario)

    imprimirSubTema("Set y Get")
    /**
     * Sirven para definir el valor y obtenerlo de una manera mas personalizada
     */
    persona.tax = 20f
    println(persona.salario)

    imprimirSubTema("Herencia (open)")
    val profesor: Profesor = Profesor("Jorge", "Delfin", 23)
    secundaria.personal.add(profesor)
    val admin: Admin= Admin("Victor","Manuel", 1)
    secundaria.personal.add(admin)
    println(secundaria)

    imprimirSubTema("Super")
    /**
     * Se usa para adquirir los metodos y propiedades del padre
     */
    println("La ocupacion de ${profesor.primerNombre} es ${profesor.getTrabajo()} ")
    println("La ocupacion de ${admin.primerNombre} es ${admin.getTrabajo()} ")

    imprimirSubTema("Encapsulamiento")
    println(profesor.primerNombre)
    //println(profesor.segundoNombre)

    imprimirSubTema("Companion Obeject")
    /**
     * Se usa para usar veriables globales donde sabes su valor en tiempo de compilacion
     */
    println(Escuela.ACTIVA)
    val escuelaActiva= Escuela("Oxford","Manuel avila", Escuela.ACTIVA )
    println(escuelaActiva)

    imprimirSubTema("ENUM")
    /**
     * Se usa cuando sabemos la lista de datos que no van a cabira, por ejemplo dias dela semana, planetas del sistema solar etc
     */
    escuelaActiva.setTipo(tipoEscuela.PRIVADA)
    println(escuelaActiva.getTipo())

    imprimirSubTema("Clases anidadas")
    println(profesor.salon)
    profesor.salon.Key ="4°A"
    println(profesor.salon)

    imprimirSubTema("Inner class")
    /**
     * Es una clase anidada, pero hereda las porpiedades de la  clase padre
     */
    println(profesor.salon.getInfo())

    imprimirSubTema("Interface")
    /**
     *Una interfaz se utiliza para sobreescribir los metodos que se queiren itilizar de una manera mas sencilla,
     * y solo prodran ser utilizados por la clase en la que se instancia la interface
     */
    profesor.salario = 1000f
    val booss:Jefe = profesor
    println("Profesor: ${booss.nombredelPerosnal()} tiene un salario neto de: ${booss.salarioNeto()}")

    imprimirSubTema("Data Class")
    /**
     * Muestro los datos de la clase de una menera mas generica, sin constructor muestra los datos no la referencia de la clase
     *
     */
    println(escuelaActiva)
    println(escuelaActiva.component1())
    val escuelaCopiada = escuelaActiva.copy()
    escuelaCopiada.clave= ""
    println(escuelaCopiada)

    imprimirSubTema("Equal & hashCode")
    /**
     * Aplica metodos para comparar que un objeto es igual a otro objeto
     */
    println(escuelaActiva.equals(escuelaCopiada))

    imprimirSubTema("Tarea POO")
    val alumno:Alumno = Alumno()
    println(alumno)
    println(alumno.getNombreCompleto())
    alumno.setDiaFaltado(Dias.LUNES)
    println("El alumno falto el dia ${alumno.getDiaFaltado()}")
    val amigo: Amigo = Amigo("Pedro", "Perez", "09010481", 5)
    println(amigo)
    println(amigo.getCantidadAmigos())
    amigo.setDiaFaltado(Dias.MARTES)
    println("El amigo falto el dia ${amigo.getDiaFaltado()}")


}