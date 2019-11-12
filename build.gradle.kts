plugins {
    // "org.jetbrains.kotlin.jvm"
    kotlin("jvm") version "1.3.50" apply false

    // "org.jetbrains.kotlin.kapt"
    kotlin("kapt") version "1.3.50" apply false

    // "kotlinx-serialization"
    id("kotlinx-serialization") version "1.3.50" apply false

    id("org.jetbrains.intellij") version "0.4.12" apply false
}

subprojects {
    if (name == "contracts") {
        apply(plugin = "org.jetbrains.kotlin.jvm")
        apply(plugin = "org.jetbrains.kotlin.kapt")
    }

    if (name == "core") {
        apply(plugin = "org.jetbrains.kotlin.jvm")
        apply(plugin = "org.jetbrains.kotlin.kapt")
        apply(plugin = "kotlinx-serialization")
    }

    if (name == "intellij-code-cleaner") {
        apply(plugin = "org.jetbrains.intellij")
        apply(plugin = "org.jetbrains.kotlin.jvm")
    }

    if (name == "intellij-code-cleaner-components") {
        apply(plugin = "org.jetbrains.intellij")
        apply(plugin = "org.jetbrains.kotlin.jvm")
        apply(plugin = "org.jetbrains.kotlin.kapt")
        apply(plugin = "kotlinx-serialization")
    }
}