package com.upb.farmacia.model

class DetalleVenta(
    val producto: Producto,
    val cantidad: Int
) {
    init {
        require(cantidad > 0) { "La cantidad debe ser mayor a cero" }
    }

    fun subtotal(): Double = producto.precioFinal() * cantidad
}
