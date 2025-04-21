package com.hmhz.keev

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

/**
 * Configure Compose-specific options
 */
internal fun Project.configureAndroidCompose(
    commonExtension: CommonExtension<*, *, *, *, *, *>,
) {
    commonExtension.apply {
        buildFeatures {
            compose = true
        }

        dependencies {
            val bom = platform(libs.androidx.compose.bom)
            "implementation"(bom)
            "androidTestImplementation"(bom)
            "implementation"(libs.androidx.ui.tooling.preview)
            "debugImplementation"(libs.androidx.ui.tooling)
        }
    }
}
