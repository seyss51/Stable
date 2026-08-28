package com.stable.app.engine

import com.stable.app.model.Workout
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WorkoutEngine(

    private val timer: WorkoutTimer = WorkoutTimer()

) {

    private var state = WorkoutState()

    fun state() = state

    fun start(

        workout: Workout,

        onUpdate: (WorkoutState) -> Unit

    ) {

        if (workout.exercises.isEmpty()) return

        CoroutineScope(Dispatchers.Main).launch {

            workout.exercises.forEachIndexed { index, exercise ->

                state = state.copy(

                    currentExercise = exercise,

                    currentIndex = index,

                    remainingTime = exercise.duration,

                    running = true,

                    finished = false

                )

                onUpdate(state)

                if (exercise.duration > 0) {

                    timer.start(

                        seconds = exercise.duration,

                        onTick = {

                            state = state.copy(
                                remainingTime = it
                            )

                            onUpdate(state)

                        },

                        onFinish = {}

                    )

                }

            }

            state = state.copy(

                running = false,

                finished = true

            )

            onUpdate(state)

        }

    }

}