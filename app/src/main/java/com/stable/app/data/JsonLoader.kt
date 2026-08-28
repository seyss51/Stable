package com.stable.app.data

import android.content.Context
import com.google.gson.Gson
import com.stable.app.model.Workout

class JsonLoader(
    private val context: Context
) {

    private val gson = Gson()

    fun loadWorkout(path: String): Workout {

        val json = context.assets
            .open(path)
            .bufferedReader()
            .use { it.readText() }

        return gson.fromJson(
            json,
            Workout::class.java
        )

    }

}