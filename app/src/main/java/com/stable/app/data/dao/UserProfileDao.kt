package com.stable.app.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.stable.app.data.entity.UserProfileEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserProfileDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(
        profile: UserProfileEntity
    )

    @Query("SELECT * FROM user_profile LIMIT 1")
    fun observeProfile(): Flow<UserProfileEntity?>

    @Query("SELECT * FROM user_profile LIMIT 1")
    suspend fun getProfile(): UserProfileEntity?

}