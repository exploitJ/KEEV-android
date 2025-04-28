import com.hmhz.keev.alias
import com.hmhz.keev.configureKotlinJvm
import com.hmhz.keev.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.dependencies

class JvmLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {

            with(pluginManager) {
                alias(libs.plugins.kotlin.jvm)
            }

            configureKotlinJvm()
            dependencies {
                "testImplementation"(libs.kotlin.test)
            }
        }
    }
}
