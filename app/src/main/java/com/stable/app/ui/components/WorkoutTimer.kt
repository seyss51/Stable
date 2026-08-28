package com.stable.app.engine

import kotlinx.coroutines.delay

class WorkoutTimer {

    suspend fun start(

        seconds: Int,

        onTick: (Int) -> Unit,

        onFinish: () -> Unit

    ) {

        for (time in seconds downTo 0) {

            onTick(time)

            delay(1000)

        }

        onFinish()

    }

}