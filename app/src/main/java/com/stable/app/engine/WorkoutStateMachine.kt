package com.stable.app.engine

class WorkoutStateMachine {

    fun dispatch(

        current: WorkoutState,

        action: WorkoutAction

    ): WorkoutState {

        return when (action) {

            WorkoutAction.Pause ->
                current.copy(
                    paused = true,
                    status = WorkoutStatus.PAUSED
                )

            WorkoutAction.Resume ->
                current.copy(
                    paused = false,
                    status = WorkoutStatus.EXERCISE
                )

            WorkoutAction.Stop ->
                current.copy(
                    finished = true,
                    status = WorkoutStatus.FINISHED
                )

            else -> current

        }

    }

}