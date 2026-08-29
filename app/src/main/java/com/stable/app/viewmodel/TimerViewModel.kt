package com.stable.app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

/**
 * Chronomètre de séance S.T.A.B.L.E.
 *
 * Ce ViewModel pilote automatiquement
 * les phases Travail / Repos.
 *
 * Les durées sont fournies par WorkoutEngine.
 */
class TimerViewModel : ViewModel() {

    enum class Phase {

        READY,

        WORK,

        REST,

        FINISHED

    }

    var phase: Phase = Phase.READY
        private set

    var remainingSeconds: Int = 0
        private set

    var totalSeconds: Int = 0
        private set

    var running: Boolean = false
        private set

    private var timerJob: Job? = null

    /**
     * Lance une phase.
     */
    fun start(seconds: Int, work: Boolean) {

        stop()

        totalSeconds = seconds
        remainingSeconds = seconds

        phase = if (work) {
            Phase.WORK
        } else {
            Phase.REST
        }

        running = true

        timerJob = viewModelScope.launch {

            while (remainingSeconds > 0 && isActive) {

                delay(1000)

                remainingSeconds--

            }

            running = false

            if (phase == Phase.WORK) {

                phase = Phase.REST

            } else {

                phase = Phase.FINISHED

            }

        }

    }

    /**
     * Pause.
     */
    fun pause() {

        timerJob?.cancel()

        running = false

    }

    /**
     * Reprise.
     */
    fun resume() {

        if (remainingSeconds <= 0) return

        timerJob?.cancel()

        running = true

        timerJob = viewModelScope.launch {

            while (remainingSeconds > 0 && isActive) {

                delay(1000)

                remainingSeconds--

            }

            running = false

            if (phase == Phase.WORK) {

                phase = Phase.REST

            } else {

                phase = Phase.FINISHED

            }

        }

    }

    /**
     * Arrêt complet.
     */
    fun stop() {

        timerJob?.cancel()

        running = false

    }

    /**
     * Remise à zéro.
     */
    fun reset() {

        stop()

        remainingSeconds = 0

        totalSeconds = 0

        phase = Phase.READY

    }

    /**
     * Pourcentage d'avancement.
     */
    fun progress(): Float {

        if (totalSeconds == 0) {

            return 0f

        }

        return (totalSeconds - remainingSeconds)
            .toFloat() / totalSeconds.toFloat()

    }

    /**
     * Temps au format mm:ss
     */
    fun formattedTime(): String {

        val minutes = remainingSeconds / 60

        val seconds = remainingSeconds % 60

        return "%02d:%02d".format(
            minutes,
            seconds
        )

    }

    override fun onCleared() {

        super.onCleared()

        stop()

    }

}