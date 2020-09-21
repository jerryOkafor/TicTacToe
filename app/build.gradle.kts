plugins {
    applyAndroidApplication
    applyKotlinAndroid
}

android {
    compileSdkVersion(Config.Version.compileSDK)
    buildToolsVersion(Config.Version.buildTools)

    defaultConfig {
        applicationId(Config.Android.applicationId)
        minSdkVersion(Config.Version.minSDK)
        targetSdkVersion(Config.Version.targetSDK)
        versionCode(Config.Version.versionCode)
        versionName(Config.Version.versionName)

        testInstrumentationRunner(Config.Android.testInstrumentationRunner)
    }

    buildTypes {
        named("debug") {
            isMinifyEnabled = false
            proguardFiles("proguard-android-optimize.txt", "proguard-rules.pro")
            isTestCoverageEnabled = true
        }

        named("release") {
            isMinifyEnabled = false
            proguardFiles("proguard-android-optimize.txt", "proguard-rules.pro")
            isTestCoverageEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
        useIR = true
    }

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = AndroidX.Version.compose
        kotlinCompilerVersion = Kotlin.Version.kotlin
    }
}

dependencies {
    implementation(Kotlin.stdlib)

    implementation(AndroidX.coreKtx)

    implementation(AndroidX.activityKtx)
    implementation(AndroidX.fragmentKtx)
    implementation(AndroidX.appComppat)

    implementation(AndroidX.composeUI)
    implementation(AndroidX.composeMaterial)
    implementation(AndroidX.UITooling)
    implementation(AndroidX.lifeCycleRuntime)

    implementation(View.material)

    testImplementation(Test.junit)

    androidTestImplementation(AndroidTest.testExtension)
    androidTestImplementation(AndroidTest.espresso)
}