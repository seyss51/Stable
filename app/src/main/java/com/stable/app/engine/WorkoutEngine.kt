package com.stable.app.engine

import com.stable.app.model.Exercise

class WorkoutEngine {

    private var exercises: List<Exercise> = emptyList()

    private var index = 0

    private var state = WorkoutState()

    fun currentState(): WorkoutState = state

    fun start(list: List<Exercise>): WorkoutState {

        exercises = list
        index = 0

        return loadExercise()

    }

    fun next(): WorkoutState {

        index++

        return if (index >= exercises.size) {

            state = state.copy(

                status = WorkoutStatus.FINISHED,

                finished = true

            )

            state

        } else {

            loadExercise()

        }

    }

    private fun loadExercise(): WorkoutState {

        val exercise = exercises[index]

        state = WorkoutState(

            status = WorkoutStatus.EXERCISE,

            exerciseIndex = index,

            exercise = exercise,

            remainingSeconds = exercise.duration,

            totalExercises = exercises.size,

            paused = false,

            finished = false

        )

        return state

    }

}