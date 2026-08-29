package com.stable.app.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Progression indépendante
 * d'un exercice.
 */
@Entity(tableName = "exercise_progress")
data class ExerciseProgressEntity(

    @PrimaryKey
    val exerciseId: String,

    val currentLevel: Int,

    val mastery: Int,

    val successStreak: Int,

    val failureStreak: Int,

    val lastUpdate: Long

)