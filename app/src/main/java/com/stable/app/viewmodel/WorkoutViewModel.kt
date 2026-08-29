package com.stable.app.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.stable.app.domain.DailyState
import com.stable.app.domain.Exercise
import com.stable.app.domain.WorkoutEngine
import com.stable.app.domain.WorkoutPlan

/**
 * ViewModel principal des séances.
 *
 * Son rôle est de :
 * - conserver l'état du jour
 * - générer la séance adaptée
 * - suivre la progression pendant la séance
 *
 * Aucune base de données n'est utilisée pour l'instant.
 * Elle sera branchée dans une prochaine version.
 */
class WorkoutViewModel : ViewModel() {

    // -------------------------------------------------
    // Etat utilisateur
    // -------------------------------------------------

    var fatigue by mutableStateOf(3)
        private set

    var pain by mutableStateOf(2)
        private set

    var motivation by mutableStateOf(8)
        private set

    var sleep by mutableStateOf(7)
        private set

    // -------------------------------------------------
    // Séance générée
    // -------------------------------------------------

    var workout by mutableStateOf<WorkoutPlan?>(null)
        private set

    // -------------------------------------------------
    // Progression
    // -------------------------------------------------

    var currentExerciseIndex by mutableStateOf(0)
        private set

    var completedExercises by mutableStateOf(0)
        private set

    var sessionStarted by mutableStateOf(false)
        private set

    // -------------------------------------------------
    // Mise à jour des curseurs
    // -------------------------------------------------

    fun updateFatigue(value: Int) {
        fatigue = value
    }

    fun updatePain(value: Int) {
        pain = value
    }

    fun updateMotivation(value: Int) {
        motivation = value
    }

    fun updateSleep(value: Int) {
        sleep = value
    }

    // -------------------------------------------------
    // Génération automatique
    // -------------------------------------------------

    fun generateWorkout() {

        workout = WorkoutEngine.buildWorkout(

            DailyState(

                fatigue = fatigue,

                pain = pain,

                motivation = motivation,

                sleep = sleep

            )

        )

        currentExerciseIndex = 0
        completedExercises = 0

    }

    // -------------------------------------------------
    // Début de séance
    // -------------------------------------------------

    fun startWorkout() {

        if (workout == null) {

            generateWorkout()

        }

        sessionStarted = true

    }

    // -------------------------------------------------
    // Exercice actuel
    // -------------------------------------------------

    fun currentExercise(): Exercise? {

        val list = workout?.exercises ?: return null

        if (currentExerciseIndex >= list.size) {

            return null

        }

        return list[currentExerciseIndex]

    }

    // -------------------------------------------------
    // Exercice suivant
    // -------------------------------------------------

    fun nextExercise() {

        val list = workout?.exercises ?: return

        if (currentExerciseIndex < list.lastIndex) {

            currentExerciseIndex++

            completedExercises++

        } else {

            finishWorkout()

        }

    }

    // -------------------------------------------------
    // Fin de séance
    // -------------------------------------------------

    fun finishWorkout() {

        completedExercises = workout?.exercises?.size ?: 0

        sessionStarted = false

    }

    // -------------------------------------------------
    // Progression (0 à 1)
    // -------------------------------------------------

    fun progress(): Float {

        val total = workout?.exercises?.size ?: return 0f

        if (total == 0) {

            return 0f

        }

        return completedExercises.toFloat() / total.toFloat()

    }

    // -------------------------------------------------
    // Remise à zéro
    // -------------------------------------------------

    fun reset() {

        currentExerciseIndex = 0

        completedExercises = 0

        sessionStarted = false

        workout = null

    }

}