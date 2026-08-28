package com.stable.app.engine

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.stable.app.data.JsonLoader
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class WorkoutViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val loader = JsonLoader(application)

    private val engine = WorkoutEngine()

    private val _state = MutableStateFlow(
        WorkoutState()
    )

    val state: StateFlow<WorkoutState>
        = _state

    fun startMondayWorkout() {

        viewModelScope.launch {

            val workout = loader.loadWorkout(
                "workouts/phase1/week1/monday.json"
            )

            engine.start(workout) {

                _state.value = it

            }

        }

    }

}