package com.upb.farmacia.model

abstract class Producto(
    val id: Int,
    val nombre: String,
    val precio: Double,
    stockInicial: Int,
    val proveedor: Proveedor
) : Inventariable {

    private var _stock: Int = stockInicial
    override val stock: Int get() = _stock

    init {
        require(precio >= 0) { "El precio no puede ser negativo" }
        require(stockInicial >= 0) { "El stock inicial no puede ser negativo" }
    }

    override fun reponer(cantidad: Int) {
        require(cantidad > 0) { "La cantidad a reponer debe ser positiva" }
        _stock += cantidad
    }

    override fun descontar(cantidad: Int) {
        require(cantidad > 0) { "La cantidad a descontar debe ser positiva" }
        check(cantidad <= _stock) { "Stock insuficiente de $nombre (disponible: $_stock)" }
        _stock -= cantidad
    }

    fun hayStock(): Boolean = _stock > 0
    fun stockBajo(umbral: Int = 10): Boolean = _stock <= umbral

    /** Cada tipo de producto describe su contenido a su manera (polimorfismo). */
    abstract fun descripcion(): String

    /** Por defecto el precio final es el precio base; las subclases pueden sobrescribirlo. */
    open fun precioFinal(): Double = precio
}
