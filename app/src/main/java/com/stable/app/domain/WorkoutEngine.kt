package com.stable.app.domain

/**
 * Moteur d'adaptation des séances S.T.A.B.L.E.
 *
 * Les valeurs proviennent de l'écran "État du jour".
 *
 * Toutes les notes sont comprises entre 0 et 10.
 */
object WorkoutEngine {

    fun buildWorkout(
        state: DailyState
    ): WorkoutPlan {

        val intensity = computeIntensity(state)

        return when {

            intensity >= 80 -> hardWorkout()

            intensity >= 60 -> normalWorkout()

            intensity >= 40 -> lightWorkout()

            else -> recoveryWorkout()

        }

    }

    /**
     * Calcule un score de forme sur 100.
     */
    private fun computeIntensity(
        state: DailyState
    ): Int {

        var score = 100

        // Plus la fatigue est élevée,
        // plus on réduit le score.
        score -= state.fatigue * 5

        // Les douleurs ont encore plus d'importance.
        score -= state.pain * 6

        // Un bon sommeil améliore la récupération.
        score += state.sleep * 2

        // La motivation apporte un léger bonus.
        score += state.motivation

        return score.coerceIn(0, 100)

    }

    /**
     * Séance complète.
     */
    private fun hardWorkout() = WorkoutPlan(

        level = "FORTE",

        duration = 20,

        exercises = listOf(

            Exercise(
                "Pompes inclinées",
                4,
                12
            ),

            Exercise(
                "Bird Dog",
                4,
                12
            ),

            Exercise(
                "Gainage",
                4,
                40
            ),

            Exercise(
                "Squat",
                4,
                15
            )

        )

    )

    /**
     * Séance standard.
     */
    private fun normalWorkout() = WorkoutPlan(

        level = "NORMALE",

        duration = 18,

        exercises = listOf(

            Exercise(
                "Pompes inclinées",
                3,
                10
            ),

            Exercise(
                "Bird Dog",
                3,
                10
            ),

            Exercise(
                "Gainage",
                3,
                30
            )

        )

    )

    /**
     * Séance allégée.
     */
    private fun lightWorkout() = WorkoutPlan(

        level = "LÉGÈRE",

        duration = 15,

        exercises = listOf(

            Exercise(
                "Pompes contre un mur",
                2,
                10
            ),

            Exercise(
                "Bird Dog",
                2,
                8
            ),

            Exercise(
                "Gainage",
                2,
                20
            )

        )

    )

    /**
     * Journée récupération.
     */
    private fun recoveryWorkout() = WorkoutPlan(

        level = "RÉCUPÉRATION",

        duration = 12,

        exercises = listOf(

            Exercise(
                "Mobilité épaules",
                2,
                10
            ),

            Exercise(
                "Mobilité nuque",
                2,
                10
            ),

            Exercise(
                "Respiration",
                1,
                300
            )

        )

    )

}

/**
 * État renseigné avant la séance.
 */
data class DailyState(

    val fatigue: Int,

    val pain: Int,

    val motivation: Int,

    val sleep: Int

)

/**
 * Un exercice.
 */
data class Exercise(

    val name: String,

    val sets: Int,

    val reps: Int

)

/**
 * Séance générée.
 */
data class WorkoutPlan(

    val level: String,

    val duration: Int,

    val exercises: List<Exercise>

)