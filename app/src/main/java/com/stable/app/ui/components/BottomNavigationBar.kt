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
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.stable.app.navigation.Screen
import com.stable.app.ui.theme.Orange500

@Composable
fun BottomNavigationBar(
    navController: NavController
) {

    val backStack =
        navController.currentBackStackEntryAsState()

    val currentRoute =
        backStack.value?.destination?.route

    NavigationBar {

        val items = listOf(

            NavigationItem(
                "Accueil",
                Screen.Dashboard.route,
                Icons.Default.Home
            ),

            NavigationItem(
                "Séance",
                Screen.Workout.route,
                Icons.Default.FitnessCenter
            ),

            NavigationItem(
                "Progression",
                Screen.Progress.route,
                Icons.Default.BarChart
            ),

            NavigationItem(
                "Historique",
                Screen.History.route,
                Icons.Default.History
            ),

            NavigationItem(
                "Réglages",
                Screen.Settings.route,
                Icons.Default.Settings
            )

        )

        items.forEach { item ->

            NavigationBarItem(

                selected = currentRoute == item.route,

                onClick = {

                    if (currentRoute != item.route) {

                        navController.navigate(item.route) {

                            popUpTo(Screen.Dashboard.route)

                            launchSingleTop = true

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

                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Orange500,
                    selectedTextColor = Orange500
                )

            )

        }

    }

}