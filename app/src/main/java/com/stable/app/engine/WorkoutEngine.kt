package com.stable.app.engine

import com.stable.app.audio.BeepManager
import com.stable.app.model.Exercise

class WorkoutEngine(

    private val timer: WorkoutTimer,

    private val beeper: BeepManager

) {

    private var exercises = emptyList<Exercise>()

    private var index = 0

    fun load(list: List<Exercise>) {

        exercises = list

        index = 0

    }

    fun current(): Exercise? {

        return exercises.getOrNull(index)

    }

    fun next(): Exercise? {

        index++

        return current()

    }

    fun hasNext(): Boolean {

        return index < exercises.lastIndex

    }

    suspend fun startCountdown(

        onTick: (Int) -> Unit,

        onFinish: () -> Unit

    ) {

        timer.countdown(

            5,

            {

                beeper.countdown()

                onTick(it)

            },

            {

                beeper.go()

                onFinish()

            }

        )

    }

}