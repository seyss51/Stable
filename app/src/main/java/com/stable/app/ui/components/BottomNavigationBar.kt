package com.stable.app.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.stable.app.navigation.Screen
import com.stable.app.ui.theme.Orange500

@Composable
fun BottomNavigationBar(
    navController: NavController
) {

    val backStackEntry by navController.currentBackStackEntryAsState()

    val currentRoute = backStackEntry?.destination?.route

    val items = listOf(

        NavigationItem(
            label = "Accueil",
            route = Screen.Dashboard.route,
            icon = Icons.Default.Home
        ),

        NavigationItem(
            label = "Séance",
            route = Screen.Workout.route,
            icon = Icons.Default.FitnessCenter
        ),

        NavigationItem(
            label = "Progression",
            route = Screen.Progress.route,
            icon = Icons.Default.BarChart
        ),

        NavigationItem(
            label = "Historique",
            route = Screen.History.route,
            icon = Icons.Default.History
        ),

        NavigationItem(
            label = "Réglages",
            route = Screen.Settings.route,
            icon = Icons.Default.Settings
        )

    )

    NavigationBar {

        items.forEach { item ->

            NavigationBarItem(

                selected = currentRoute == item.route,

                onClick = {

                    if (currentRoute != item.route) {

                        navController.navigate(item.route) {

                            popUpTo(
                                navController.graph.findStartDestination().id
                            ) {
                                saveState = true
                            }

                            launchSingleTop = true
                            restoreState = true

                        }

                    }

                },

                icon = {

                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.label
                    )

                },

                label = {

                    Text(item.label)

                },

                alwaysShowLabel = true,

                colors = NavigationBarItemDefaults.colors(

                    selectedIconColor = Orange500,
                    selectedTextColor = Orange500

                )

            )

        }

    }

}