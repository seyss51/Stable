package com.stable.app.engine

sealed class WorkoutEvents {

    data object Start : WorkoutEvents()

    data object Pause : WorkoutEvents()

    data object Resume : WorkoutEvents()

    data object Next : WorkoutEvents()

    data object Finish : WorkoutEvents()

}