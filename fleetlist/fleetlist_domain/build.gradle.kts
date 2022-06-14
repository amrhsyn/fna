plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    "implementation"(project(Modules.core))
    "implementation"(Coroutines.coroutines)
    implementation(Build.javaxInject)
    implementation(Build.gradleApi)
    implementation(Testing.junit4)
}