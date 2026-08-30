package com.stable.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.stable.app.navigation.StableNavHost
import com.stable.app.ui.theme.STABLETheme
import com.stable.app.viewmodel.WorkoutViewModel
import com.stable.app.viewmodel.WorkoutViewModelFactory

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {

            val repository =
                (application as StableApplication)
                    .repository

            val workoutViewModel: WorkoutViewModel =
                viewModel(
                    factory = WorkoutViewModelFactory(
                        repository
                    )
                )

            STABLETheme {

                Surface(
                    modifier = Modifier
                ) {

                    StableNavHost(
                        workoutViewModel = workoutViewModel
                    )

                }

            }

        }

    }

}