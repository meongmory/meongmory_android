// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }

    dependencies {
        classpath(libs.kotlin.gradleplugin)
        classpath(libs.agp)
        classpath(libs.hilt.plugin)
        classpath(libs.mavenPublish.pluginGradle)
        classpath(libs.metalava.pluginGradle)
    }
}

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.kotlinAndroid) apply false
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.serilization) apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

