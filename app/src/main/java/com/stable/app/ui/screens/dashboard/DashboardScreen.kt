package com.stable.app.ui.screens.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.stable.app.navigation.Screen
import com.stable.app.ui.theme.Orange500

@Composable
fun DashboardScreen(
    navController: NavController
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),

        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Text(
            text = "S.T.A.B.L.E.",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Cockpit",
            style = MaterialTheme.typography.titleMedium
        )

        DashboardTop()

        DashboardIndicators()

        DashboardWeight()

        DashboardSession()

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

@Composable
private fun DashboardTop() {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {

        GaugeCard(
            title = "NIVEAU",
            value = "1"
        )

        GaugeCard(
            title = "SÉRIES",
            value = "0"
        )

    }

}

@Composable
private fun DashboardIndicators() {

    Card(
        colors = CardDefaults.cardColors()
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = "ÉTAT DU JOUR",
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(12.dp))

            Indicator(
                "Fatigue",
                "Bonne"
            )

            Indicator(
                "Motivation",
                "Élevée"
            )

            Indicator(
                "Douleurs",
                "Faibles"
            )

        }

    }

}

@Composable
private fun DashboardWeight() {

    Card {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                "OBJECTIF",
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text("Poids actuel : 86 kg")
            Text("Objectif : 75 kg")

            Spacer(modifier = Modifier.height(16.dp))

            LinearProgressIndicator(
                progress = { 0.25f },
                modifier = Modifier.fillMaxWidth()
            )

        }

    }

}

@Composable
private fun DashboardSession() {

    Card {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                "SÉANCE",
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text("Aujourd'hui : Lundi")

            Text("Durée : 18 min")

            Text("Programme : Haut du corps")

        }

    }

}

@Composable
private fun GaugeCard(
    title: String,
    value: String
) {

    Card {

        Column(
            modifier = Modifier
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(
                modifier = Modifier
                    .size(70.dp)
                    .clip(CircleShape)
                    .background(Orange500),
                contentAlignment = Alignment.Center
            ) {

                Text(
                    value,
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = MaterialTheme.typography.headlineSmall
                )

            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(title)

        }

    }

}

@Composable
private fun Indicator(
    label: String,
    value: String
) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Text(label)

        Text(
            value,
            fontWeight = FontWeight.Bold
        )

    }

}