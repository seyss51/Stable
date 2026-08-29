package com.stable.app.domain

object ExerciseCatalog {

    val PushUps = ExerciseDefinition(

        id = "pushups",

        name = "Pompes",

        levels = listOf(

            ExerciseVariant(
                level = 1,
                title = "Pompes contre un mur",
                description = "Debout face au mur",
                workSeconds = 30,
                restSeconds = 45,
                sets = 2,
                reps = 10
            ),

            ExerciseVariant(
                level = 2,
                title = "Pompes sur plan de travail",
                description = "Inclinaison légère",
                workSeconds = 35,
                restSeconds = 40,
                sets = 3,
                reps = 10
            ),

            ExerciseVariant(
                level = 3,
                title = "Pompes sur banc",
                description = "Inclinaison moyenne",
                workSeconds = 40,
                restSeconds = 35,
                sets = 3,
                reps = 12
            ),

            ExerciseVariant(
                level = 4,
                title = "Pompes sur les genoux",
                description = "Amplitude complète",
                workSeconds = 45,
                restSeconds = 30,
                sets = 3,
                reps = 12
            ),

            ExerciseVariant(
                level = 5,
                title = "Pompes classiques",
                description = "Version standard",
                workSeconds = 50,
                restSeconds = 25,
                sets = 4,
                reps = 10
            )

        )

    )

}