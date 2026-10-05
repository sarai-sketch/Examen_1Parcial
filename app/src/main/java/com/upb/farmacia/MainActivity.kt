package com.upb.farmacia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.upb.farmacia.ui.FarmaciaApp
import com.upb.farmacia.ui.theme.FarmaciaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FarmaciaTheme {
                FarmaciaApp()
            }
        }
    }
}
