package com.upb.farmacia.model

/** Interfaz: contrato para todo lo que tiene existencias en almacén. */
interface Inventariable {
    val stock: Int
    fun reponer(cantidad: Int)
    fun descontar(cantidad: Int)
}
