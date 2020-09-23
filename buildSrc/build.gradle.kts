plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

repositories {
    mavenCentral()
    google()
    jcenter()
}

object Plugins {
    object Version {
        const val gradle = "4.2.0-alpha12"
        const val kotlin = "1.4.0"
    }

    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.kotlin}"
    const val gradle = "com.android.tools.build:gradle:${Version.gradle}"
}

dependencies {
    implementation(Plugins.gradle)
    implementation(Plugins.kotlin)
}