package com.stable.app.domain

/**
 * Niveau individuel d'un exercice.
 *
 * Chaque exercice progresse indépendamment.
 */
data class ExerciseLevel(

    val exerciseId: String,

    val level: Int = 1,

    val successStreak: Int = 0,

    val failureStreak: Int = 0,

    val mastery: Int = 0

)