// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {

    val kotlinVersion = "1.7.10"
    val sqlDelightVersion: String by project

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-serialization:${kotlinVersion}")
        classpath("com.squareup.sqldelight:gradle-plugin:${sqlDelightVersion}")
    }
}

plugins {
    id("com.android.application").version("7.2.2").apply(false)
    id("com.android.library").version("7.2.2").apply(false)
    id("org.jetbrains.kotlin.android").version("1.7.10").apply(false)
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}