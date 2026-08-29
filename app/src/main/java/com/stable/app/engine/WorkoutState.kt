package com.stable.app.engine

import com.stable.app.model.Exercise

data class WorkoutState(

    val status: WorkoutStatus = WorkoutStatus.IDLE,

    val currentExercise: Exercise? = null,

    val exerciseIndex: Int = 0,

    val totalExercises: Int = 0,

    val countdown: Int = 5,

    val remainingSeconds: Int = 0,

    val restSeconds: Int = 0,

    val paused: Boolean = false,

    val finished: Boolean = false

)