package com.stable.app.domain

/**
 * Définition d'un exercice.
 */
data class ExerciseDefinition(

    val id: String,

    val name: String,

    val levels: List<ExerciseVariant>

)

/**
 * Une variante d'un exercice.
 */
data class ExerciseVariant(

    val level: Int,

    val title: String,

    val description: String,

    val workSeconds: Int,

    val restSeconds: Int,

    val sets: Int,

    val reps: Int

)