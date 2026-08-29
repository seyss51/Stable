package com.stable.app.data

import android.content.Context
import com.stable.app.model.Exercise
import com.stable.app.model.WorkoutReference

class WorkoutRepository(

    context: Context

) {

    private val loader = JsonLoader(context)

    private val exercises = ExerciseRepository(context)

    fun monday(): List<Exercise> {

        val workout = loader.loadWorkout(

            "workouts/phase1/week1/monday.json"

        )

        return workout.exercises.map {

            exercises.load(it.id)

        }

    }

}