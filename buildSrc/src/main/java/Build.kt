object Build {
    private const val androidBuildToolsVersion = "7.0.4"
    const val androidBuildTools = "com.android.tools.build:gradle:$androidBuildToolsVersion"

    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Kotlin.version}"

    private const val hiltAndroidGradlePluginVersion = "2.38.1"
    const val hiltAndroidGradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:$hiltAndroidGradlePluginVersion"


    private const val javaxInjectVersion = "1"
    const val javaxInject = "javax.inject:javax.inject:$javaxInjectVersion"

     private const val gradleApiVersion = "7.3.0-alpha08"
    const val gradleApi = "com.android.tools.build:gradle-api:$gradleApiVersion"


}