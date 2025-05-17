plugins {
    alias(libs.plugins.keev.android.application)
    alias(libs.plugins.keev.android.application.compose)
    alias(libs.plugins.keev.android.application.flavors)
}

android {
    namespace = "com.hmhz.keev.app_catalog"

    defaultConfig {
        applicationId = "com.hmhz.keev.app_catalog"
        versionCode = 1
        versionName = "1.0"

    }
}

dependencies {
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.core)

    implementation(projects.core.designsystem)
}