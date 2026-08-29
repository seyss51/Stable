package com.stable.app.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val StableDarkColors = darkColorScheme(

    primary = Orange500,
    secondary = Orange300,

    background = Black900,
    surface = SurfaceDark,

    onPrimary = Gray100,
    onBackground = Gray100,
    onSurface = Gray100

)

@Composable
fun STABLETheme(
    content: @Composable () -> Unit
) {

    MaterialTheme(
        colorScheme = StableDarkColors,
        content = content
    )

}