package com.example.pooenkotlin

class Pokemon(
    //Encapsulamiento:
    //Asegurar mis datos de la clase para no accedaer libremente a ellos
    //Obteniendo los datos por medio de metodos Sets y Gets
    private var name: String = "Pk",
    private var attackPower: Float = 30f,
    private var life: Float = 100f
) {
    fun Pokemon(n: String, aP: Float){
        this.name = n
        this.attackPower = aP
        this.life = 100f
    }
    //Set y Gets
    fun setName(NewName: String){
        this.name = NewName
    }

    fun getName(): String{
        return this.name
    }
    fun setAttackPower(NewPower:Float){
        this.attackPower = NewPower
    }
    fun getAttackPower(): Float{
        return this.attackPower
    }
    fun setLive(NewLive:Float){
        this.life = NewLive
    }
    fun getLive(): Float{
        return this.life
    }

}