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
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.upb.farmacia.data.FarmaciaRepository
import com.upb.farmacia.model.Medicamento
import com.upb.farmacia.ui.theme.FarmaciaTheme
import java.time.format.DateTimeFormatter
import java.util.Locale

private val formatoMesAnio: DateTimeFormatter = DateTimeFormatter.ofPattern("MM/yyyy")

@Composable
fun MedicamentosScreen(medicamentos: List<Medicamento> = FarmaciaRepository.medicamentos) {
    var busqueda by remember { mutableStateOf("") }
    var soloReceta by remember { mutableStateOf(false) }

    val filtrados = medicamentos.filter {
        (it.nombre.contains(busqueda, ignoreCase = true) ||
            it.principioActivo.contains(busqueda, ignoreCase = true)) &&
            (!soloReceta || it.requiereReceta)
    }

    Column(Modifier.fillMaxSize()) {
        OutlinedTextField(
            value = busqueda,
            onValueChange = { busqueda = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 12.dp, bottom = 4.dp),
            label = { Text("Buscar medicamento") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
            singleLine = true
        )
        Row(
            modifier = Modifier.padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            FilterChip(selected = !soloReceta, onClick = { soloReceta = false }, label = { Text("Todos") })
            FilterChip(selected = soloReceta, onClick = { soloReceta = true }, label = { Text("Con receta") })
        }
        Text(
            text = "${filtrados.size} resultado(s)",
            style = MaterialTheme.typography.labelLarge,
            modifier = Modifier.padding(start = 16.dp, top = 8.dp)
        )
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            if (filtrados.isEmpty()) {
                item { Text("No se encontraron medicamentos.") }
            }
            items(filtrados, key = { it.id }) { MedicamentoCard(it) }
        }
    }
}

@Composable
fun MedicamentoCard(m: Medicamento) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Icon(Icons.Default.Favorite, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
            }
            Spacer(Modifier.width(16.dp))
            Column(Modifier.weight(1f)) {
                Text(m.nombre, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                Text(m.descripcion(), style = MaterialTheme.typography.bodyMedium)
                Text(
                    m.proveedor.razonSocial,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.padding(top = 6.dp)) {
                    AssistChip(onClick = {}, label = { Text(m.categoria.etiqueta) })
                    if (m.requiereReceta) {
                        AssistChip(onClick = {}, label = { Text("Receta") })
                    }
                }
                Text(
                    text = "Stock: ${m.stock}" + if (m.stockBajo()) " (bajo)" else "",
                    style = MaterialTheme.typography.bodySmall,
                    color = if (m.stockBajo()) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onSurface
                )
                val vencido = m.estaVencido()
                val porVencer = !vencido && m.diasParaVencer() <= 90
                Text(
                    text = when {
                        vencido -> "VENCIDO (${m.fechaVencimiento.format(formatoMesAnio)})"
                        porVencer -> "Vence pronto: ${m.fechaVencimiento.format(formatoMesAnio)}"
                        else -> "Vence: ${m.fechaVencimiento.format(formatoMesAnio)}"
                    },
                    style = MaterialTheme.typography.bodySmall,
                    color = if (vencido || porVencer) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onSurface
                )
            }
            Text(
                text = String.format(Locale.US, "Bs %.2f", m.precioFinal()),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MedicamentosScreenPreview() {
    FarmaciaTheme { MedicamentosScreen() }
}
