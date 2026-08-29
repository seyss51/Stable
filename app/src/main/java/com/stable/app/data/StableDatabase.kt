package com.stable.app.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.stable.app.data.dao.ExerciseProgressDao
import com.stable.app.data.dao.UserProfileDao
import com.stable.app.data.dao.WorkoutDao
import com.stable.app.data.entity.ExerciseProgressEntity
import com.stable.app.data.entity.UserProfileEntity
import com.stable.app.data.entity.WorkoutSessionEntity

@Database(
    entities = [
        WorkoutSessionEntity::class,
        ExerciseProgressEntity::class,
        UserProfileEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class StableDatabase : RoomDatabase() {

    abstract fun workoutDao(): WorkoutDao

    abstract fun exerciseProgressDao(): ExerciseProgressDao

    abstract fun userProfileDao(): UserProfileDao

}