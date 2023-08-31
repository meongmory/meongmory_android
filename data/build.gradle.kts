@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.android.library)
    id("dagger.hilt.android.plugin")
    id("kotlin-kapt")
    id("kotlinx-serialization")
}

android {
    namespace = "com.meongmoryteam.data"
    compileSdk = 33

    defaultConfig {
        minSdk = 28
        targetSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
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
    implementation(project(":domain"))
    implementation(files("src/app/main/jniLibs"))
    implementation(files("libs/libDaumMapAndroid.jar"))


    //Retrofit
    implementation(libs.retrofit)
    implementation(libs.okhttp.logging.interceptor)

    // Hilt
    implementation(libs.hilt)
    implementation(files("src/main/jniLibs"))
    kapt(libs.hilt.testing.compiler)

    // Serialization
    implementation(libs.serialization)
    implementation(libs.kotlin.serilization)
}