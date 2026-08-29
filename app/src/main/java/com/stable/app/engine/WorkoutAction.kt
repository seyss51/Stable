package com.stable.app.engine

sealed interface WorkoutAction {

    data object Start : WorkoutAction

    data object Pause : WorkoutAction

    data object Resume : WorkoutAction

    data object Next : WorkoutAction

    data object Previous : WorkoutAction

    data object Stop : WorkoutAction

}