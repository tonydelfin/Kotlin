package com.example.pooenkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var player: Person = Person("Jorge", "Pasaporte de Jorge")

        println(player.alive)
        println(player.name)
        println(player.passport)

        player.die()
        println(player.alive)

        var player2: Person = Person()
        player2.Person()
        println(player2.alive)
        println(player2.name)
        println(player2.passport)

        var Picachu: Pokemon = Pokemon()
        Picachu.setName("Pikachu")
        println(Picachu.getName())
        Picachu.setLive(1000.0f)
        println(Picachu.getLive())
        println(Picachu.getAttackPower())

        //Herencia:
        //Tener ojetos que consigan atricbutos y metodos de alguna clase padre, ,as los propios

        var messi: Person.Athlete= Person.Athlete("Lionel Mess", "MESSI", "Futbol")

        println(messi.alive)
        println(messi.name)
        println(messi.passport)
        println(messi.sport)

        messi.die()
        println(messi.alive)

        //polimosrfismo
        //la posibilidad de implemetar metodos iguales heredados de una clase padre pero ejecutados de diferente manera
        //Se usa Override para sobreescribir la funcion, se pierde el codigo de la funcion padre
        //Se usa super para ejecutar las funcion del padre, mas codigo nuevo

        //Clases Absatractas
        //Funciona por emdeio de la herencia en el cual una case puede tener varias concultas a la clase padre y hace implemtanar los metodos del padre mas los propios

        //Interfaces
        //Se usa para taner una multiple herencia No tienen constructor asi que se inicializan el la clase que los hereda o la clase hijo

        //Clase anidada o subclase
        //hay diferentes tipos de clase, internena que que se declara con inner, y que el padre debe construire primero ya que depende de esta,
        //la clase anidada no depende de ningun padre, NO HAY HERENCIA

        //Objetos Anonimos
        //Se crea un elemento de ninguna clase

        //DATE CLASS
        //Se pueden manejar funciones pero eso no es el objetivo, su obejetivo es almacenar solo datos o atributos

        var sol: Star = Star("Sol", 1000f, "Via lactea")
        println(sol)

        val plutos: Star = Star()
        plutos.alive
        println(plutos)

        //ENUM CLASS
        //Sirve para almacenar Constantes, por ello es comun que tambien tenga funciones

        var hoy: Dias = Dias.LUNES
        var semana = Dias.values()
        for(i in semana){
            println("Hoy es: $i")
        }

        println(Dias.valueOf("SABADO"))
        println(hoy.name)
        println(hoy.ordinal)

        println(hoy.saludo())
        println(hoy.laboral)
        println(hoy.jornada)


    }
}