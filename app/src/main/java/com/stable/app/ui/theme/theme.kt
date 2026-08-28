package com.stable.app.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable

private val StableColorScheme = darkColorScheme(

    primary = StableOrange,

    secondary = StableOrangeDark,

    background = StableBlack,

    surface = StableAnthracite,

    onPrimary = StableWhite,

    onBackground = StableWhite,

    onSurface = StableWhite

)

@Composable
fun StableTheme(
    content: @Composable () -> Unit
) {

    MaterialTheme(

        colorScheme = StableColorScheme,

        typography = StableTypography,

        shapes = StableShapes,

        content = content

    )

}