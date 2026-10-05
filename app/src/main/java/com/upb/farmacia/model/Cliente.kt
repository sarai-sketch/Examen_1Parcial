package com.upb.farmacia.model

class Cliente(
    id: Int,
    nombre: String,
    apellido: String,
    ci: String,
    telefono: String,
    val nit: String,
    puntosIniciales: Int = 0
) : Persona(id, nombre, apellido, ci, telefono) {

    // Encapsulamiento: los puntos solo cambian mediante acumularPuntos()
    var puntos: Int = puntosIniciales
        private set

    override fun rol(): String = "Cliente"

    /** Regla de negocio: 1 punto por cada Bs 10 de compra. */
    fun acumularPuntos(montoCompra: Double) {
        require(montoCompra >= 0) { "El monto no puede ser negativo" }
        puntos += (montoCompra / 10).toInt()
    }
}
