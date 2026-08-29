package com.stable.app.navigation

sealed class Screen(val route: String) {

    data object Dashboard : Screen("dashboard")

    data object Workout : Screen("workout")

    data object Progress : Screen("progress")

    data object History : Screen("history")

    data object Settings : Screen("settings")

}