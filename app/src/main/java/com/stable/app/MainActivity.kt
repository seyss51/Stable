package com.stable.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.stable.app.navigation.AppNavigation
import com.stable.app.ui.theme.StableTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            StableTheme {
                AppNavigation()
            }
        }
    }
}