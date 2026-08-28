package com.stable.app.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MissionCard(

    phase: String,

    duration: String

) {

    StableCard(
        title = "MISSION DU JOUR"
    ) {

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = phase,
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = duration,
            style = MaterialTheme.typography.bodyLarge
        )

    }

}