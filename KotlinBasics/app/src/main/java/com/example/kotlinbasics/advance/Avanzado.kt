package com.example.kotlinbasics.advance

import com.example.kotlinbasics.POO.Admin
import com.example.kotlinbasics.POO.Escuela
import com.example.kotlinbasics.POO.Persona
import com.example.kotlinbasics.POO.Profesor
import com.example.kotlinbasics.basico.imprimirSubTema
import com.example.kotlinbasics.basico.imprimirSubTitulo
import com.example.kotlinbasics.basico.imprimirTitulo

private var variableNullGlobal: String? = null

private lateinit var lateInitGlobal:String
private val lazyGloba:Any by lazy { "gLazyKotlin" }
fun main(){
    imprimirTitulo("Metodos mas Avanzados")
    imprimirSubTema("Metodos de String")

    val cadena= "Jorge Antonio Delfin Santos"
    val palabra = "Santos"
    println(palabra.length)
    println(cadena.compareTo(palabra))
    println(cadena.equals(palabra))
    println(cadena.contains(palabra))
    println(cadena.toLowerCase())
    println(cadena.toUpperCase())
    println(cadena.subSequence(0,5))
    println(cadena.indexOf("i"))
    println(cadena.lastIndexOf("i"))
    val vacio = ""
    println(vacio.isBlank())
    println(vacio.isEmpty())
    println(cadena.toUpperCase().lastIndexOf("I"))
    println(cadena.replace("A","I"))
    println(cadena.toLowerCase().replace("j","A"))
    println(cadena.replaceBefore("Delfin","Nombre "))
    println(cadena.reversed())
    println(cadena.slice(6..cadena.length-1))
    println(cadena.split(" "))
    println(cadena.startsWith("J"))
    println(cadena.substring(0,5))
    println(cadena.substring(cadena.lastIndexOf("J", cadena.length-1)))
    println(" Jorge Antionio ".trim())

    imprimirTitulo("Null Safety (? !!)")
    imprimirSubTema("?")
    /**
     * Sirve para asigmar null a una variable que puede ser o no nula
     */
    var nullVariable: String? = null
    //nullVariable="Jorge"
    println(nullVariable?.get(0))
    println(variableNullGlobal?.reversed())

    imprimirSubTema("!!")
    /**
     *No es recomendable su uso ya que Kotlin ejecuara el codigo sea null o no
     */
    nullVariable = null
    showMensaje(nullVariable)
    variableNullGlobal= null
    showMensaje("Kotlin")

    imprimirSubTema("Operador Elvis (?:)")

    /**
     * Esto se usa para agregar un valor por defecto a variables que pueden ser nulas
     */
    val elvis = nullVariable ?: "Jorge"
    println("Yo me llamo $elvis")

    /*
    Simplificas esto
     */

    val noElvis= if (nullVariable != null){
        nullVariable
    }else
    {
        "Antionio"
    }
    println("Yo me llamo $noElvis")

    imprimirSubTema("ReadLine()")
    println("Ingrese primer numero: ")
    val numero1 = readLine()
    val a = numero1!!.toInt()
    println("Ingrese segundo numero: ")
    val numero2 =  readLine()
    val b = numero2!!.toInt()
    println("El valor de a = $a y el de b= $b")

    imprimirSubTema("Operadores matematicos")
    println("a + b = ${a + b}")
    println("a - b = ${a - b}")
    println("a * b = ${a * b}")
    println("a / b = ${a / b}")
    println("a % b = ${a % b}")

    imprimirSubTitulo("Smart Cast")
    /**
     * Se usa para convertir un tipo de dato a otro
     */

    var obj: Any = "Kotlin"
    //println(obj.toString().toInt() * b)
    val objNum:Any = 3
    if (objNum is Int){
        println("objNUm es un numero")
        println(objNum.toString().toInt() * b)
    }else{
        "ObjNum no es un numero"
    }

    imprimirSubTema("Try-Catch y Finally ")
    /**
     * Es unamanera de manejar los errores2
     */
    obj = "d"
    try {

        println(obj.toString().toInt() * b)
        println("objNUm es un numero esta es el final del try")
    }catch (e:Exception){
        println(e)
        println("Entro al catch")
    }finally {
        println("Finally siempre se ejecutara alla o no error")
    }

    imprimirSubTema("Unsafe cast")
    obj = "true"
    val unsafeStri:String = obj as String
    println(unsafeStri)
    imprimirSubTema("Safe cast")
    obj = true
    val safeStr = obj as? String
    println(safeStr)

    imprimirSubTema("Throw")
    /**
     * No ayuda a personalizar  los errores
     */
    val job = "Diseñador"

    try {
        checkType(job)
        checkType(3)
    } catch (e: Exception) {
        println(e)
    } finally {
        println("Tarea finalizada")
    }

    imprimirSubTema("infix")
    /**
     * Se usa para sobreescribir funciones de una clase definida
     * o crear otra funcion en una clase ya definida
     */
    val nombre: String = "Android"
    println(nombre.toUpperCase())
    println(nombre.toLowerCase())
    println(nombre.MixDeCadena(true))
    println(nombre.MixDeCadena(false))


    imprimirTitulo("Asiganacion Tardia")
    imprimirSubTema("Lateinit")
    /**
     * Se usa para declara varibales que de principio no tendra valor pero despues si tendra uno de forma segura
     *
     */
    if(setValueForLateInit()){
        println(lateInitGlobal)
        println(lateInitGlobal.MixDeCadena(true))
    }

    imprimirSubTema("Lazy")
    //lazyGloba="s"
    println(lazyGloba)

    imprimirTitulo("Funciones de alcance")
    imprimirSubTema("Whith")
    /**
     *Basicamente es decir haz con [el objeto] esto
     */
    val secundaria = Escuela("Secundaria", "La almoloya", mutableListOf(Persona("Jorge","Antonio")) )
    val profesor: Profesor = Profesor("Jorge", "Delfin", 23)
    val admin: Admin = Admin("Victor","Manuel", 1)
    with(secundaria){
        println("Con este objeto, imprime los siguiente")
        println(getTipo())
        println(toString()) //<--Es una data class
    }

    imprimirSubTema("Apply")
    /**
     * Se usa para asiganar valores a la variables
     */
    profesor.apply {
        salon.Key ="6°b"
        salario = 10f
    }
    println("Datos insertados con apply:")
    println(profesor.salon.Key)
    println(profesor.salario)

    imprimirSubTema("Run")
    /**
     * Ejecutar codigo en elobjeto
     */

    secundaria.run {
        println("Ejecuta esto en el objeto:")
        personal.add(profesor)
        personal.add(admin)
        println("Miembros: ${personal.size}")
        println(this)
    }

    imprimirSubTema("Let")
    var escuela:Escuela? =  null
    escuela = crearEscuela()
    escuela?.let {
        println("Si el objeto es diferente de null imprime esto:")
        escuela.personal.add(admin)
        println("Impresion: ${it}")

    }
    imprimirSubTema("Also")
    /**
     * Se utiliza para agregar otra funcionalidad al objeto pero no lo afecta asu parametros
     */
    val udemy: Escuela
    udemy = Escuela().apply {
        clave = "0770".also {
            println("Tambien se ejecuto el also y la nueva escuela es: $it")
        }
    }

}

private fun crearEscuela(): Escuela? =  Escuela("ITSZN", "Calle Gonazales",false, "0001")

private fun setValueForLateInit():Boolean{
    lateInitGlobal = "gLateInitGlobal"
    return lateInitGlobal.isNotEmpty()
}

private infix fun String.MixDeCadena(firstuUpper: Boolean):String{

    var mixString= ""
    var index = 0
    var modulo =0

    if(firstuUpper){
        this.toUpperCase()
    }else{
        this.toLowerCase()
        modulo= 1
    }

    while (index < this.length){
        if(index % 2 == modulo){
            mixString += this.get(index).toUpperCase()
        }else{
            mixString += this.get(index).toLowerCase()
        }
        index ++
    }
    return mixString
}

fun checkType(valor: Any) {

    if ( valor is String){
        println("El String es valido")
    }else{
        throw TypeCastException("No es un string")
    }
}

private fun showMensaje(msg:String?){
    println("? ${msg?.get(0)}")

    if(msg != null){
        println("!= ${msg.get(0)}")
    }
    if(variableNullGlobal != null){
        println("global !! ${variableNullGlobal!!.get(0)}")
    }
}