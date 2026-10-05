package com.upb.farmacia.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.upb.farmacia.ui.screens.ClientesScreen
import com.upb.farmacia.ui.screens.MedicamentosScreen

sealed class Destino(val ruta: String, val titulo: String, val icono: ImageVector) {
    data object Medicamentos : Destino("medicamentos", "Medicamentos", Icons.Default.Favorite)
    data object Clientes : Destino("clientes", "Clientes", Icons.Default.Person)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FarmaciaApp() {
    val navController = rememberNavController()
    val destinos = listOf(Destino.Medicamentos, Destino.Clientes)
    val entradaActual by navController.currentBackStackEntryAsState()
    val rutaActual = entradaActual?.destination?.route

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Farmacia Vida · " + (destinos.firstOrNull { it.ruta == rutaActual }?.titulo ?: "")) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        },
        bottomBar = {
            NavigationBar {
                destinos.forEach { destino ->
                    NavigationBarItem(
                        selected = rutaActual == destino.ruta,
                        onClick = {
                            navController.navigate(destino.ruta) {
                                popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = { Icon(destino.icono, contentDescription = destino.titulo) },
                        label = { Text(destino.titulo) }
                    )
                }
            }
        }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = Destino.Medicamentos.ruta,
            modifier = Modifier.padding(padding)
        ) {
            composable(Destino.Medicamentos.ruta) { MedicamentosScreen() }
            composable(Destino.Clientes.ruta) { ClientesScreen() }
        }
    }
}
