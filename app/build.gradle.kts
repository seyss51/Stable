plugins {

    id("com.android.application")

    id("org.jetbrains.kotlin.android")

    id("com.google.devtools.ksp")

}

android {

    namespace = "com.stable.app"

    compileSdk = 36

    defaultConfig {

        applicationId = "com.stable.app"

        minSdk = 31

        targetSdk = 36

        versionCode = 1

        versionName = "1.0.0"

        testInstrumentationRunner =
            "androidx.test.runner.AndroidJUnitRunner"

        vectorDrawables {

            useSupportLibrary = true

        }

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

        sourceCompatibility =
            JavaVersion.VERSION_17

        targetCompatibility =
            JavaVersion.VERSION_17

    }

    kotlinOptions {

        jvmTarget = "17"

    }

    buildFeatures {

        compose = true

    }

}

dependencies {

    implementation(platform("androidx.compose:compose-bom:2025.08.00"))

    implementation("androidx.activity:activity-compose:1.11.0")

    implementation("androidx.compose.ui:ui")

    implementation("androidx.compose.material3:material3")

    implementation("androidx.compose.material:material-icons-extended")

    implementation("androidx.navigation:navigation-compose:2.9.3")

    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.9.3")

    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.9.3")

    implementation("androidx.room:room-runtime:2.7.2")

    implementation("androidx.room:room-ktx:2.7.2")

    ksp("androidx.room:room-compiler:2.7.2")

}