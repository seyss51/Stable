package com.stable.app.engine

import com.stable.app.model.Exercise

data class WorkoutState(

    val status: WorkoutStatus = WorkoutStatus.IDLE,

    val exerciseIndex: Int = 0,

    val exercise: Exercise? = null,

    val remainingSeconds: Int = 0,

    val totalExercises: Int = 0,

    val paused: Boolean = false,

    val finished: Boolean = false

)