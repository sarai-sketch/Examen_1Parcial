package com.upb.farmacia.model

/** Clase abstracta base: abstracción + herencia. */
abstract class Persona(
    val id: Int,
    val nombre: String,
    val apellido: String,
    val ci: String,
    val telefono: String
) {
    fun nombreCompleto(): String = "$nombre $apellido"

    /** Polimorfismo: cada subclase define su rol. */
    abstract fun rol(): String

    override fun toString(): String = "${rol()}: ${nombreCompleto()} (CI $ci)"
}
