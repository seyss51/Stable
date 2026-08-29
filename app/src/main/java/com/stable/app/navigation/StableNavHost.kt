package com.stable.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.stable.app.ui.screens.dashboard.DashboardScreen

@Composable
fun StableNavHost() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Dashboard.route
    ) {

        composable(Screen.Dashboard.route) {
            DashboardScreen(navController)
        }

    }

}