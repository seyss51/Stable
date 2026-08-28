plugins {

    alias(libs.plugins.android.application)

    alias(libs.plugins.kotlin.android)

    alias(libs.plugins.kotlin.compose)

}

android {

    namespace = "com.stable.app"

    compileSdk = 35

    defaultConfig {

        applicationId = "com.stable.app"

        minSdk = 29

        targetSdk = 35

        versionCode = 1

        versionName = "0.1.0"

        testInstrumentationRunner =
            "androidx.test.runner.AndroidJUnitRunner"

    }

    buildTypes {

        release {

            isMinifyEnabled = false

        }

    }

    buildFeatures {

        compose = true

    }

    compileOptions {

        sourceCompatibility = JavaVersion.VERSION_17

        targetCompatibility = JavaVersion.VERSION_17

    }

    kotlinOptions {

        jvmTarget = "17"

    }

}

dependencies {

    implementation(platform(libs.androidx.compose.bom))

    implementation(libs.androidx.core.ktx)

    implementation(libs.androidx.lifecycle.runtime)

    implementation(libs.androidx.activity.compose)

    implementation(libs.androidx.ui)

    implementation(libs.androidx.ui.preview)

    implementation(libs.androidx.material3)
implementation("com.google.code.gson:gson:2.11.0")
implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.7")
implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.9.0")

    debugImplementation(libs.androidx.ui.tooling)

}