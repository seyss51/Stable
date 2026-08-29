plugins {

    id("com.android.application")

    id("org.jetbrains.kotlin.android")

    id("org.jetbrains.kotlin.plugin.compose")

}

android {

    namespace = "com.stable.app"

    compileSdk = 36

    defaultConfig {

        applicationId = "com.stable.app"

        minSdk = 29

        targetSdk = 36

        versionCode = 1

        versionName = "0.1.0"

        testInstrumentationRunner =
            "androidx.test.runner.AndroidJUnitRunner"

    }

    buildTypes {

        release {

            isMinifyEnabled = false

            proguardFiles(

                getDefaultProguardFile(
                    "proguard-android-optimize.txt"
                ),

                "proguard-rules.pro"

            )

        }

    }

    compileOptions {

        sourceCompatibility = JavaVersion.VERSION_21

        targetCompatibility = JavaVersion.VERSION_21

    }

    kotlinOptions {

        jvmTarget = "21"

    }

    buildFeatures {

        compose = true

    }

}

dependencies {

    implementation(platform("androidx.compose:compose-bom:2025.02.00"))

    implementation("androidx.activity:activity-compose:1.10.1")

    implementation("androidx.compose.material3:material3")

    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.8.7")

    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.7")

    implementation("androidx.navigation:navigation-compose:2.8.9")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.9.0")

    implementation("com.google.code.gson:gson:2.11.0")

}