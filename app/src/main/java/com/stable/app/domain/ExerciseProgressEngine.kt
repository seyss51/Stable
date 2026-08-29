package com.stable.app.domain

/**
 * Gère la progression d'un exercice.
 *
 * Progression prudente.
 */
object ExerciseProgressEngine {

    fun update(

        current: ExerciseLevel,

        success: Boolean,

        pain: Int

    ): ExerciseLevel {

        if (pain >= 6) {

            return current.copy(

                successStreak = 0,

                failureStreak = current.failureStreak + 1

            )

        }

        if (success) {

            val streak = current.successStreak + 1

            if (streak >= 3) {

                return current.copy(

                    level = current.level + 1,

                    successStreak = 0,

                    failureStreak = 0,

                    mastery = 0

                )

            }

            return current.copy(

                successStreak = streak,

                mastery = (current.mastery + 20).coerceAtMost(100)

            )

        }

        return current.copy(

            successStreak = 0,

            failureStreak = current.failureStreak + 1

        )

    }

}