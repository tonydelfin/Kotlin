package com.example.kotlinbasics.POO

/**
 * Open se tiene que espesificar para poder activar la herencia
 *
 * La herencia se usa para adquirir sus metodos y propiedades ya definidos por una clase padre pero a su vez anexar mas cosas
 */
class Profesor( primerNombre:String,  segundoNombre:String,var numEstudiates:Short): Persona(primerNombre, segundoNombre), Jefe {
    var salon:Salon = Salon("N/A")

    override fun getTrabajo(): String {
        return super.getTrabajo() + " Dando clases..."
    }

    override fun nombredelPerosnal(): String = getNombreCompleto()


    override fun salarioNeto(): Float = salario

    inner class Salon(var Key: String){
        override fun toString(): String {
            return "Salon con llave: $Key "
        }

        fun getInfo():String = "Salon $salon esta el Profesor $primerNombre y tiene $numEstudiates estudiantes"
    }
}