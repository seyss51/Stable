package com.stable.app.ui.screens.workout

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WorkoutScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Séance du jour",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(24.dp))

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text("Échauffement")
                Text("3 min")

                Spacer(modifier = Modifier.height(12.dp))

                Text("Pompes inclinées")
                Text("3 x 10")

                Spacer(modifier = Modifier.height(12.dp))

                Text("Bird Dog")
                Text("3 x 10")

                Spacer(modifier = Modifier.height(12.dp))

                Text("Gainage")
                Text("3 x 30 sec")

            }

        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { }
        ) {
            Text("DÉMARRER")
        }

    }

}