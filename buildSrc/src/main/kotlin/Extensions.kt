import org.gradle.api.artifacts.dsl.RepositoryHandler
import org.gradle.kotlin.dsl.kotlin
import org.gradle.plugin.use.PluginDependenciesSpec
import org.gradle.plugin.use.PluginDependencySpec

/**Apply Maven to a repository*/
fun RepositoryHandler.maven(url: String) {
    maven {
        setUrl(url)
    }
}

fun RepositoryHandler.applyDefault() {
    google()
    jcenter()
    mavenCentral()
}

/**Plugin Extensions*/
//Apply Android
val PluginDependenciesSpec.applyAndroidApplication: PluginDependencySpec
    get() = id("com.android.application")

//Apply kotlin android
val PluginDependenciesSpec.applyKotlinAndroid: PluginDependencySpec
    get() = kotlin("android")

//apply kotlin android extension
val PluginDependenciesSpec.applyKotlinAndroidExtension: PluginDependencySpec
    get() = kotlin("android.extension")
