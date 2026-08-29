package com.stable.app.data

import com.stable.app.data.entity.ExerciseProgressEntity
import com.stable.app.data.entity.UserProfileEntity
import com.stable.app.data.entity.WorkoutSessionEntity

class AppRepository(

    private val database: StableDatabase

) {

    val sessions =
        database.workoutDao().observeAll()

    val profile =
        database.userProfileDao().observeProfile()

    val exerciseProgress =
        database.exerciseProgressDao().observeAll()

    suspend fun saveSession(
        session: WorkoutSessionEntity
    ) {

        database
            .workoutDao()
            .insert(session)

    }

    suspend fun saveProfile(
        profile: UserProfileEntity
    ) {

        database
            .userProfileDao()
            .save(profile)

    }

    suspend fun saveExerciseProgress(
        progress: ExerciseProgressEntity
    ) {

        database
            .exerciseProgressDao()
            .save(progress)

    }

}