package com.stable.app.engine

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.StateFlow

class WorkoutViewModel : ViewModel() {

    private val controller =
        WorkoutController()

    val state: StateFlow<WorkoutState>
        = controller.state

    fun start() {

        controller.dispatch(
            WorkoutAction.Start
        )

    }

    fun pause() {

        controller.dispatch(
            WorkoutAction.Pause
        )

    }

    fun resume() {

        controller.dispatch(
            WorkoutAction.Resume
        )

    }

    fun stop() {

        controller.dispatch(
            WorkoutAction.Stop
        )

    }

}