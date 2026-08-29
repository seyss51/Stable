package com.stable.app.engine

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class WorkoutController {

    private val machine = WorkoutStateMachine()

    private val _state = MutableStateFlow(
        WorkoutState()
    )

    val state: StateFlow<WorkoutState>
        = _state

    fun dispatch(
        action: WorkoutAction
    ) {

        _state.value = machine.dispatch(
            _state.value,
            action
        )

    }

}