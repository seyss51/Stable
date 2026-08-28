package com.stable.app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CommandCenterScreen() {

    Scaffold {

        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .padding(24.dp),

            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "S.T.A.B.L.E.",
                style = MaterialTheme.typography.headlineLarge
            )

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "MISSION DU JOUR",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text("Phase 1 - Fondations")

            Text("15 minutes")

            Spacer(modifier = Modifier.height(40.dp))

            Button(
                onClick = {
                    // prochain sprint
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
            ) {

                Text("JE M'ENGAGE")

            }

            Spacer(modifier = Modifier.height(40.dp))

            Text(
                text = "Score S.T.A.B.L.E.",
                style = MaterialTheme.typography.titleMedium
            )

            Text(
                text = "82",
                style = MaterialTheme.typography.displayLarge
            )
        }
    }
}