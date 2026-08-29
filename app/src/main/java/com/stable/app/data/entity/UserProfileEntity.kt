package com.stable.app.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Profil utilisateur.
 *
 * Une seule ligne dans la table.
 */
@Entity(tableName = "user_profile")
data class UserProfileEntity(

    @PrimaryKey
    val id: Int = 1,

    val weight: Float,

    val targetWeight: Float,

    val height: Int,

    val age: Int,

    val totalSessions: Int,

    val totalMinutes: Int

)