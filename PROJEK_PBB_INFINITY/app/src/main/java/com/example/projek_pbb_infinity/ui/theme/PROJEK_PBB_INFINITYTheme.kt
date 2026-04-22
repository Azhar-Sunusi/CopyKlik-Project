package com.example.projek_pbb_infinity.ui.theme

// Perbaiki import di baris atas
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

@Composable
fun PROJEK_PBB_INFINITYTheme(
    content: @Composable () -> Unit
) {
    val colorScheme = lightColorScheme()

    // Ganti Material3Theme menjadi MaterialTheme
    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}