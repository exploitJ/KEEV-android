package com.hmhz.keev.core.designsystem.theme

import androidx.compose.ui.graphics.Color

// Grayscale
val Black = Color(0xFF181818)
val Gray900 = Color(0xFF222222) // 900
val Gray800 = Color(0xFF323232) // 800
val Gray700 = Color(0xFF4C4C4C) // 700
val Gray500 = Color(0xFF818181) // 500
val Gray300 = Color(0xFFB5B5B5) // 300
val Gray100 = Color(0xFFEAEAEA) // 100
val Gray50 = Color(0xFFF7F7F7) // 50

// Brand Colors
val BrandColor50 = Color(0xFFE6E0FF)  // Brand 50
val BrandColor500 = Color(0xFF222222)  // Brand 500
val BrandColor500a50 = BrandColor500.copy(alpha = 0.5f)
val BrandColor500a20 = BrandColor500.copy(alpha = 0.2f)

// Alert Colors
val Info = Color(0xFF4D7FFF)  // Info
val Success = Color(0xFF1FB845)  // Success
val Warning = Color(0xFFE6E623)  // Warning
val Error = Color(0xFFE6234C)  // Error

// Semantic colors - convenience aliases for specific use cases
object AppColors {
    // Semantic surface colors
    val surfacePrimary = Gray50
    val surfaceSecondary = Gray100
    val surfaceTertiary = Gray300

    // Content blocks - for cards, dialogs, etc.
    val contentPrimary = Gray800
    val contentSecondary = Gray700
    val contentTertiary = Gray500

    // Text colors
    val textPrimary = Black
    val textSecondary = Gray800
    val textTertiary = Gray500
    val textDisabled = Gray300
    val textOnBrand = Gray50

    // Status colors
    val statusInfo = Info
    val statusSuccess = Success
    val statusWarning = Warning
    val statusError = Error

    // Background state colors
    val statePressed = Gray100
    val stateHovered = Gray50.copy(alpha = 0.5f)
    val stateFocused = BrandColor500.copy(alpha = 0.2f)
    val stateDisabled = Gray100
}