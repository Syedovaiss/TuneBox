package com.ovais.tunebox.core.app.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.ovais.tunebox.core.ui.theme.TuneBoxTheme
import com.ovais.tunebox.features.home.presentation.HomeScreen

class TuneBoxActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TuneBoxTheme {
                val snackBarHostState = remember { SnackbarHostState() }
                Scaffold(modifier = Modifier.Companion.fillMaxSize()) { innerPadding ->
                    HomeScreen(
                        padding = innerPadding,
                        snackbarHostState = snackBarHostState
                    )
                }
            }
        }
    }
}