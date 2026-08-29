package com.stable.app.ui.screens.workout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.stable.app.ui.components.BottomNavigationBar

data class ExerciseUi(
    val title: String,
    val details: String
)

@Composable
fun WorkoutScreen(
    navController: NavController
) {

    val exercises = listOf(

        ExerciseUi(
            "Échauffement",
            "3 min de mobilité"
        ),

        ExerciseUi(
            "Pompes inclinées",
            "3 x 10"
        ),

        ExerciseUi(
            "Bird Dog",
            "3 x 10"
        ),

        ExerciseUi(
            "Gainage",
            "3 x 30 sec"
        ),

        ExerciseUi(
            "Étirements",
            "2 min"
        )

    )

    val checked = remember {

        mutableStateListOf<Boolean>().apply {

            repeat(exercises.size) {

                add(false)

            }

        }

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
                .padding(16.dp)

        ) {

            Text(

                text = "SÉANCE DU JOUR",

                style = MaterialTheme.typography.headlineMedium,

                fontWeight = FontWeight.Bold

            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Durée estimée : 18 minutes"
            )

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(

                modifier = Modifier.weight(1f),

                verticalArrangement = Arrangement.spacedBy(12.dp)

            ) {

                items(exercises.indices.toList()) { index ->

                    Card(

                        colors = CardDefaults.cardColors()

                    ) {

                        Row(

                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),

                            verticalAlignment = Alignment.CenterVertically

                        ) {

                            Checkbox(

                                checked = checked[index],

                                onCheckedChange = {

                                    checked[index] = it

                                }

                            )

                            Column(

                                modifier = Modifier.padding(start = 12.dp)

                            ) {

                                Text(

                                    text = exercises[index].title,

                                    style = MaterialTheme.typography.titleMedium,

                                    fontWeight = FontWeight.Bold

                                )

                                Text(

                                    text = exercises[index].details

                                )

                            }

                        }

                    }

                }

            }

            Spacer(modifier = Modifier.height(12.dp))

            Button(

                modifier = Modifier.fillMaxWidth(),

                onClick = {

                    // Le chronomètre et le moteur adaptatif
                    // seront ajoutés dans la prochaine version.

                }

            ) {

                Text("LANCER LA SÉANCE")

            }

        }

    }

}