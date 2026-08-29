package com.stable.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.stable.app.ui.screens.dashboard.DashboardScreen
import com.stable.app.ui.screens.history.HistoryScreen
import com.stable.app.ui.screens.progress.ProgressScreen
import com.stable.app.ui.screens.settings.SettingsScreen
import com.stable.app.ui.screens.workout.WorkoutScreen

@Composable
fun StableNavHost() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Dashboard.route
    ) {

        composable(Screen.Dashboard.route) {
            DashboardScreen(
                navController = navController
            )
        }

        composable(Screen.Workout.route) {
            WorkoutScreen(
                navController = navController
            )
        }

        composable(Screen.Progress.route) {
            ProgressScreen(
                navController = navController
            )
        }

        composable(Screen.History.route) {
            HistoryScreen(
                navController = navController
            )
        }

        composable(Screen.Settings.route) {
            SettingsScreen(
                navController = navController
            )
        }

    }

}