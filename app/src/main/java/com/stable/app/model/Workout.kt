package com.stable.app.model

data class Workout(

    val id: String,

    val title: String,

    val phase: Int,

    val week: Int,

    val estimatedMinutes: Int,

    val exercises: List<WorkoutReference>

)