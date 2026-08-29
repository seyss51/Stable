package com.stable.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.stable.app.ui.screens.CommandCenterScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "cockpit"
    ) {

        composable("cockpit") {
            CommandCenterScreen(
                navController = navController
            )
        }

    }

}