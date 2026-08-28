package com.stable.app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.stable.app.ui.components.*

@Composable
fun CommandCenterScreen() {

    Column(

        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),

        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        StableTopBar()

        Spacer(modifier = Modifier.height(20.dp))

        ScoreGauge(
            score = 82
        )

        Spacer(modifier = Modifier.height(24.dp))

        MissionCard(

            phase = "Phase 1 • Fondations",

            duration = "15 minutes"

        )

        Spacer(modifier = Modifier.height(24.dp))

        StableButton(

            text = "JE M'ENGAGE"

        ) {

            // Navigation vers la séance

        }

    }

}