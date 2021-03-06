plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
}

android {
    compileSdkVersion(29)
    defaultConfig {
        minSdkVersion(29)
        targetSdkVersion(29)
        applicationId = "com.airmap.sample"
        versionCode = 1
        versionName = "1.0"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions.apply {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

ktlint {
    android.set(true)
    debug.set(true)
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(project(":core"))
    implementation("androidx.appcompat:appcompat:1.1.0")
    implementation("androidx.core:core-ktx:1.2.0")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")
    implementation("com.squareup.moshi:moshi:1.9.2")
    debugApi("com.readystatesoftware.chuck:library:1.1.0")
    releaseApi("com.readystatesoftware.chuck:library-no-op:1.1.0")
    api("com.jakewharton.timber:timber:4.7.1")
}
