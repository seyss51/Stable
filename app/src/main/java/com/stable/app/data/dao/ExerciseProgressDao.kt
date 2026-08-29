package com.stable.app.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.stable.app.data.entity.ExerciseProgressEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ExerciseProgressDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(
        progress: ExerciseProgressEntity
    )

    @Query(
        "SELECT * FROM exercise_progress"
    )
    fun observeAll():
        Flow<List<ExerciseProgressEntity>>

    @Query(
        "SELECT * FROM exercise_progress WHERE exerciseId=:id LIMIT 1"
    )
    suspend fun get(
        id: String
    ): ExerciseProgressEntity?

}