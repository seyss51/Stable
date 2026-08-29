package com.stable.app.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.stable.app.ui.components.MissionCard
import com.stable.app.ui.components.ScoreGauge
import com.stable.app.ui.components.StableButton
import com.stable.app.ui.components.StableTopBar

@Composable
fun CommandCenterScreen(
    navController: NavController
) {

    Scaffold(
        topBar = {
            StableTopBar()
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(20.dp),

            horizontalAlignment = Alignment.CenterHorizontally,

            verticalArrangement = Arrangement.Top

        ) {

            Spacer(modifier = Modifier.height(16.dp))

            ScoreGauge(score = 82)

            Spacer(modifier = Modifier.height(28.dp))

            MissionCard(
                phase = "Phase 1 • Fondations",
                duration = "15 minutes"
            )

            Spacer(modifier = Modifier.height(28.dp))

            StableButton(
                text = "JE M'ENGAGE"
            ) {

                navController.navigate("workout")

            }

        }

    }

}