package com.upb.farmacia.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val EsquemaFarmacia = lightColorScheme(
    primary = Color(0xFF2E7D32),
    onPrimary = Color.White,
    primaryContainer = Color(0xFFC8E6C9),
    onPrimaryContainer = Color(0xFF0B3D10),
    secondary = Color(0xFF00796B),
    error = Color(0xFFC62828)
)

@Composable
fun FarmaciaTheme(content: @Composable () -> Unit) {
    MaterialTheme(colorScheme = EsquemaFarmacia, content = content)
}
