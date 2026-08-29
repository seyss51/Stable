package com.stable.app.engine

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.stable.app.data.WorkoutRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class WorkoutViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val repository =
        WorkoutRepository(application)

    private val engine = WorkoutEngine()

    private val _state =
        MutableStateFlow(WorkoutState())

    val state: StateFlow<WorkoutState> =
        _state

    fun startWorkout() {

        viewModelScope.launch {

            val list = repository.monday()

            _state.value =
                engine.start(list)

        }

    }

    fun nextExercise() {

        _state.value =
            engine.next()

    }

}