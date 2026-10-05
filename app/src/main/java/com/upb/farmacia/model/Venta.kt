package com.upb.farmacia.model

import java.time.LocalDateTime

class Venta(
    val id: Int,
    val cliente: Cliente,
    val empleado: Empleado,
    val fecha: LocalDateTime = LocalDateTime.now()
) {
    private val _detalles = mutableListOf<DetalleVenta>()
    val detalles: List<DetalleVenta> get() = _detalles.toList()

    /**
     * Agrega un producto a la venta, valida la receta y descuenta el stock.
     * Lanza IllegalStateException si no se puede vender.
     */
    fun agregar(producto: Producto, cantidad: Int) {
        if (producto is Medicamento) {
            check(!producto.estaVencido()) { "${producto.nombre} está vencido" }
            check(!producto.requiereReceta || empleado.puedeDespacharConReceta()) {
                "${producto.nombre} requiere receta: solo un farmacéutico puede despacharlo"
            }
        }
        producto.descontar(cantidad)
        _detalles.add(DetalleVenta(producto, cantidad))
    }

    fun total(): Double = _detalles.sumOf { it.subtotal() }

    /** Cierra la venta y acredita puntos al cliente. */
    fun finalizar() {
        check(_detalles.isNotEmpty()) { "La venta no tiene productos" }
        cliente.acumularPuntos(total())
    }
}
