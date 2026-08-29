package com.stable.app.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val StableColors = darkColorScheme(

    primary = StableOrange,

    secondary = StableOrangeDark,

    background = StableBackground,

    surface = StableSurface,

    onPrimary = StableWhite,

    onBackground = StableWhite,

    onSurface = StableWhite

)

@Composable
fun StableTheme(
    content: @Composable () -> Unit
) {

    MaterialTheme(

        colorScheme = StableColors,

        typography = StableTypography,

        shapes = StableShapes,

        content = content

    )

}