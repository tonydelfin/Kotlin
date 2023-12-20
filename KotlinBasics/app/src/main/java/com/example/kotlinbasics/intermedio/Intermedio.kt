package com.example.kotlinbasics.intermedio

import com.example.kotlinbasics.basico.imprimirSubTema
import com.example.kotlinbasics.basico.imprimirSubTitulo
import com.example.kotlinbasics.basico.imprimirTitulo

fun main(){
    /**
     * Una sentecia condicional es donde se evalua para saber si se cumplo o no una condicion
     * en caso de que sea verdad se ejecutara el cuerpo del codigo de laparte verdadera en casp contrario
     * se ejecutara el cuerdo de codigo si no se cumple
     */
    imprimirSubTitulo("Sentecias Condicionales")
    imprimirTitulo("IF-ELSE")
    var edad: Byte = 18
    var a: Byte =11
    var b: Byte =13

    if (edad >= 18){
        println("Es mayor de edad")
    }else{
        println("Es menos de edad")
    }

    if (a < b){
        println("B es mayor")
    }else if (a > b){
        println("A es mayor")
    }else{
        println("Son iguales")
    }



    imprimirSubTitulo("Equality - Equals")
    /**
     * Es un operador lodgico de comparacion entre dos valores
     * solo  que equals es un metodo solo usado para Strings
     */

    val name = "Jorge"
    val name2 = "Jorge"
    if (name.equals("Antonio")){
        println("Es igual")
    }else {
        println("Es diferente")
    }
    if (name ==  name2){
        println("Es igual")
    }
    imprimirSubTitulo("Operadores logicos")
    imprimirSubTema("NOT (!=)")
    if (1 != 2){
        println("1 es diferente de 2")
    }
    imprimirSubTema("OR (||)")
    if (1 == 1 || 1 < 2){
        println("Uno es igual a Uno O Uno es menor a Dos")
    }
    imprimirSubTema("AND (&&)")
    if (1 != 2 && 1 < 2){
        println("Unos es diferente de Dos Y Uno es menor a Dos")
    }
    imprimirSubTema("IF anidados")
    /**
     * Se ocupa cuando hay varias condiciones realcionadas con n problema
     */
    if (1 == 1){
        if (1 < 2){
            println("Paso el if anidado")
        }
    }

    imprimirTitulo("When")
    /**
     * Es usado para remplazar else if anidados, ya que optimiza el codigo y lo hace en menos lineas
     * en java funcionaria como un case
     *
     */

    val nombre: String = "Jorge2"
    when(nombre){
        "Jorge"-> println("Hola Jorge")
        "Antonio"-> println("Hola Antonio")
        "Victor"-> println("Hola Victor")
        "Manuel"-> println("Hola Manuel")
        else -> println("Desconocido")

    }
    imprimirSubTema("Estructura de datos")
    imprimirTitulo("Collecciones")
    imprimirSubTema("Vararg")
    /**
     * Una coleccion son arreglos o vectores que almacenarn varios valores en unsa sola variable
     */
    multiArgumentos("Jorge","Antonio","Victor")

    imprimirSubTema("Array Simple")
    val array = arrayOf('J','O','R','G','E')
    println(array[0])
    println(array.get(1))
    println(array[2])
    println(array[3])
    println(array[4])

    imprimirSubTema("List (Solo Lectura)")
    /**
     * Es una lista enfocada solo en Kotlin se puede declarar toda en una sola linea o si prefieres se declara y
     * luego se le asiganan los valores
     * val listaSoloLectura: List<String>
     * listaSoloLectura = listOf("Jorge", "Antonio", "Delfin", "Santos")
     *
     * Es obligatorio especificar el tipo de dato que almacenara
     */
    val listaSoloLectura: List<String> = listOf("Jorge", "Antonio", "Delfin", "Santos")
    println("Mi lista es: ${listaSoloLectura}")
    println("Nombre el la posicion 0: ${listaSoloLectura.get(0)}")

    imprimirSubTema("List Mutable (Lectura y Escritura)")
    /**
     * Este tipo de lista nos permite obtener mas metodos con los cuales podemor agrega, eliminar, actualizar los
     * datos de la lista
     */
    val listaMutable = mutableListOf<String>("Jorge", "Antonio", "Delfin", "Santos")
    println("Mi lista Mutable: ${listaMutable}")
    //Agregar
    listaMutable.add("Victor")
    println("Mi lista Mutable: ${listaMutable}")
    //Eliminar
    listaMutable.removeAt(0)
    println("Mi lista Mutable: ${listaMutable}")
    listaMutable.remove("Delfin")
    println("Mi lista Mutable: ${listaMutable}")
    //Actualizar
    listaMutable.set(0,"Dulce")
    println("Mi lista Mutable: ${listaMutable}")


    imprimirSubTema("Map o Diccionarios")
    /**
     * Este tipo de coleccion se tiene que espesificar dos cosas, la clave y el valor,
     * pueden ser del mismo tipo ambos o diferentes
     *
     * Tambien hay mapa de solo lectura
     */
    val MapaMutable=  mutableMapOf<Byte, String>()
    MapaMutable.put(1,"Jorge")
    MapaMutable.put(2,"Antonio")
    MapaMutable.put(3,"Delfin")
    println("Mi mapa mutable: ${MapaMutable}")

    //Obtener por la llave o Key
    println("Get by Key: ${MapaMutable.get(1)}")

    //Eliminar
    MapaMutable.remove(3)
    println("Mi mapa mutable: ${MapaMutable}")

    //Actualizar
    MapaMutable.set(1,"George")
    println("Mi mapa mutable: ${MapaMutable}")

    //imprimir las llaver
    println("Mis LLaves del mapa mutable: ${MapaMutable.keys}")

    //Imprimir mis valores
    println("Mis valores del mapa mutable: ${MapaMutable.values}")

    imprimirSubTema("Array of null")
    /**
     * Se usa cuando conocemos el tamaño del array pero no los valores
     * las psociciones del arreglo que no esten acupadas se manejaran como null
     */
    val arrayNulo=  arrayOfNulls<String>(3)
    arrayNulo[0]=  "Jorge"
    println("Array nulo en 0: ${arrayNulo[0]}")
    println("Array nulo en 1: ${arrayNulo[1]}")
    println("Array nulo en 2: ${arrayNulo[2]}")

    imprimirSubTitulo("Metodos en las colecciones")
    imprimirSubTema("Ordenar (Sort)")
    println("Sort: ${listaSoloLectura.sorted()}")

    imprimirSubTema("Revertir (Reversed)")
    println("Reversed: ${listaSoloLectura.reversed()}")

    imprimirSubTema("Buscar Indice (Indexof)")
    println("Indice de Jorge: ${listaSoloLectura.indexOf("Jorge")}")

    imprimirSubTitulo("Bucles")
    imprimirSubTema("For")

    /**
     * El bucle for es el mas comun iterando paso a paso
     */
    bucleFor("Jorge", "Antonio", "Delfin", "Santos")

    imprimirSubTema("ForEach")
    bucleForEach("Jorge", "Antonio", "Delfin", "Santos")


    val MapaMutableTarea=  mutableMapOf<Byte, String>()
    MapaMutable.put(1,"Jorge")
    MapaMutable.put(2,"Antonio")
    MapaMutable.put(3,"Delfin")
    if (MapaMutable.values.contains("Jorge")){
        println("Aqui esta Jorge")
    }else{
        println("No se encontro")
    }


}

fun bucleFor(vararg names:String) {
    //for imprimendo los numero del 1-10
    for (i in 0..10 step 2){
        println(i)
    }
    for (i in 0..names.size -1){
        println("$i = ${names.get(i)}")
    }
    for (i in names){
        println(i)
    }
}
fun bucleForEach(vararg names:String){
    names.forEach { name-> println(name) }
    (1..10).forEach { num -> println(num) }

    imprimirSubTema("While")
    var contador = 0
    while (contador < names.size){
        println("Contador: $contador")
        println("Nombre en contador: ${names.get(contador)}")
        contador ++

    }
    imprimirSubTema("Do While")
    do {
        contador--
        println("contador: $contador")
        println("Nombre en el contador: ${names.get(contador)}")
    }while (contador>0)

    imprimirSubTema("Return")
    /**
     * Estapalabra reservada deteien el proceso del codigo sacandonos del metodo prncipal evitado la ejecucion del codigo
     * que este despues de este
     */
    (1..10).forEach {
        if (it == 3){
            return@forEach
        }
        println(it)
    }
    imprimirSubTema("Break")
    /**
     * Break es lo lo mismo que el return solo que este te saca del metodo o funcion en donde se encuentre
     */
    for (i in 0..5){
        if (i==3){
            break
        }
        println(i)
    }
    contador = names.size
    do {
        contador--
        if (contador< 0){
            break
        }
        println("contador: $contador")
        println("Nombre en el contador: ${names.get(contador)}")
    }while (contador>=0)

}

fun multiArgumentos(vararg names:String){
    println("Varag en la poscicion 0 es: ${names[0]}")
}