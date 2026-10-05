package com.upb.farmacia.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.upb.farmacia.data.FarmaciaRepository
import com.upb.farmacia.model.Cliente
import com.upb.farmacia.ui.theme.FarmaciaTheme

@Composable
fun ClientesScreen(clientes: List<Cliente> = FarmaciaRepository.clientes) {
    Column(Modifier.fillMaxSize()) {
        Text(
            text = "Clientes registrados: ${clientes.size}",
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier.padding(start = 16.dp, top = 16.dp)
        )
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(clientes, key = { it.id }) { ClienteCard(it) }
        }
    }
}

@Composable
fun ClienteCard(c: Cliente) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primary),
                contentAlignment = Alignment.Center
            ) {
                val iniciales = "${c.nombre.first()}${c.apellido.first()}"
                Text(iniciales, color = MaterialTheme.colorScheme.onPrimary, fontWeight = FontWeight.Bold)
            }
            Spacer(Modifier.width(16.dp))
            Column(Modifier.weight(1f)) {
                Text(c.nombreCompleto(), style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                Text("CI: ${c.ci}", style = MaterialTheme.typography.bodyMedium)
                Text("NIT: ${c.nit}", style = MaterialTheme.typography.bodySmall)
                Text("Tel: ${c.telefono}", style = MaterialTheme.typography.bodySmall)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(Icons.Default.Star, contentDescription = "Puntos", tint = MaterialTheme.colorScheme.primary)
                Text("${c.puntos} pts", style = MaterialTheme.typography.labelLarge)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ClientesScreenPreview() {
    FarmaciaTheme { ClientesScreen() }
}
