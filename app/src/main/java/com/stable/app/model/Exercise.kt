package com.stable.app.model

enum class ExerciseType {
    TIMER,
    REPS
}

data class Exercise(

    val id: String,

    val title: String,

    val description: String,

    val type: ExerciseType,

    val duration: Int = 0,

    val repetitions: Int = 0,

    val rest: Int = 0,

    val video: String,

    val tips: List<String>,

    val mistakes: List<String>

)