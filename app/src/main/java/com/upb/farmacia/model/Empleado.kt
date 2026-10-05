package com.upb.farmacia.model

class Empleado(
    id: Int,
    nombre: String,
    apellido: String,
    ci: String,
    telefono: String,
    val cargo: Cargo
) : Persona(id, nombre, apellido, ci, telefono) {

    override fun rol(): String = cargo.etiqueta

    /** Solo un farmacéutico puede despachar medicamentos con receta. */
    fun puedeDespacharConReceta(): Boolean = cargo == Cargo.FARMACEUTICO
}
