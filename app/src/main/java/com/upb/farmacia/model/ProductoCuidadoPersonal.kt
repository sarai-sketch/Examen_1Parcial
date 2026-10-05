package com.upb.farmacia.model

class ProductoCuidadoPersonal(
    id: Int,
    nombre: String,
    precio: Double,
    stockInicial: Int,
    proveedor: Proveedor,
    val marca: String,
    val descuentoPorcentaje: Double = 0.0
) : Producto(id, nombre, precio, stockInicial, proveedor) {

    override fun descripcion(): String = "Marca $marca"

    /** Sobrescritura: aplica el descuento promocional. */
    override fun precioFinal(): Double = precio * (1 - descuentoPorcentaje / 100)
}
