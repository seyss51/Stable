package com.stable.app.viewmodel

import androidx.lifecycle.ViewModel
import com.stable.app.domain.DailyState
import com.stable.app.domain.Exercise
import com.stable.app.domain.WorkoutEngine
import com.stable.app.domain.WorkoutPlan
import androidx.lifecycle.viewModelScope
import com.stable.app.data.AppRepository
import com.stable.app.data.entity.WorkoutSessionEntity
import kotlinx.coroutines.launch

/**
 * ViewModel principal des séances S.T.A.B.L.E.
 *
 * Il pilote :
 * - la génération automatique de la séance
 * - la progression des exercices
 * - le chronomètre
 * - le passage exercice suivant
 */
class WorkoutViewModel(

    private val repository: AppRepository

) : ViewModel()

    // -------------------------------
    // Etat du jour
    // -------------------------------

    var fatigue = 3
        private set

    var pain = 2
        private set

    var motivation = 8
        private set

    var sleep = 7
        private set

    // -------------------------------
    // Séance
    // -------------------------------

    var workout: WorkoutPlan? = null
        private set

    private var exerciseIndex = 0

    // -------------------------------
    // Chronomètre
    // -------------------------------

    val timer = TimerViewModel()

    // -------------------------------
    // Mise à jour des curseurs
    // -------------------------------

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

    // -------------------------------
    // Construction de la séance
    // -------------------------------

    fun generateWorkout() {

        workout = WorkoutEngine.buildWorkout(

            DailyState(
                fatigue = fatigue,
                pain = pain,
                motivation = motivation,
                sleep = sleep
            )

        )

        exerciseIndex = 0

    }

    // -------------------------------
    // Début séance
    // -------------------------------

    fun startWorkout() {

        if (workout == null) {

            generateWorkout()

        }

        startCurrentExercise()

    }

    // -------------------------------
    // Exercice actuel
    // -------------------------------

    fun currentExercise(): Exercise? {

        val list = workout?.exercises ?: return null

        if (exerciseIndex >= list.size) {

            return null

        }

        return list[exerciseIndex]

    }

    // -------------------------------
    // Lance le chrono
    // -------------------------------

    fun startCurrentExercise() {

        val exercise = currentExercise() ?: return

        timer.start(

            seconds = exercise.workSeconds,

            work = true

        )

    }

    // -------------------------------
    // Lance le repos
    // -------------------------------

    fun startRest() {

        val exercise = currentExercise() ?: return

        timer.start(

            seconds = exercise.restSeconds,

            work = false

        )

    }

    // -------------------------------
    // Exercice suivant
    // -------------------------------

    fun nextExercise() {

        exerciseIndex++

        if (exerciseIndex >= (workout?.exercises?.size ?: 0)) {

            finishWorkout()

            return

        }

        startCurrentExercise()

    }

    // -------------------------------
    // Fin séance
    // -------------------------------

    fun finishWorkout() {

        timer.reset()

    }

    // -------------------------------
    // Informations UI
    // -------------------------------

    fun currentExerciseNumber(): Int {

        return exerciseIndex + 1

    }

    fun totalExercises(): Int {

        return workout?.exercises?.size ?: 0

    }

    fun progress(): Float {

        val total = totalExercises()

        if (total == 0) return 0f

        return exerciseIndex.toFloat() / total.toFloat()

    }

}
fun saveWorkout() {

    val currentWorkout = workout ?: return

    viewModelScope.launch {

        repository.saveSession(

            WorkoutSessionEntity(

                date = System.currentTimeMillis(),

                duration = currentWorkout.duration,

                level = currentWorkout.level,

                completed = true,

                fatigue = fatigue,

                pain = pain,

                motivation = motivation,

                sleep = sleep

            )

        )

    }

}