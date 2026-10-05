package com.upb.farmacia.model

import java.time.LocalDate
import java.time.temporal.ChronoUnit

class Medicamento(
    id: Int,
    nombre: String,
    precio: Double,
    stockInicial: Int,
    proveedor: Proveedor,
    val principioActivo: String,
    val concentracion: String,
    val categoria: CategoriaMedicamento,
    val requiereReceta: Boolean,
    val fechaVencimiento: LocalDate
) : Producto(id, nombre, precio, stockInicial, proveedor) {

    override fun descripcion(): String = "$principioActivo $concentracion"

    fun estaVencido(hoy: LocalDate = LocalDate.now()): Boolean = fechaVencimiento.isBefore(hoy)

    fun diasParaVencer(hoy: LocalDate = LocalDate.now()): Long =
        ChronoUnit.DAYS.between(hoy, fechaVencimiento)
}
