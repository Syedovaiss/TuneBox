package com.ovais.tunebox.core.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable


private val ColorScheme = lightColorScheme(
    primary = ColorPrimary,
    secondary = ColorSecondary,
    background = AppBackground,
    surface = AppBackground
)

@Composable
fun TuneBoxTheme(
    content: @Composable () -> Unit
) {

    MaterialTheme(
        colorScheme = ColorScheme,
        typography = Typography,
        content = content
    )
}