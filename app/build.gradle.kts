import com.hmhz.keev.KeevBuildType
import org.jetbrains.kotlin.konan.file.File
import org.jetbrains.kotlin.konan.properties.loadProperties

plugins {
    alias(libs.plugins.keev.android.application)
    alias(libs.plugins.keev.android.application.compose)
    alias(libs.plugins.keev.android.application.flavors)
    alias(libs.plugins.keev.android.room)
    alias(libs.plugins.keev.hilt)
}

val keystoreProperties = File(
    rootProject.file("keystore.properties").toPath(),
).loadProperties()

android {
    namespace = "com.hmhz.keev"

    defaultConfig {
        applicationId = "com.hmhz.keev"
        versionCode = 1
        versionName = "0.0.1"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    signingConfigs {
        create("production") {
            storeFile = file(keystoreProperties["storeFile"] as String)
            storePassword = keystoreProperties["storePassword"] as String
            keyAlias = keystoreProperties["keyAlias"] as String
            keyPassword = keystoreProperties["keyPassword"] as String
        }
    }

    buildTypes {
        debug {
            applicationIdSuffix = KeevBuildType.DEBUG.applicationIdSuffix
        }
        release {
            applicationIdSuffix = KeevBuildType.RELEASE.applicationIdSuffix
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"))

            signingConfig = signingConfigs.named("production").get()
        }
    }

    compileOptions {
        isCoreLibraryDesugaringEnabled = true
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    val composeBom = platform(libs.androidx.compose.bom)
    implementation(composeBom)
    androidTestImplementation(composeBom)

    implementation(libs.hilt)
    implementation(libs.hilt.navigation.compose)
    implementation(libs.hilt.work)
    ksp(libs.hilt.compiler)
    ksp(libs.hilt.compiler.androidx)

    androidTestImplementation(libs.hilt.testing)
    kspAndroidTest(libs.hilt.compiler)

    testImplementation(libs.hilt.testing)
    kspTest(libs.hilt.compiler)

    implementation(libs.androidx.core)
    implementation(libs.androidx.lifecycle.runtime)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso)
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    ksp(libs.androidx.room.compiler)
}