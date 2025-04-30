plugins {
    alias(libs.plugins.keev.android.library)
    alias(libs.plugins.keev.android.library.compose)
}

android {
    namespace = "com.hmhz.keev.core.designsystem"
}

dependencies {
    api(libs.androidx.material3)
    api(libs.androidx.materialIconsExtended)

    implementation(libs.coil.compose)

    testImplementation(libs.androidx.ui.test.junit4)
    testImplementation(libs.androidx.ui.test.manifest)

}