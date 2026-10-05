package com.upb.farmacia.data

import com.upb.farmacia.model.CategoriaMedicamento.*
import com.upb.farmacia.model.Cliente
import com.upb.farmacia.model.Medicamento
import com.upb.farmacia.model.Proveedor
import java.time.LocalDate

/** Repositorio en memoria con datos de ejemplo (sin base de datos, según la consigna). */
object FarmaciaRepository {

    private val illimani = Proveedor(1, "Droguería Illimani S.R.L.", "1020304050", "2-2400100")
    private val andinos = Proveedor(2, "Laboratorios Andinos S.A.", "1029384756", "2-2411222")
    private val farmaSur = Proveedor(3, "Farma Sur Ltda.", "1011223344", "2-2455667")

    val medicamentos: List<Medicamento> = listOf(
        Medicamento(1, "Paracetamol", 6.50, 120, illimani, "Paracetamol", "500 mg", ANALGESICO, false, LocalDate.of(2027, 8, 30)),
        Medicamento(2, "Ibuprofeno", 9.00, 80, andinos, "Ibuprofeno", "400 mg", ANTIINFLAMATORIO, false, LocalDate.of(2027, 5, 15)),
        Medicamento(3, "Amoxicilina", 28.00, 40, andinos, "Amoxicilina", "500 mg", ANTIBIOTICO, true, LocalDate.of(2027, 2, 28)),
        Medicamento(4, "Loratadina", 12.50, 8, farmaSur, "Loratadina", "10 mg", ANTIALERGICO, false, LocalDate.of(2026, 11, 20)),
        Medicamento(5, "Omeprazol", 15.00, 65, illimani, "Omeprazol", "20 mg", GASTROINTESTINAL, false, LocalDate.of(2027, 9, 10)),
        Medicamento(6, "Vitamina C", 22.00, 50, farmaSur, "Ácido ascórbico", "1000 mg", VITAMINA, false, LocalDate.of(2028, 1, 31)),
        Medicamento(7, "Diclofenaco", 11.00, 5, andinos, "Diclofenaco sódico", "50 mg", ANTIINFLAMATORIO, false, LocalDate.of(2027, 4, 12)),
        Medicamento(8, "Azitromicina", 45.00, 25, illimani, "Azitromicina", "500 mg", ANTIBIOTICO, true, LocalDate.of(2027, 6, 5))
    )

    val clientes: List<Cliente> = listOf(
        Cliente(1, "María", "Quispe Mamani", "6543210", "71234567", "6543210018", 120),
        Cliente(2, "Juan Carlos", "Mamani Flores", "7894561", "76543210", "7894561011", 45),
        Cliente(3, "Sofía", "Choque Apaza", "5432109", "70011223", "5432109015", 310),
        Cliente(4, "Luis", "Condori Vargas", "8765432", "68899001", "8765432012", 0),
        Cliente(5, "Ana", "Villalobos Rojas", "4321098", "72345678", "4321098017", 75)
    )
}
