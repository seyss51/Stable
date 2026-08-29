package com.stable.app.ui.screens.state

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.stable.app.ui.components.BottomNavigationBar

@Composable
fun StateScreen(
    navController: NavController
) {

    var fatigue by remember { mutableFloatStateOf(3f) }
    var douleurs by remember { mutableFloatStateOf(2f) }
    var motivation by remember { mutableFloatStateOf(8f) }
    var sommeil by remember { mutableFloatStateOf(7f) }

    Scaffold(

        bottomBar = {
            BottomNavigationBar(navController)
        }

    ) { padding ->

        Column(

            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(20.dp),

            verticalArrangement = Arrangement.spacedBy(24.dp)

        ) {

            Text(
                text = "ÉTAT DU JOUR",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )

            SliderItem(
                "Fatigue",
                fatigue,
                "0 = aucune | 10 = épuisé"
            ) {
                fatigue = it
            }

            SliderItem(
                "Douleurs",
                douleurs,
                "0 = aucune | 10 = très fortes"
            ) {
                douleurs = it
            }

            SliderItem(
                "Motivation",
                motivation,
                "0 = aucune | 10 = maximale"
            ) {
                motivation = it
            }

            SliderItem(
                "Sommeil",
                sommeil,
                "0 = mauvais | 10 = parfait"
            ) {
                sommeil = it
            }

            Spacer(modifier = Modifier.weight(1f))

            Button(

                modifier = Modifier.fillMaxWidth(),

                onClick = {

                    // Les valeurs seront transmises
                    // au moteur adaptatif dans la prochaine version.

                }

            ) {

                Text("VALIDER")

            }

        }

    }

}

@Composable
private fun SliderItem(
    title: String,
    value: Float,
    help: String,
    onValueChange: (Float) -> Unit
) {

    Column {

        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )

        Text("$help")

        Spacer(modifier = Modifier.height(8.dp))

        Slider(
            value = value,
            onValueChange = onValueChange,
            valueRange = 0f..10f,
            steps = 9
        )

        Text(
            text = "Valeur : ${value.toInt()}"
        )

    }

}