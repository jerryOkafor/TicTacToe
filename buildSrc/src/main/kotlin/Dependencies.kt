/**Default and Adroid Config*/
object Config {
    object Version {
        const val minSDK = 23
        const val compileSDK = 29
        const val targetSDK = 29
        const val versionName = "1.0"
        const val versionCode = 1
        const val buildTools = "30.0.2"
    }

    const val isMultiDexEnabled = true

    object Android {
        const val applicationId = "com.jerryokafor.tictactoe"
        const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

/**Help handle group of libraries*/
interface Libraries {
    val components: List<String>
}

/**Kotlin*/
object Kotlin : Libraries {
    object Version {
        const val kotlin = "1.4.0"
        const val coroutine = "1.3.9"
    }

    const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Version.kotlin}"
    const val coroutineCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.coroutine}"
    const val coroutineAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.coroutine}"
    const val coroutineTest =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Version.coroutine}"

    override val components = listOf(stdlib, coroutineCore, coroutineAndroid, coroutineTest)
}


/**Desugar*/
object Desugar : Libraries {
    object Version {
        const val desugar = "1.0.9"
    }

    const val desugaring = "com.android.tools:desugar_jdk_libs:${Version.desugar}"

    override val components = listOf(desugaring)

}


object AndroidX : Libraries {
    object Version {
        const val coreKtx = "1.3.1"
        const val appCompat = "1.2.0"
        const val lifeCycle = "2.3.0-alpha06"
        const val coreTesting = "2.1.0"
        const val compose = "1.0.0-alpha02"
    }

    const val coreKtx = "androidx.core:core-ktx:${Version.coreKtx}"
    const val appComppat = "androidx.appcompat:appcompat:${Version.appCompat}"

    const val lifeCycleRuntime =
        "androidx.lifecycle:lifecycle-runtime-ktx:${Version.lifeCycle}"
    const val coreTesting = "androidx.arch.core:core-testing:${Version.coreTesting}"

    const val composeUI = "androidx.compose.ui:ui:${Version.compose}"
    const val composeMaterial = "androidx.compose.material:material:${Version.compose}"
    const val UITooling = "androidx.ui:ui-tooling:${Version.compose}"

    override val components = listOf(coreKtx, appComppat)
}

/**View*/
object View : Libraries {
    private object Version {
        const val material = "1.2.0"
    }

    const val material = "com.google.android.material:material:${Version.material}"

    override val components = listOf(material)
}

/**Test*/
object Test : Libraries {
    object Versions {
        const val junit = "4.13"
    }

    const val junit = "junit:junit:${Versions.junit}"
    override val components = listOf(junit)
}

/**Android Test*/
object AndroidTest : Libraries {
    object Versions {
        const val testExtension = "1.1.1"
        const val espresso = "3.2.0"
    }

    const val testExtension = "androidx.test.ext:junit:${Versions.testExtension}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"

    override val components = listOf(testExtension, espresso)
}
