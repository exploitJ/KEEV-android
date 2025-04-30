plugins {
    alias(libs.plugins.keev.android.library)
    alias(libs.plugins.keev.hilt)
}

android {
    namespace = "com.hmhz.keev.core.domain"
}

dependencies {

    implementation(libs.androidx.core)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso)
}