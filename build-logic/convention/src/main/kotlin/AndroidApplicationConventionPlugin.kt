import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.variant.ApplicationAndroidComponentsExtension
import com.hmhz.keev.alias
import com.hmhz.keev.configureGradleManagedDevices
import com.hmhz.keev.configureKotlinAndroid
import com.hmhz.keev.configurePrintApksTask
import com.hmhz.keev.libs
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.jvm.toolchain.JavaLanguageVersion
import org.gradle.jvm.toolchain.JavaToolchainService
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.UsesKotlinJavaToolchain

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                alias(libs.plugins.android.application)
                alias(libs.plugins.kotlin.android)
            }

            extensions.configure<ApplicationExtension> {
                configureKotlinAndroid(this)
                defaultConfig.targetSdk = libs.versions.targetSdk.get().toInt()
                testOptions.animationsDisabled = true
                configureGradleManagedDevices(this)
            }

            val launcher = extensions.getByType<JavaToolchainService>().launcherFor {
                languageVersion.set(JavaLanguageVersion.of(21))
            }

            tasks.withType<UsesKotlinJavaToolchain>().configureEach {
                kotlinJavaToolchain.toolchain.use(launcher)
            }

            extensions.configure<ApplicationAndroidComponentsExtension> {
                configurePrintApksTask(this)
            }
        }
    }
}
