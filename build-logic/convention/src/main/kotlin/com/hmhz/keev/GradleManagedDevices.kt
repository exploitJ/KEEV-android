package com.hmhz.keev

import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.ManagedVirtualDevice
import org.gradle.kotlin.dsl.get
import org.gradle.kotlin.dsl.invoke

/**
 * Configure project for Gradle managed devices
 */
internal fun configureGradleManagedDevices(
    commonExtension: CommonExtension<*, *, *, *, *, *>,
) {
    val pixel4 = DeviceConfig("Pixel 4", 30, "aosp-atd")
    val pixel9 = DeviceConfig("Pixel 9 Pro XL", 36, "google")
    val pixelTablet = DeviceConfig("Pixel Tablet", 33, "aosp-atd")

    val deviceList = listOf(pixel4, pixel9, pixelTablet)
    val ciDevices = listOf(pixel4, pixelTablet)

    commonExtension.testOptions {
        managedDevices {
            localDevices {
                deviceList.forEach { deviceConfig ->
                    create(deviceConfig.taskName) {
                        device = deviceConfig.device
                        apiLevel = deviceConfig.apiLevel
                        systemImageSource = deviceConfig.systemImageSource
                    }
                }
            }
            groups {
                maybeCreate("ci").apply {
                    ciDevices.forEach { deviceConfig ->
                        targetDevices.add(allDevices[deviceConfig.taskName])
                    }
                }
            }
        }
    }
}

private data class DeviceConfig(
    val device: String,
    val apiLevel: Int,
    val systemImageSource: String,
) {
    val taskName = buildString {
        append(device.lowercase().replace(" ", ""))
        append("api")
        append(apiLevel.toString())
        append(systemImageSource.replace("-", ""))
    }
}
