package com.stable.app.engine

import kotlinx.coroutines.delay

class WorkoutTimer {

    suspend fun countdown(

        seconds: Int,

        onTick: (Int) -> Unit,

        onFinish: () -> Unit

    ) {

        for (i in seconds downTo 1) {

            onTick(i)

            delay(1000)

        }

        onFinish()

    }

    suspend fun timer(

        seconds: Int,

        onTick: (Int) -> Unit,

        onFinish: () -> Unit

    ) {

        for (i in seconds downTo 0) {

            onTick(i)

            delay(1000)

        }

        onFinish()

    }

}