package com.stable.app.engine

import com.stable.app.model.Exercise

data class WorkoutState(

    val currentExercise: Exercise? = null,

    val currentIndex: Int = 0,

    val remainingTime: Int = 0,

    val running: Boolean = false,

    val finished: Boolean = false

)