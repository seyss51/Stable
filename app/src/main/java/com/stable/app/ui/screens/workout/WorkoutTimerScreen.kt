package com.stable.app.ui.screens.workout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.stable.app.ui.components.BottomNavigationBar
import com.stable.app.viewmodel.TimerViewModel

@Composable
fun WorkoutTimerScreen(
    navController: NavController,
    timerViewModel: TimerViewModel
) {

    var started by remember {
        mutableStateOf(false)
    }

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

            horizontalAlignment = Alignment.CenterHorizontally,

            verticalArrangement = Arrangement.SpaceEvenly

        ) {

            Text(

                text = "SÉANCE",

                style = MaterialTheme.typography.headlineMedium,

                fontWeight = FontWeight.Bold

            )

            Card(

                modifier = Modifier.fillMaxWidth(),

                colors = CardDefaults.cardColors()

            ) {

                Column(

                    modifier = Modifier.padding(20.dp),

                    horizontalAlignment = Alignment.CenterHorizontally

                ) {

                    Text(

                        text = when (timerViewModel.phase) {

                            TimerViewModel.Phase.READY ->
                                "PRÊT"

                            TimerViewModel.Phase.WORK ->
                                "TRAVAIL"

                            TimerViewModel.Phase.REST ->
                                "REPOS"

                            TimerViewModel.Phase.FINISHED ->
                                "TERMINÉ"

                        },

                        style = MaterialTheme.typography.titleLarge

                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(

                        text = timerViewModel.formattedTime(),

                        style = MaterialTheme.typography.displayLarge,

                        fontWeight = FontWeight.Bold

                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    LinearProgressIndicator(

                        progress = {

                            timerViewModel.progress()

                        },

                        modifier = Modifier.fillMaxWidth()

                    )

                }

            }

            Column(

                modifier = Modifier.fillMaxWidth(),

                verticalArrangement = Arrangement.spacedBy(12.dp)

            ) {

                Button(

                    modifier = Modifier.fillMaxWidth(),

                    onClick = {

                        if (!started) {

                            timerViewModel.start(
                                seconds = 45,
                                work = true
                            )

                            started = true

                        } else {

                            timerViewModel.resume()

                        }

                    }

                ) {

                    Text("DÉMARRER / REPRENDRE")

                }

                OutlinedButton(

                    modifier = Modifier.fillMaxWidth(),

                    onClick = {

                        timerViewModel.pause()

                    }

                ) {

                    Text("PAUSE")

                }

                OutlinedButton(

                    modifier = Modifier.fillMaxWidth(),

                    onClick = {

                        timerViewModel.reset()

                        started = false

                    }

                ) {

                    Text("RÉINITIALISER")

                }

                Button(

                    modifier = Modifier.fillMaxWidth(),

                    onClick = {

                        // Sera relié au WorkoutViewModel
                        // dans la prochaine étape.

                    }

                ) {

                    Text("EXERCICE SUIVANT")

                }

            }

        }

    }

}