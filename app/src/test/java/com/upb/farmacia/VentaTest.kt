package com.upb.farmacia

import com.upb.farmacia.model.*
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test
import java.time.LocalDate

class VentaTest {
    private val prov = Proveedor(1, "Prov", "123", "000")
    private val cliente = Cliente(1, "Ana", "Pérez", "1", "7", "11")
    private val farmaceutico = Empleado(1, "Luis", "Rojas", "2", "7", Cargo.FARMACEUTICO)
    private val cajero = Empleado(2, "Eva", "Sosa", "3", "7", Cargo.CAJERO)
    private val futuro = LocalDate.now().plusYears(1)

    private fun medicamento(receta: Boolean) = Medicamento(
        1, "Amoxicilina", 20.0, 10, prov, "Amoxicilina", "500 mg",
        CategoriaMedicamento.ANTIBIOTICO, receta, futuro
    )

    @Test
    fun total_y_stock_se_actualizan() {
        val m = medicamento(false)
        val v = Venta(1, cliente, cajero)
        v.agregar(m, 3)
        assertEquals(60.0, v.total(), 0.001)
        assertEquals(7, m.stock)
    }

    @Test
    fun cajero_no_puede_vender_con_receta() {
        val v = Venta(1, cliente, cajero)
        assertThrows(IllegalStateException::class.java) { v.agregar(medicamento(true), 1) }
    }

    @Test
    fun farmaceutico_si_puede_vender_con_receta() {
        val v = Venta(1, cliente, farmaceutico)
        v.agregar(medicamento(true), 1)
        assertEquals(20.0, v.total(), 0.001)
    }

    @Test
    fun finalizar_acumula_puntos() {
        val v = Venta(1, cliente, cajero)
        v.agregar(medicamento(false), 5) // Bs 100 -> 10 puntos
        v.finalizar()
        assertEquals(10, cliente.puntos)
    }

    @Test
    fun descuento_en_cuidado_personal() {
        val p = ProductoCuidadoPersonal(2, "Jabón", 10.0, 5, prov, "Dove", 20.0)
        assertEquals(8.0, p.precioFinal(), 0.001)
    }
}
