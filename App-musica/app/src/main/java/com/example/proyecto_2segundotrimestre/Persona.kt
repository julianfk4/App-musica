package com.example.proyecto_2segundotrimestre

class Persona(
    val nombre: String,
    val apellidos: String,
    var imagen: String,
    var sonido: Int
)
//    var edad =0
//        get() {
//            if (field < 0)
//                return 0
//            else
//                return field
//}
//    get() {
//        return if (field < 0)
//            val num = field + 5
//        else
//            return field
//    }
//    set(value) {
//        field = if (value < 0) 0 else value
//        if (value<0) field = 0
//    else field = value
//    }
//    var telefono = ""
/*
    constructor(nombre: String, apellidos: String, edad:Int) : this(nombre, apellidos){
        this.edad = edad
    }
    constructor(nombre: String, apellidos: String, edad:Int, estaEmpleado: Boolean) : this(nombre, apellidos){
        this.edad = edad
        this.estaEmpleado = estaEmpleado
        this.telefono=telefono
    }
    val nombreEnMayuscula: String
    init {
        nombreEnMayuscula = nombre.uppercase()
    }

 */
