package com.stable.app.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.stable.app.data.entity.WorkoutSessionEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface WorkoutDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(
        session: WorkoutSessionEntity
    )

    @Query(
        "SELECT * FROM workout_sessions ORDER BY date DESC"
    )
    fun observeAll(): Flow<List<WorkoutSessionEntity>>

    @Query(
        "DELETE FROM workout_sessions"
    )
    suspend fun deleteAll()

}