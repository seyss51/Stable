# STABLE V1

# Garder les annotations Room
-keepattributes *Annotation*

# Kotlin Metadata
-keep class kotlin.Metadata { *; }

# Compose
-dontwarn androidx.compose.**

# Room
-keep class androidx.room.** { *; }

# Navigation
-dontwarn androidx.navigation.**