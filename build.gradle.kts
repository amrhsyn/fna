buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Build.androidBuildTools)
        classpath(Build.hiltAndroidGradlePlugin)
        classpath(Kotlin.kotlinGradlePlugin)


    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
