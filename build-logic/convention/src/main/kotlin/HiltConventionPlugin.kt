import com.hmhz.keev.alias
import com.hmhz.keev.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class HiltConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                alias(libs.plugins.hilt)
                alias(libs.plugins.ksp)
            }

            dependencies {
                "ksp"(libs.hilt.compiler)
                "ksp"(libs.hilt.compiler.androidx)
                "implementation"(libs.hilt)

                "kspAndroidTest"(libs.hilt.compiler)
                "androidTestImplementation"(libs.hilt.testing)

                "kspTest"(libs.hilt.compiler)
                "testImplementation"(libs.hilt.testing)
            }
        }
    }
}
