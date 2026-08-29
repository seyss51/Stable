package com.stable.app.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Une séance réalisée.
 */
@Entity(tableName = "workout_sessions")
data class WorkoutSessionEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    val date: Long,

    val duration: Int,

    val level: String,

    val completed: Boolean,

    val fatigue: Int,

    val pain: Int,

    val motivation: Int,

    val sleep: Int

)