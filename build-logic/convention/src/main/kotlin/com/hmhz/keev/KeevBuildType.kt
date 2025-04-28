package com.hmhz.keev

/**
 * This is shared between :app and :benchmarks module to provide configurations type safety.
 */
enum class KeevBuildType(val applicationIdSuffix: String? = null) {
    DEBUG(".debug"),
    RELEASE,
}
