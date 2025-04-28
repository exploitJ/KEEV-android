import com.android.build.gradle.LibraryExtension
import com.hmhz.keev.alias
import com.hmhz.keev.configureGradleManagedDevices
import com.hmhz.keev.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                alias(libs.plugins.keev.android.library)
                alias(libs.plugins.keev.hilt)
                alias(libs.plugins.kotlin.serialization)
            }

            extensions.configure<LibraryExtension> {
                testOptions.animationsDisabled = true
                configureGradleManagedDevices(this)
            }

            dependencies {
                "implementation"(project(":core:ui"))
                "implementation"(project(":core:designsystem"))

                "implementation"(libs.hilt.navigation.compose)
                "implementation"(libs.androidx.lifecycle.runtime.compose)
                "implementation"(libs.androidx.lifecycle.viewmodel.compose.android)
                "implementation"(libs.androidx.navigation.compose)
                "implementation"(libs.kotlinx.serialization.json)

                "testImplementation"(libs.androidx.navigation.testing)
            }
        }
    }
}
