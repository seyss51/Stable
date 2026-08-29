package com.stable.app.ui.screens.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.stable.app.navigation.Screen
import com.stable.app.ui.components.BottomNavigationBar
import com.stable.app.ui.theme.Orange500

@Composable
fun DashboardScreen(
    navController: NavController
) {

    Scaffold(

        bottomBar = {

            BottomNavigationBar(navController)

        }

    ) { padding ->

        Column(

            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),

            verticalArrangement = Arrangement.spacedBy(16.dp)

        ) {

            Header()

            Cockpit()

            ObjectiveCard()

            TodayCard()

            Spacer(modifier = Modifier.weight(1f))

            Button(

                modifier = Modifier.fillMaxWidth(),

                onClick = {

                    navController.navigate(Screen.Workout.route)

                }

            ) {

                Text("COMMENCER")

            }

        }

    }

}

@Composable
private fun Header() {

    Column {

        Text(
            text = "S.T.A.B.L.E.",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Performance Moto & TLD",
            style = MaterialTheme.typography.titleMedium
        )

    }

}

@Composable
private fun Cockpit() {

    Row(

        modifier = Modifier.fillMaxWidth(),

        horizontalArrangement = Arrangement.SpaceEvenly

    ) {

        Gauge(
            "NIVEAU",
            "01"
        )

        Gauge(
            "SÉRIES",
            "00"
        )

        Gauge(
            "SEMAINES",
            "01"
        )

    }

}

@Composable
private fun Gauge(

    title: String,

    value: String

) {

    Card(

        colors = CardDefaults.cardColors(),

        shape = RoundedCornerShape(20.dp)

    ) {

        Column(

            modifier = Modifier.padding(16.dp),

            horizontalAlignment = Alignment.CenterHorizontally

        ) {

            Box(

                modifier = Modifier
                    .size(72.dp)
                    .clip(CircleShape)
                    .background(Orange500),

                contentAlignment = Alignment.Center

            ) {

                Text(

                    text = value,

                    style = MaterialTheme.typography.headlineSmall,

                    color = MaterialTheme.colorScheme.onPrimary

                )

            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(title)

        }

    }

}

@Composable
private fun ObjectiveCard() {

    Card {

        Column(

            modifier = Modifier.padding(16.dp)

        ) {

            Text(

                text = "OBJECTIF",

                style = MaterialTheme.typography.titleMedium,

                fontWeight = FontWeight.Bold

            )

            Spacer(modifier = Modifier.height(16.dp))

            DashboardLine("Poids", "86 kg")

            DashboardLine("Objectif", "75 kg")

            DashboardLine("Perte", "-11 kg")

            Spacer(modifier = Modifier.height(16.dp))

            LinearProgressIndicator(

                progress = { 0.25f },

                modifier = Modifier.fillMaxWidth()

            )

        }

    }

}

@Composable
private fun TodayCard() {

    Card {

        Column(

            modifier = Modifier.padding(16.dp)

        ) {

            Text(

                text = "ÉTAT DU JOUR",

                style = MaterialTheme.typography.titleMedium,

                fontWeight = FontWeight.Bold

            )

            Spacer(modifier = Modifier.height(12.dp))

            DashboardLine("Fatigue", "Bonne")

            DashboardLine("Motivation", "Élevée")

            DashboardLine("Douleurs", "Faibles")

            DashboardLine("Séance", "Haut du corps")

            DashboardLine("Durée", "18 min")

        }

    }

}

@Composable
private fun DashboardLine(

    label: String,

    value: String

) {

    Row(

        modifier = Modifier.fillMaxWidth(),

        horizontalArrangement = Arrangement.SpaceBetween

    ) {

        Text(label)

        Text(

            text = value,

            fontWeight = FontWeight.Bold

        )

    }

}