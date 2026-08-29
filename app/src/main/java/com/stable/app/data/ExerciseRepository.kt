package com.stable.app.data

import android.content.Context
import com.google.gson.Gson
import com.stable.app.model.Exercise

class ExerciseRepository(
    private val context: Context
) {

    private val gson = Gson()

    fun load(id: String): Exercise {

        val json = context.assets
            .open("exercises/$id.json")
            .bufferedReader()
            .readText()

        return gson.fromJson(
            json,
            Exercise::class.java
        )

    }

}