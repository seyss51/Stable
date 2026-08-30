package com.stable.app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.stable.app.data.AppRepository

class WorkoutViewModelFactory(

    private val repository: AppRepository

) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(

        modelClass: Class<T>

    ): T {

        if (modelClass.isAssignableFrom(WorkoutViewModel::class.java)) {

            return WorkoutViewModel(
                repository
            ) as T

        }

        throw IllegalArgumentException(
            "Unknown ViewModel"
        )

    }

}