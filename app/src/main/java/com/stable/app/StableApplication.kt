package com.stable.app

import android.app.Application
import androidx.room.Room
import com.stable.app.data.AppRepository
import com.stable.app.data.StableDatabase

class StableApplication : Application() {

    lateinit var database: StableDatabase
        private set

    lateinit var repository: AppRepository
        private set

    override fun onCreate() {

        super.onCreate()

        database = Room.databaseBuilder(

            applicationContext,

            StableDatabase::class.java,

            "stable.db"

        )
            .fallbackToDestructiveMigration()
            .build()

        repository = AppRepository(database)

    }

}