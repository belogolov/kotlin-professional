plugins {
    kotlin("jvm") apply false
}

group = "com.github.belogolov.kotlin.prof.lessons"
version = "0.0.1"

allprojects {
    repositories {
        mavenCentral()
    }
}

subprojects {
    group = rootProject.group
    version = rootProject.version
}