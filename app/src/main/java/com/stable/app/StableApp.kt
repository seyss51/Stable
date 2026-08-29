package com.stable.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.stable.app.navigation.StableNavHost
import com.stable.app.ui.theme.STABLETheme

@Composable
fun StableApp() {

    STABLETheme {

        Surface(
            modifier = Modifier.fillMaxSize()
        ) {

            StableNavHost()

        }

    }

}